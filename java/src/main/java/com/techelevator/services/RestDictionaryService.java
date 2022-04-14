package com.techelevator.services;

import com.techelevator.model.DictionaryApi;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class RestDictionaryService implements DictionaryService {
    private static final String API_BASE_URL = "https://wordsapiv1.p.rapidapi.com/words/";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public DictionaryApi listWordAndDefinitions(String word) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Host","wordsapiv1.p.rapidapi.com");
        headers.add("X-RapidAPI-Key","c44e24833dmsh8cfcade921013d2p1a2a54jsn0bf3ea9e6220");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<DictionaryApi> response = restTemplate.exchange(API_BASE_URL + word + "/definitions", HttpMethod.GET, request, DictionaryApi.class);
        return response.getBody();
        //return restTemplate.getForObject(API_BASE_URL + word + "/definitions" , DictionaryApi[].class);
    }
}


