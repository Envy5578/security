package com.focus_group.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.focus_group.security.entitys.TokenEntity;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {
    
}
