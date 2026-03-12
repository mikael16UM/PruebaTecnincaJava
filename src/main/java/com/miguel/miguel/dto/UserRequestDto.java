package com.miguel.miguel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserRequestDto {
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;

    private String phone;

    @NotBlank
    private String tax_id;

}
