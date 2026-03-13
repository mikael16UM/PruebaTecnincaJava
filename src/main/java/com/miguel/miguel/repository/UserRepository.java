package com.miguel.miguel.repository;

import com.miguel.miguel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID>, JpaSpecificationExecutor<User> {
    boolean existsByTaxId(String taxId);
}
