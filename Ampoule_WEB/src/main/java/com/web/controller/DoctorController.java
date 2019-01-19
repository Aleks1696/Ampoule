package com.web.controller;

import com.web.dao.CardRepository;
import com.web.dao.DoctorRepository;
import com.web.domain.Card;
import com.web.domain.Doctor;
import com.web.domain.types.DoctorsType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        System.out.println(request.getDateHeader("email"));
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


}
