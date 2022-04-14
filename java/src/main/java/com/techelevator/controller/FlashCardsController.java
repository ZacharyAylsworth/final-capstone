package com.techelevator.controller;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.FlashCardsDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.CardNotFoundException;
import com.techelevator.model.Cards;
import com.techelevator.model.LoginDTO;
import com.techelevator.model.User;
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
    public Cards getCard(@PathVariable Long card_id) throws CardNotFoundException{
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
