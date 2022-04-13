package com.techelevator.model;


import java.util.Map;

public class DictionaryApi {

    private String word;
    private Map<String, String> definitions;

    public DictionaryApi() {
        //empty
    }

    public DictionaryApi(String word, Map<String, String> definitions) {
        this.word = word;
        this.definitions = definitions;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public Map<String, String> getDefinitions() {
        return definitions;
    }
}
