package com.bl.service;

import com.bl.model.Greeting;
import com.bl.util.TemplateManager;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GreetingServiceImpl implements IGreetingService {

    public List getAll() {
        String greeting = TemplateManager.getTemplate().exchange("http://localhost:8081/greeting/list",
                HttpMethod.GET, TemplateManager.getEntity(), String.class).getBody();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(greeting, new TypeReference<List<Greeting>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
