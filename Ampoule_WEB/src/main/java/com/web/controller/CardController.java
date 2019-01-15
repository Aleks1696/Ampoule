package com.web.controller;

import com.web.dao.CardRepository;
import com.web.domain.Card;
import com.web.domain.types.HumanGender;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by Anton Platunov 13.01.2019
 */
// Я не знаю,как с фронта передать Енам
@Controller
public class CardController {

    private CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @RequestMapping(value = "/card/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) //201
    public void create(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("gender") HumanGender gender,
            @RequestParam("birthday") Integer birthday,
            @RequestParam("height") Integer height,
            @RequestParam("height") Integer weight) {
        cardRepository.saveAndFlush(new Card(email, password, name, surname, gender, birthday, height, weight));

    }

    @RequestMapping(value = "/card/authorization", method = RequestMethod.GET)
    public @ResponseBody
    Boolean checkCard(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        Card card = cardRepository.findByEmailAndPasswordEquals(email, password);
        if (card != null) {
            return true;
        }
        return false;

    }

    @RequestMapping(value = "/card/get/all", method = RequestMethod.GET)
    public @ResponseBody
    String getAll() {
        List<Card> cards = cardRepository.findAll();

        JSONArray body = new JSONArray();
        for (Card card : cards) {
            JSONObject item = new JSONObject();
            item.put("id", card.getId());
            item.put("email", card.getEmail());
            item.put("name", card.getName());
            item.put("surname", card.getSurname());
            item.put("birthday", card.getBirthday());
            body.add(item);
        }
        return body.toJSONString();
    }


}
