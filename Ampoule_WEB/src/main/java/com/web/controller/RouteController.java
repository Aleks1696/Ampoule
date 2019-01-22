package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    @RequestMapping(value = "/ampoule.html", method = RequestMethod.GET)
    public String loginPage() {
        return "accountCard";
    }

    @RequestMapping(value = "/personalPage.html", method = RequestMethod.GET)
    public String cardPage() {
        return "personalPage";
    }

    @RequestMapping(value = "/registrationCard.html", method = RequestMethod.GET)
    public String cardRegistration() {
        return "registrationCard";
    }

    @RequestMapping(value = "/doctor.html", method = RequestMethod.GET)
    public String doctorAuthorizationPage(){
        return "doctorAuthorization";
    }

    @RequestMapping(value = "/doctorRegistration.html", method = RequestMethod.GET)
    public String doctorRegistrationPage(){
        return "doctorRegistration";
    }

    @RequestMapping(value = "/doctorPage.html", method = RequestMethod.GET)
    public String doctorPage(){
        return "doctorPage";
    }
}
