package com.miguel.miguel.dto;

import com.miguel.miguel.model.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AddressRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String country_code;


}
