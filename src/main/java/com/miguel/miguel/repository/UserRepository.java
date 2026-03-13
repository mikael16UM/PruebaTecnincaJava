package com.miguel.miguel.repository;

import com.miguel.miguel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID> {
    boolean existsByTaxId(String taxId);
}
