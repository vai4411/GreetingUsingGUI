package com.bl.service;

import com.bl.model.Greeting;

import java.util.List;

public interface IGreetingService {
    List getAllGreeting();
    void deleteGreeting(int id);
    Greeting addGreeting(String firstName, String lastName);
}
