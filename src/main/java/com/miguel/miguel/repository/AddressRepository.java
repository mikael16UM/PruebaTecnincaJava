package com.miguel.miguel.repository;

import com.miguel.miguel.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
