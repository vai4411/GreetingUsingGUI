package com.bl.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class TemplateManager {

    public static RestTemplate getTemplate() {
        RestTemplate template = new RestTemplate();
        return template;
    }

    public static HttpEntity getEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return entity;
    }
}
