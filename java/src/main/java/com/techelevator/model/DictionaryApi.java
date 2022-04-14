package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class DictionaryApi {

    private String newWord;
    @JsonProperty("word")
    private String word;
    @JsonProperty("definitions")
    private DefinitionAPI[] definitions;


    //METHODS
//    public DictionaryApi getWordAndDefinitionsByWord() {
//
//
//
//    }



//    public

    //constructors
    public DictionaryApi() {
        //empty
    }

    public DictionaryApi(String word, DefinitionAPI[] definitions) {
        this.word = word;
        this.definitions = definitions;
    }


    //setters + getters
    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public DefinitionAPI[] getDefinitions() {
        return definitions;
    }
}
