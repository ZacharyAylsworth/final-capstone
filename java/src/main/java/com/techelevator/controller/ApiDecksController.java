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
public class ApiDecksController {
    private FlashCardsDao dao;

    public ApiDecksController(FlashCardsDao dao) {
        this.dao = dao;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/cards/observing", method = RequestMethod.POST)
    public boolean saveCardObserving() {
        return dao.saveCardObserving();
    }
}
