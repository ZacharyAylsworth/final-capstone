package com.techelevator.controller;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.CategoriesDao;
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
public class CategoriesController {
    private CategoriesDao dao;
    public CategoriesController(CategoriesDao dao)
    {
        this.dao = dao;
    }


    //CREATE
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public Categories addCategory(@RequestBody Categories category){
        if(category !=null){
            dao.saveCategory(category);
            return category;
        } return null;
    }
    //REQUEST
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/categories/{category_id}", method = RequestMethod.GET)
    public Categories getCategory(@PathVariable Long category_id) throws CategoryNotFoundException{
        return dao.getCategory(category_id);
    }
    //UPDATE
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/categories/{category_id}", method = RequestMethod.PUT)
    public boolean updateCategory(@Valid @RequestBody Categories category, @PathVariable Long category_id) throws CategoryNotFoundException{
        return dao.updateCategory(category_id, category);
    }
//    //DELETE
//    @PreAuthorize("isAuthenticated()")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(path = "/categories/{category_id}", method = RequestMethod.DELETE)
//    public void deleteCategory(@PathVariable Long category_id) throws CategoryNotFoundException{
//        dao.deleteCategory(category_id);
//    }

}
