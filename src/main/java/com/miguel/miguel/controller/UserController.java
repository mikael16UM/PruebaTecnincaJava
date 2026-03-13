package com.miguel.miguel.controller;

import com.miguel.miguel.dto.UserPatchDto;
import com.miguel.miguel.dto.UserRequestDto;
import com.miguel.miguel.dto.UserResponseDto;

import com.miguel.miguel.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {

    private final UserService user_service;
    public UserController(UserService user_service) {
        this.user_service = user_service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto user_request_dto) {
        UserResponseDto user_response_dto = user_service.createUser(user_request_dto);
        return ResponseEntity.created(URI.create("/api/v1/users" + user_response_dto.getId())).body(user_response_dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        user_service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id, @RequestBody UserPatchDto user_patch_dto) {
        UserResponseDto updatedUser = user_service.patchUser(id, user_patch_dto);

        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(@RequestParam(required = false) String sorted_by) {
        List<UserResponseDto> user_sorted_list = user_service.getAllUsers(sorted_by);

       return ResponseEntity.ok(user_sorted_list);
    }
}
