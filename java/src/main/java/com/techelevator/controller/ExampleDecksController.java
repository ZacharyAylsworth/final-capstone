package com.techelevator.controller;

import com.techelevator.dao.ExampleDecksDao;
import com.techelevator.dao.FlashCardsDao;
import com.techelevator.model.*;
import com.techelevator.model.exceptions.CardNotFoundException;
import com.techelevator.model.exceptions.CategoryNotFoundException;
import com.techelevator.model.exceptions.DeckNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class ExampleDecksController {

    private ExampleDecksDao dao;
    public ExampleDecksController(ExampleDecksDao dao)
    {
        this.dao = dao;
    }

//    @RequestMapping(path = "/cards/", method = RequestMethod.POST)
//    public Cards insertCardObserving(@RequestBody Cards observing) throws CardNotFoundException {
//        return dao.saveCardObserving(observing);
//    }

}
