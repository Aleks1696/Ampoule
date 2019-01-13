package com.web.service;

import com.web.dao.CardRepository;
import com.web.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Long createCard(Card card) {

        return cardRepository.saveAndFlush(card).getId();
    }

    public boolean cardSingIn(String login, String password) {


        return false;
    }

    public Card getCard(Long id) {
        return cardRepository.findByIdEquals(id);
    }

    public void update(Card card) {

        cardRepository.saveAndFlush(card);
    }

    public void deleteNote(Long id) {
        cardRepository.delete(id);
    }

    public List<Card> findAllCard() {
        return cardRepository.findAll();
    }
}
