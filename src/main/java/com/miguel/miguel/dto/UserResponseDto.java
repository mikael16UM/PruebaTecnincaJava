package com.miguel.miguel.dto;

import com.miguel.miguel.model.Address;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;
import java.util.UUID;

public class UserResponseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String name;
    private String phone;
    private String tax_id;

    private List<Address> addresses;
}
