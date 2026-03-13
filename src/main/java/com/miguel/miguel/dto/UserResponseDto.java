package com.miguel.miguel.dto;

import com.miguel.miguel.model.Address;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private UUID id;
    private String email;
    private String name;
    private String phone;
    private String taxId;

    private List<AddressResponseDto> addresses;
}
