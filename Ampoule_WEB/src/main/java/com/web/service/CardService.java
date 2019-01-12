package com.web.service;

import com.web.domain.Card;
import com.web.domain.Note;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CardService {
    Long createCard();

    boolean cardSingIn(String login, String password);

    Card getCard(Long id);

    void update(Card card);

    void deleteNote (Card card);

    List<Card> findAllCard();




}
