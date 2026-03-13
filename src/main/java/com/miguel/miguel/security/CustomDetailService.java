package com.miguel.miguel.security;

import com.miguel.miguel.model.User;
import com.miguel.miguel.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailService implements UserDetailsService {
    private final UserRepository user_repository;

    public CustomDetailService(UserRepository user_repository) {
        this.user_repository = user_repository;
    }
    @Override
    public UserDetails loadUserByUsername (String taxID) throws UsernameNotFoundException {
        User user = user_repository.findByTaxId(taxID).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getTaxId())
                .password(user.getPassword())
                .authorities("USER")
                .build();
    }
}
