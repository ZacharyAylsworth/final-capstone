package com.techelevator.services;

import com.techelevator.model.DictionaryApi;
import org.springframework.web.client.RestTemplate;



public class RestDictionaryService /*implements DictionaryService*/ {
    private static final String API_BASE_URL = "https://wordsapiv1.p.mashape.com/words/";
    private final RestTemplate restTemplate = new RestTemplate();


    public DictionaryApi[] getWordAndDefinitionsByWord(String word) {
        return restTemplate.getForObject(API_BASE_URL + word + "/definitions" , DictionaryApi[].class);
    }

//    public DictionaryApi getWithCustomQuery() {
//    //use this as the copy-paste method?
//
//    }


// the interface is listing an empty method. prob why its mad
    //interfaces in other homeworks don't exist?? do I need one?


//    @Override
//    public CatPic getPic() {
//        return restTemplate.getForObject("https://cat-data.netlify.app/api/pictures/random", CatPic.class);
//    }
}


