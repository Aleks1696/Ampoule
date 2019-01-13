package com.web.dao;

import com.web.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByIdEquals(Long id);
    Card findByLoginAndPasswordEquals(String email,String password);
}