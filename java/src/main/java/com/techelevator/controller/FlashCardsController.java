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
public class FlashCardsController {

    private FlashCardsDao dao;
    public FlashCardsController(FlashCardsDao dao)
    {
        this.dao = dao;
    }


    //CREATE
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/cards", method = RequestMethod.POST)
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

    //CREATE Category
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public Categories addCategory(@RequestBody Categories category){
        if(category !=null){
            dao.saveCategory(category);
            return category;
        } return null;
    }
    //REQUEST Category
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/categories/{category_id}", method = RequestMethod.GET)
    public Categories getCategory(@PathVariable Long category_id) throws CategoryNotFoundException {
        return dao.getCategory(category_id);
    }
    //UPDATE Category
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/categories/{category_id}", method = RequestMethod.PUT)
    public boolean updateCategory(@Valid @RequestBody Categories category, @PathVariable Long category_id) throws CategoryNotFoundException{
        return dao.updateCategory(category_id, category);
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
