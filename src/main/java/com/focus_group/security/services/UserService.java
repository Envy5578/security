package com.focus_group.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.focus_group.security.entitys.UserEntity;
import com.focus_group.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        UserEntity user = repository.findByFirstName(firstName)
        .orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' found", firstName))
        );
        return UserEntity.build(user);
    }
    
}
