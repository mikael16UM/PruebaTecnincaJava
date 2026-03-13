package com.miguel.miguel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(
            regexp = "^(\\+?[1-9][0-9]{9,11})",
            message = "phone must be a valid 10 digit number with optional country code"
    )
    private String phone;

    @Pattern(
            regexp = "^[A-ZÑ&]{3,4}[0-9]{6}[A-Z0-9]{3}$",
            message = "tax_id must follow RFC format"
    )
    private String taxId;

    private List<AddressRequestDto> addresses= new ArrayList<>();

}
