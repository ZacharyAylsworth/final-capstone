package com.techelevator.controller;

import com.techelevator.dao.FlashCardsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("isAuthenticated()")
@RestController
public class FlashCardsController {

    @Autowired
    private FlashCardsDao dao;

    public FlashCardsController(FlashCardsDao dao) {
        this.dao = dao;
    }

    //CREATE


    //REQUEST


    //UPDATE


    //DELETE



}
