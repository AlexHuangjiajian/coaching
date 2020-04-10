package com.alex.coaching.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/menu.html",method = RequestMethod.GET)
    public String turnMainhtml(){
        return "/menu";
    }
}
