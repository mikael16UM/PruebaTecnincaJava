package com.miguel.miguel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPatchDto {

    @Email
    private String email;
    private String name;
    private String phone;
    private String password;
}
