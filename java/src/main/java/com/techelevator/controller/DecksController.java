package com.techelevator.controller;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.DeckDao;
import com.techelevator.dao.FlashCardsDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class DecksController {
    private DeckDao dao;
    public DecksController(DeckDao dao)
    {
        this.dao = dao;
    }


    //CREATE
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/decks", method = RequestMethod.POST)
    public Deck addDeck(@RequestBody Deck deck){
        if(deck !=null){
            dao.saveDeck(deck);
            return deck;
        } return null;
    }
    //REQUEST
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/decks/{deck_id}", method = RequestMethod.GET)
    public Deck getDeck(@PathVariable Long deck_id) throws DeckNotFoundException{
        return dao.getDeck(deck_id);
    }
    //UPDATE
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/decks/{deck_id}", method = RequestMethod.PUT)
    public boolean updateDeck(@Valid @RequestBody Deck deck, @PathVariable Long deck_id) throws DeckNotFoundException{
        return dao.updateDeck(deck_id, deck);
    }
    //DELETE
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/decks/{deck_id}", method = RequestMethod.DELETE)
    public void deleteDeck(@PathVariable Long deck_id) throws DeckNotFoundException{
        dao.deleteDeck(deck_id);
    }

}


