package com.miguel.miguel.service;

import com.miguel.miguel.dto.UserPatchDto;
import com.miguel.miguel.dto.UserRequestDto;
import com.miguel.miguel.dto.UserResponseDto;
import com.miguel.miguel.repository.UserRepository;
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
        return user_repository.findAll();
    }

    @Override
    public UserRequestDto createUser(UserRequestDto user_request_dto) {
        return null;
    }

    @Override
    public UserPatchDto patchUser(UUID id, UserPatchDto user_patch_dto) {
        return null;
    }

    @Override
    public UserResponseDto getUser(UUID id) {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {

    }
}
