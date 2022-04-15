package com.techelevator.dao;

import com.techelevator.model.Categories;

import java.util.List;

public interface CategoriesDao {

    //categories

    List<Categories> listCategories();

    Categories getCategory(Long categories_id);

    boolean saveCategory(Categories categoriesToSave);

    boolean updateCategory(Long categories_id, Categories categories);

//    boolean deleteCategory(Long categories_id);

}
