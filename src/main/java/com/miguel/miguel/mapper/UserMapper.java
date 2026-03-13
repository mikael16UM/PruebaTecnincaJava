package com.miguel.miguel.mapper;

import com.miguel.miguel.dto.AddressResponseDto;
import com.miguel.miguel.dto.UserResponseDto;
import com.miguel.miguel.model.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {

    public static UserResponseDto toUserResponseDto(User user) {
        if  (user == null) return null;
        List<AddressResponseDto> addresses =
                user.getAddresses() == null ? Collections.emptyList() : user.getAddresses().stream().map(AddressMapper::toAddressResponsetDto).collect(Collectors.toList());

        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .phone(user.getPhone())
                .taxId(user.getTaxId())
                .addresses(addresses)
                .build();
    }

}

