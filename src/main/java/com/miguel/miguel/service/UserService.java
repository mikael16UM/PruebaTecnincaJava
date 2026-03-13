package com.miguel.miguel.service;

import com.miguel.miguel.dto.AddressRequestDto;
import com.miguel.miguel.dto.UserPatchDto;
import com.miguel.miguel.dto.UserRequestDto;
import com.miguel.miguel.dto.UserResponseDto;
import com.miguel.miguel.exception.AlreadyUsedException;
import com.miguel.miguel.exception.NoFilterException;
import com.miguel.miguel.exception.NotEnoughArgsExeception;
import com.miguel.miguel.exception.NotFoundException;
import com.miguel.miguel.mapper.UserMapper;
import com.miguel.miguel.model.Address;
import com.miguel.miguel.model.User;
import com.miguel.miguel.repository.UserRepository;
import com.miguel.miguel.security.EncryptionSecurity;
import com.miguel.miguel.specification.FilterSpecification;
import com.miguel.miguel.validation.FieldValidation;
import com.miguel.miguel.validation.OperatorValidation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserInterfaceService{

    private final UserRepository user_repository;
    private final EncryptionSecurity encryption_security;

    @Autowired
    public UserService(UserRepository user_repository,
                       EncryptionSecurity encryption_security) {

        this.user_repository = user_repository;
        this.encryption_security = encryption_security;
    }

    @Override
    public List<UserResponseDto> getFilteredUsers(String filter) {
        if (filter == null || filter.isEmpty()) {
            throw new NoFilterException("Filter cannot be null or empty");
        }
        // After we ensured there's no empty filter, we need to split the string to do the actual filter db query

        //We (me and Myself, lol) asumed the arg separation is provided with : between args

        String[] filter_args = filter.split(":", 3);

        if(filter_args.length != 3){
            throw new NotEnoughArgsExeception("Invalid filter format");
        }
        String filter_field = filter_args[0];
        String filter_operator = filter_args[1];
        String filter_value = filter_args[2];

        //validation
        FieldValidation.FieldValidation(filter_field);
        OperatorValidation.OperatorValidation(filter_operator);

        Specification<User> spec =
                FilterSpecification.filterBy(filter_field, filter_operator, filter_value);

        List<User> users = user_repository.findAll(spec);

        return users.stream()
                .map(UserMapper::toUserResponseDto)
                .toList();

    }

    @Override
    public List<UserResponseDto> getSortedUsers(String sorted_by) {

        FieldValidation.FieldValidation(sorted_by);

        if(sorted_by == null || sorted_by.isBlank()) {
            return user_repository.findAll().stream().map(UserMapper::toUserResponseDto).toList();
        }

        Sort sorted_users = Sort.by(Sort.Direction.DESC, sorted_by);

        return user_repository.findAll(sorted_users).stream().map(UserMapper::toUserResponseDto).toList();

    }

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto user_request_dto) {
        if (user_repository.existsByTaxId(user_request_dto.getTaxId().trim().toUpperCase())) {
            throw new AlreadyUsedException("tax_id already exists");
        }

        User user = new User();
        user.setEmail(user_request_dto.getEmail());
        user.setName(user_request_dto.getName());
        user.setPhone(user_request_dto.getPhone());
        user.setPassword(
                encryption_security.encryptPassword(user_request_dto.getPassword())
        );
        user.setTaxId(user_request_dto.getTaxId().trim().toUpperCase());
        user_repository.existsByTaxId(user_request_dto.getTaxId().trim().toUpperCase());


        if (user_request_dto.getAddresses() != null) {
            for (AddressRequestDto address : user_request_dto.getAddresses()) {
                Address new_address = new Address();
                new_address.setName(address.getName());
                new_address.setStreet(address.getStreet());
                new_address.setCountry_code(address.getCountry_code());
                user.addAddress(new_address);
            }
        }

        return UserMapper.toUserResponseDto(user_repository.save(user));
    }

    @Override
    public UserResponseDto patchUser(UUID id, UserPatchDto user_patch_dto) {
        User user = user_repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        if (user_patch_dto.getName() != null){
            user.setName(user_patch_dto.getName());
        }

        if (user_patch_dto.getEmail() != null) {
            user.setEmail(user_patch_dto.getEmail());
        }

        if (user_patch_dto.getPhone() != null) {
            user.setPhone(user_patch_dto.getPhone());
        }

        if (user_patch_dto.getPassword() != null) {
            user.setPassword(user_patch_dto.getPassword());
        }

        User updatedUser = user_repository.save(user);

        return UserMapper.toUserResponseDto(updatedUser);
    }

    @Override
    public UserResponseDto getUser(UUID id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteUser(UUID id) {
        User user = user_repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        user_repository.delete(user);

    }
}
