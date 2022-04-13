package com.techelevator.ApiTests;

import com.techelevator.model.DictionaryApi;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

public class DictionaryApiTests {

    @Test
    public void ProvideDefinition_GivenWord() {
        //ARRANGE
        DictionaryApi dictionaryApi = new DictionaryApi();

        //ACT
        String word = dictionaryApi.getWord("hello");

        //ASSERT
        assertEquals();

    }

}
