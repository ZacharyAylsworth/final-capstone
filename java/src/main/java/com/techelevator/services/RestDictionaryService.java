package com.techelevator.services;

import com.techelevator.model.CardNotFoundException;
import com.techelevator.model.Cards;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestDictionaryService implements DictionaryService {
    private static final String API_BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Cards getCard() {
        Cards card = null;
        try {
            card = restTemplate.getForObject(API_BASE_URL, Cards.class);

        } catch (CardNotFoundException e) {

        } return card;
    }
}
