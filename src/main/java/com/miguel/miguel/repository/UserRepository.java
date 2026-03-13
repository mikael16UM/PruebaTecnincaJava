package com.miguel.miguel.repository;

import com.miguel.miguel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository<UUID> extends JpaRepository<User, UUID> {

}
