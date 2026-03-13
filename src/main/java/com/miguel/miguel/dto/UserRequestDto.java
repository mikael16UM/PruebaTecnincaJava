package com.miguel.miguel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;

    private String phone;

    @NotBlank
    private String taxId;

    private List<AddressRequestDto> addresses= new ArrayList<>();

}
