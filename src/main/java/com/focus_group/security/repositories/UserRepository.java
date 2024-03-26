package com.focus_group.security.repositories;

import com.focus_group.security.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @SuppressWarnings("null")
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByFirstName(String username);

    Optional<UserEntity> findByEmail(String email);

}
