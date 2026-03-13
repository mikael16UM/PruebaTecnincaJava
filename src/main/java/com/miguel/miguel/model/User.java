package com.miguel.miguel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "email",  nullable = false)
    private String email;
    @Column(name = "name",  nullable = false, length = 50)
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "tax_id", unique = true)
    private String taxId;
    @CreationTimestamp
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        if (addresses == null) {
            addresses = new ArrayList<>();
        }

        addresses.add(address);
        address.setUser(this);
    }

}
