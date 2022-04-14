package com.techelevator.services;


import com.techelevator.model.DictionaryApi;

public interface DictionaryService {

    DictionaryApi listWordAndDefinitions(String word);

}
