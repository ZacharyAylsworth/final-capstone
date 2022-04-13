package com.techelevator.services;

import com.techelevator.model.DictionaryApi;
import org.springframework.web.client.RestTemplate;



public class RestDictionaryService implements DictionaryService {
    private static final String API_BASE_URL = "https://wordsapiv1.p.mashape.com/words/";
    private final RestTemplate restTemplate = new RestTemplate();


    public DictionaryApi getWord(String word) {
        return restTemplate.getForObject(API_BASE_URL + word + "/definitions" , DictionaryApi[].class);
    }
// word is a string and rest template is returning an object.
// this is probably why its getting mad at the interface.
// the interface is listing a broken method.


//    ExchangeRates response = restTemplate.getForObject(
//            "https://api.exchangerate-api.com/v4/latest/USD",
//            ExchangeRates.class);

//    @Override
//    public CatPic getPic() {
//        return restTemplate.getForObject("https://cat-data.netlify.app/api/pictures/random", CatPic.class);
//    }
}


