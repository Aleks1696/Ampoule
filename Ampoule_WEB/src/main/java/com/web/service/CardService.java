package com.web.service;

import com.web.domain.Card;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CardService {
    Long createCard(Card card);

    boolean cardSingIn(String login, String password);

    Card getCard(Long id);

    void update(Card card);

    void deleteNote (Long id);

    List<Card> findAllCard();




}
