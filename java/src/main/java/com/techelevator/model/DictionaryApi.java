package com.techelevator.model;

import org.springframework.web.client.RestTemplate;

public class DictionaryApi {
    private String word;
    private String definition;

    DictionaryApi response = restTemplate.getForObject(
            "https://api.exchangerate-api.com/v4/latest/USD",
            DictionaryApi.class);
}
