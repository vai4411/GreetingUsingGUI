package com.bl.service;

import com.bl.model.Greeting;
import com.bl.util.TemplateManager;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.bl.util.TemplateManager.getTemplate;

@Service
public class GreetingServiceImpl implements IGreetingService {

    @Override
    public List getAllGreeting() {
        String greeting = getTemplate().exchange("http://localhost:8081/greeting/list",
                HttpMethod.GET, TemplateManager.getEntity(), String.class).getBody();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(greeting, new TypeReference<List<Greeting>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteGreeting(int id) {
        getTemplate().exchange("http://localhost:8081/greeting/delete/"+id,
                HttpMethod.DELETE, TemplateManager.getEntity(), String.class).getBody();
    }

    @Override
    public Greeting addGreeting(String firstName, String lastName)  {
        TemplateManager.getTemplate()
                .setMessageConverters(TemplateManager.getConverter());
        Greeting addGreeting = new Greeting();
        addGreeting.setName(firstName+" "+lastName);
        HttpEntity<Greeting> request = new HttpEntity<>(addGreeting, TemplateManager.getHeader());
        ResponseEntity<Greeting> result = TemplateManager.getTemplate()
                .postForEntity("http://localhost:8081/greeting/add", request, Greeting.class);
        return result.getBody();
    }

    @Override
    public Greeting updateGreeting(int id, String firstName, String lastName) {
        TemplateManager.getTemplate().setMessageConverters(TemplateManager.getConverter());
        Greeting updateGreeting = new Greeting();
        updateGreeting.setName(firstName+" "+lastName);
        HttpEntity<Greeting> request = new HttpEntity<>(updateGreeting, TemplateManager.getHeader());
        ResponseEntity<Greeting> result = TemplateManager.getTemplate()
                .exchange("http://localhost:8081/greeting/update/"+id,
                HttpMethod.PUT, request, Greeting.class);
        return result.getBody();
    }
}
