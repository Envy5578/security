package com.focus_group.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.focus_group.security.entities.UserEntity;




@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @SuppressWarnings("null")
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByEmail(String email);
    
    

}
