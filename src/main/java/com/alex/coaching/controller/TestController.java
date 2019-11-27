package com.alex.coaching.controller;


import com.alex.coaching.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/hello")
    public String test(){
        return "/list";
    }
}
