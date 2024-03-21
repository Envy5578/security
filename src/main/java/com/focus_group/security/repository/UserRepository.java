package com.focus_group.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.focus_group.security.entitys.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @SuppressWarnings("null")
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByUsername(String username);

}
