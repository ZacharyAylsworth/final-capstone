package com.techelevator.controller;
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
@RequestMapping ("/flashcards")
public class FlashCardsController{

    private FlashCardsDao dao;
    public FlashCardsController(FlashCardsDao dao)
    {
        this.dao = dao;
    }


    //CREATE
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/cards", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Cards addCard(@RequestBody Cards card){
        if(card !=null){
            dao.saveCard(card);
            return card;
        } return null;
    }
    //REQUEST
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/cards/{card_id}", method = RequestMethod.GET)
    public Cards getCard(@PathVariable Long card_id) throws CardNotFoundException {
        return dao.getCard(card_id);
    }
    //UPDATE
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/cards/{card_id}", method = RequestMethod.PUT)
    public boolean updateCard(@Valid @RequestBody Cards card, @PathVariable Long card_id) throws CardNotFoundException{
       return dao.updateCard(card_id, card);
    }
    //DELETE
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/cards/{card_id}", method = RequestMethod.DELETE)
    public void deleteCard(@PathVariable Long card_id) throws CardNotFoundException{
        dao.deleteCard(card_id);
    }


}
