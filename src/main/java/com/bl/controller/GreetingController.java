package com.bl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class GreetingController {

    @Autowired
    GreetingService service;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String login(Model model) throws IOException {
        model.addAttribute("Greeting",service.getAll());
        return "index";
    }
}
