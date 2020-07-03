package com.bl.service;

import java.util.List;

public interface IGreetingService {
    List getAll();
    void deleteGreeting(int id);
}
