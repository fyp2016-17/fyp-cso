package com.test.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Abubakr on 4/9/2017.
 */
@Controller
public class CopyController {

    @RequestMapping(value = "/about")
    public String about(){
        return "copy/about";
    }
}
