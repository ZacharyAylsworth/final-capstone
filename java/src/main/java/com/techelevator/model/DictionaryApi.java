package com.techelevator.model;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class DictionaryApi {
    private String word;
    private String definition;

    DictionaryApi response = restTemplate.getForObject(
            "https://api.exchangerate-api.com/v4/latest/USD",
            DictionaryApi.class);
}
