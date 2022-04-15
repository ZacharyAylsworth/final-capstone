package com.techelevator.dao;

import com.techelevator.model.Categories;
import com.techelevator.model.exceptions.CategoryNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcCategoriesDao implements CategoriesDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcCategoriesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Categories> listCategories() {
        List<Categories> categories = new ArrayList<>();
        String sql = "SELECT category_id, category_name " +
                "FROM categories";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Categories category = mapRowToCategories(results);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public Categories getCategory(Long category_id) {
        Categories category = null;
        String sql = "SELECT * " +
                "FROM categories WHERE category_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, category_id);
        if (results.next()) {
            category = mapRowToCategories(results);
        } else {
            throw new CategoryNotFoundException();
        }
        return category;
    }

    @Override
    public boolean saveCategory(Categories categoryToSave) {
        String sql = "INSERT INTO categories (category_id, category_name) " +
                "VALUES (DEFAULT, ?)";
        return jdbcTemplate.update(sql, categoryToSave.getCategory_ID(), categoryToSave.getCategory_name()) == 1;
    }

    @Override
    public boolean updateCategory(Long category_id, Categories changedCategory) {
        String sql = "UPDATE categories SET category_name = ? WHERE category_id = ?";
        return jdbcTemplate.update(sql, changedCategory.getCategory_name(), category_id) == 1;
    }

//    @Override
//    public boolean deleteCategory(Long category_id) {
//        String sql = "DELETE FROM categories WHERE category_id = ?";
//        return jdbcTemplate.update(sql, category_id) == 1;
//    }

    private Categories mapRowToCategories(SqlRowSet rowSet) {
        Categories c = new Categories();
        c.setCategory_ID(rowSet.getLong("category_id"));
        c.setCategory_name(rowSet.getString("category_name"));


        return c;
    }

}
