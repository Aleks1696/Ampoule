package com.web.controller;

import com.web.dao.CardRepository;
import com.web.dao.DoctorRepository;
import com.web.domain.Card;
import com.web.domain.Doctor;
import com.web.domain.types.DoctorsType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DoctorController {

    private DoctorRepository doctorRepository;
    private CardRepository cardRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository, CardRepository cardRepository) {
        this.doctorRepository = doctorRepository;
        this.cardRepository = cardRepository;
    }


    @RequestMapping(value = "/doctor/authorization", method = RequestMethod.GET)
    public @ResponseBody
    Boolean authorizeDoctor(
            @RequestParam String email,
            @RequestParam String password,
            HttpServletRequest request, HttpServletResponse response) {
        Doctor doctor = doctorRepository.findByEmailAndPasswordEquals(
                request.getParameter("email"), request.getParameter("password")
        );

        //добавляем в сессию данные доктора
        HttpSession session = request.getSession();
        session.setAttribute("id", doctor.getId());
        session.setAttribute("email", doctor.getEmail());
        session.setAttribute("name", doctor.getName());
        session.setAttribute("surname", doctor.getSurname());
        session.setAttribute("doctorType", doctor.getDoctorsType());
        session.setAttribute("phoneNumber", doctor.getPhoneNumber());
        session.setAttribute("cards", doctor.getCards());

        return (doctor != null) ? true : false;
    }

    @RequestMapping(value = "/doctor/registration", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam DoctorsType doctorType,
            @RequestParam String phoneNumber,
            HttpServletRequest request, HttpServletResponse response) {
        doctorRepository.saveAndFlush(new Doctor(email, password, name, surname, doctorType, phoneNumber));
    }

    @RequestMapping(value = "/doctor/get/card", method = RequestMethod.GET)
    public @ResponseBody
    JSONObject getCardById(
            @RequestParam Long id) {
        Card card = cardRepository.findOne(id);
        if (card == null) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", card.getId());
        jsonObject.put("name", card.getName());
        jsonObject.put("surname", card.getSurname());
        jsonObject.put("gender", card.getGender());
        jsonObject.put("birthday", card.getBirthday().toString());
        jsonObject.put("height", card.getHeight());
        jsonObject.put("weight", card.getWeight());
        return jsonObject;
    }

    @RequestMapping(value = "/doctor/get/all/cards", method = RequestMethod.GET)
    public @ResponseBody
    JSONArray getAllCards() {
        List<Card> cards = cardRepository.findAll();

        JSONArray jsonArray = new JSONArray();
        for (Card card : cards) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", card.getId());
            jsonObject.put("name", card.getName());
            jsonObject.put("surname", card.getSurname());
            jsonObject.put("gender", card.getGender());
            jsonObject.put("birthday", card.getBirthday());
            jsonObject.put("height", card.getHeight());
            jsonObject.put("weight", card.getWeight());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @RequestMapping(value = "/doctor/get/active", method = RequestMethod.GET)
    public @ResponseBody
    JSONObject getCurrentDoctor(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", session.getAttribute("id"));
        jsonObject.put("name", session.getAttribute("name"));
        jsonObject.put("surname", session.getAttribute("surname"));

        return jsonObject;
    }


}
