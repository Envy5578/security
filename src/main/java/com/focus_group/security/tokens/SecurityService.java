package com.focus_group.security.tokens;

import com.focus_group.security.entities.UserEntity;
import com.focus_group.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final UserRepository userRepository;

    public UserEntity getUserFromRequest() {
        return userRepository.findById(Long.valueOf(((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
