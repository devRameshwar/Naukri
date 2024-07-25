package com.naukri.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationDto {

    private RestTemplate restTemplate;

    public ApplicationDto(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
