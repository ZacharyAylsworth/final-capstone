package com.techelevator.controller;

import com.techelevator.dao.CategoriesDao;
import com.techelevator.dao.FlashCardsDao;
import com.techelevator.model.Categories;
import com.techelevator.model.exceptions.CategoryNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public class CategoriesController {


    private CategoriesDao dao;
    public CategoriesController(CategoriesDao dao)
    {
        this.dao = dao;
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

}
