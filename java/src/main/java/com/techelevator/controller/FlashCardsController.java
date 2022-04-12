package com.techelevator.controller;
import com.techelevator.dao.FlashCardsDao;
import com.techelevator.model.CardNotFoundException;
import com.techelevator.model.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class FlashCardsController {

    @Autowired
    private FlashCardsDao dao;

    private List<Cards> allCards = new ArrayList<>();

    public FlashCardsController(FlashCardsDao dao)
    {
        this.dao = dao;
    }

    //CREATE
    @PreAuthorize("permitAll")
    @RequestMapping(value = "/cards", method = RequestMethod.POST)
    public Cards addCard(@RequestBody Cards card){
        if(card !=null){
            dao.save(card);
            return card;
        } return null;
    }
    //REQUEST
    @PreAuthorize("permitAll")
    @RequestMapping(path = "/cards/{card_id}", method = RequestMethod.GET)
    public Cards getCard(@PathVariable Long card_id) throws CardNotFoundException{
        return dao.get(Math.toIntExact(card_id));
    }
    //UPDATE
    @PreAuthorize("permitAll")
    @RequestMapping(path = "/cards/{card_id}", method = RequestMethod.PUT)
    public boolean updateCard(@Valid @RequestBody Cards card, @PathVariable Long card_id) throws CardNotFoundException{
       return dao.update(Math.toIntExact(card_id), card);
    }
    //DELETE
    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/cards/{card_id}", method = RequestMethod.DELETE)
    public void deleteCard(@PathVariable Long id) throws CardNotFoundException{
        dao.delete(Math.toIntExact(id));
    }




}
