package com.test.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Abubakr on 4/8/2017.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String home(){
        return "index";
    }
}
