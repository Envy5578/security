package com.focus_group.security.services;

import com.focus_group.security.entities.UserEntity;
import com.focus_group.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
