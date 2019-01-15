package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {


//
//    @RequestMapping(value = "/doctor.html", method = RequestMethod.GET)
//    public String doctorPage(){
//        return "doctor";
//    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String loginPage(){
        return "accountCard";
    }

    @RequestMapping(value = "/personalpage.html", method = RequestMethod.GET)
    public String cardPage() {
        return "personalPage";
    }

}
