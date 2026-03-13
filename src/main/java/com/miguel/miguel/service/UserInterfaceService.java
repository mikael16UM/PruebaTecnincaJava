package com.miguel.miguel.service;

import com.miguel.miguel.dto.UserPatchDto;
import com.miguel.miguel.dto.UserRequestDto;
import com.miguel.miguel.dto.UserResponseDto;
import com.miguel.miguel.model.User;

import java.util.List;
import java.util.UUID;

public interface UserInterfaceService {

    List<UserResponseDto> getFilteredUsers(String filter);

    List<UserResponseDto> getSortedUsers(String sorted_by);

    UserResponseDto createUser(UserRequestDto user_request_dto);

    UserResponseDto patchUser(UUID id, UserPatchDto user_patch_dto);

    UserResponseDto getUser(UUID id);

    void deleteUser(UUID id);
}
