package com.bl.controller;

import com.bl.service.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class GreetingController {

    @Autowired
    GreetingServiceImpl service;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String getAllGreetings(Model model) {
        model.addAttribute("Greeting",service.getAll());
        return "index";
    }

    @RequestMapping(path = "/delete",method = RequestMethod.POST)
    public String deleteGreeting(@RequestParam int id, Model model) {
        service.deleteGreeting(id);
        model.addAttribute("Greeting",service.getAll());
        return "index";
    }
}
