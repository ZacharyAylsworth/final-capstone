package com.techelevator.controller;

import com.techelevator.dao.CategoriesDao;
import com.techelevator.dao.DeckDao;
import com.techelevator.model.Deck;
import com.techelevator.model.exceptions.DeckNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class DeckController {


    private DeckDao dao;
    public DeckController(DeckDao dao)
    {
        this.dao = dao;
    }



    //CREATE deck
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/decks", method = RequestMethod.POST)
    public Deck addDeck(@RequestBody Deck deck){
        if(deck !=null){
            dao.saveDeck(deck);
            return deck;
        } return null;
    }
    //REQUEST deck
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/decks/{deck_id}", method = RequestMethod.GET)
    public Deck getDeck(@PathVariable Long deck_id) throws DeckNotFoundException {
        return dao.getDeck(deck_id);
    }
    //UPDATE deck
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/decks/{deck_id}", method = RequestMethod.PUT)
    public boolean updateDeck(@Valid @RequestBody Deck deck, @PathVariable Long deck_id) throws DeckNotFoundException{
        return dao.updateDeck(deck_id, deck);
    }
    //DELETE deck
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/decks/{deck_id}", method = RequestMethod.DELETE)
    public void deleteDeck(@PathVariable Long deck_id) throws DeckNotFoundException{
        dao.deleteDeck(deck_id);
    }




}
