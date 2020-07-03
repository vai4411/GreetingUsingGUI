package com.bl.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class GreetingServiceImpl implements IGreetingService {

    public List getAll() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        String greeting = template.exchange("http://localhost:8081/greeting/list", HttpMethod.GET, entity, String.class).getBody();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(greeting, new TypeReference<List<Greeting>>(){});
    }
}
