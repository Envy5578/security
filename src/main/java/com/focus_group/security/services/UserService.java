package com.focus_group.security.services;

import com.focus_group.security.dto.RegistrationRequest;
import com.focus_group.security.dto.UserDTO;
import com.focus_group.security.entities.UserEntity;
import com.focus_group.security.enumType.ErrorCode;
import com.focus_group.security.exceptions.BadRequestException;
import com.focus_group.security.mapper.UserMapper;
import com.focus_group.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public Optional<UserEntity> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @SuppressWarnings("null")
    public void save(RegistrationRequest register) {
        Optional<UserEntity> existingUser = repository.findByEmail(register.email());
        if (existingUser.isPresent()) {
            throw new BadRequestException(
                    ErrorCode.EMAIL_ALREADY_REGISTERED
            );
        }

        UserEntity user = UserEntity.builder()
                .firstName(register.firstName())
                .lastName(register.lastName())
                .email(register.email())
                .password(passwordEncoder.encode(register.password()))
                .active(false)
                .build();
        repository.save(user);
    }

    public UserDTO getMe() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UserEntity user = null;
        if (principal instanceof UserDetails) {
            user = (UserEntity) ((UserDetails) principal);
        }
        return UserMapper.toDTO(user);
    }
}
