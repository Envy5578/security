package com.focus_group.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.focus_group.security.entities.TokenEntity;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {

}
