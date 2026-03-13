package com.miguel.miguel.service;

import com.miguel.miguel.dto.AddressRequestDto;
import com.miguel.miguel.dto.UserPatchDto;
import com.miguel.miguel.dto.UserRequestDto;
import com.miguel.miguel.dto.UserResponseDto;
import com.miguel.miguel.exception.AlreadyUsedException;
import com.miguel.miguel.exception.NotFoundException;
import com.miguel.miguel.mapper.UserMapper;
import com.miguel.miguel.model.Address;
import com.miguel.miguel.model.User;
import com.miguel.miguel.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserInterfaceService{

    @Autowired
    private UserRepository user_repository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return user_repository.findAll().stream().map(UserMapper::toUserResponseDto).toList();
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
        user.setPassword(user_request_dto.getPassword());//aes256Service.encrypt(user_request_dto.getPassword()));
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
