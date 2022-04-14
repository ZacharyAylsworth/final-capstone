package com.techelevator.ApiTests;

import com.techelevator.model.DictionaryApi;
import com.techelevator.services.RestDictionaryService;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class DictionaryApiTests {

    @Test
    public void ProvideDefinition_GivenWord() {
        //ARRANGE
        RestDictionaryService rdService = new RestDictionaryService();

        //ACT
        DictionaryApi wordObject = rdService.listWordAndDefinitions("hello");

        //ASSERT
        assertEquals("hello", wordObject.getWord());

    }



}
