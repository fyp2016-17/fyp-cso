package com.test.web.controllers;

import com.test.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Abubakr on 4/9/2017.
 */
@Controller
public class LoginController {

    public static final String LOGIN_VIEW_NAME = "user/login";


    @RequestMapping(value={"/login"} , method = RequestMethod.GET)
    public String login( ){

        return LOGIN_VIEW_NAME;
    }



}

//    public ModelAndView login(
//            @RequestParam(value = "error", required = false) String error,
//            @RequestParam(value = "logout", required = false) String logout) {
//        ModelAndView model = new ModelAndView();
//        if (error != null) {
//            model.addObject("error", "Invalid username and password!");
//        }
//
//        if (logout != null) {
//            model.addObject("msg", "You've been logged out successfully.");
//        }
//        model.setViewName("login");