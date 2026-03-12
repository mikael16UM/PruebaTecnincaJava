package com.miguel.miguel.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String name;
    private String phone;
    private String password;
    private String tax_id;

    @ManyToOne
    private Address addresses;

}
