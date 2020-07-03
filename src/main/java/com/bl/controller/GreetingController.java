package com.bl.controller;

import com.bl.service.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {

    @Autowired
    private GreetingServiceImpl service;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String getAllGreetings(Model model) {
        model.addAttribute("Greeting",service.getAllGreeting());
        return "index";
    }

    @RequestMapping(path = "/delete",method = RequestMethod.POST)
    public String deleteGreeting(@RequestParam int id, Model model) {
        service.deleteGreeting(id);
        return getAllGreetings(model);
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public String addGreeting(HttpServletRequest request, Model model) {
       service.addGreeting(request.getParameter("firstName"),request.getParameter("lastName"));
       return getAllGreetings(model);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public String updateGreeting(HttpServletRequest request, Model model) {
        service.updateGreeting(Integer.parseInt(request.getParameter("index")),request.getParameter("firstName"),request.getParameter("lastName"));
        return getAllGreetings(model);
    }
}
