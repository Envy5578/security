package com.focus_group.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.focus_group.security.dto.RegistrationRequest;
import com.focus_group.security.entities.UserEntity;
import com.focus_group.security.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email: '%s' found", email))
                );
        return UserEntity.build(user)
        ;
    }
    
    @SuppressWarnings("null")
    public void save(RegistrationRequest register) {
        UserEntity user = UserEntity.builder()
        .firstName(register.firstName())
        .lastName(register.lastName())
        .email(register.email())
        .password(passwordEncoder.encode(register.password()))
        .active(false)
        .build();
        repository.save(user);
    }

}
