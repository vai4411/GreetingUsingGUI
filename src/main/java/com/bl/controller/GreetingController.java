package com.bl.controller;

import com.bl.service.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {

    @Autowired
    GreetingServiceImpl service;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("Greeting",service.getAll());
        return "index";
    }
}
