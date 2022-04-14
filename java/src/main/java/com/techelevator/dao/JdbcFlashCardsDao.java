package com.techelevator.dao;

import com.techelevator.model.*;
import com.techelevator.model.exceptions.CardNotFoundException;
import com.techelevator.model.exceptions.CategoryNotFoundException;
import com.techelevator.model.exceptions.DeckNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcFlashCardsDao implements FlashCardsDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcFlashCardsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Cards> list() {
        List<Cards> cards = new ArrayList<>();
        String sql = "SELECT card_id, deck_id, card_back, category_id, card_difficulty_id " +
                "FROM cards";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Cards card = mapRowToCard(results);
            cards.add(card);
        }
        return cards;
    }

    @Override
    public Cards getCard(Long card_id) {
        Cards card = null;
        String sql = "SELECT * " +
                "FROM cards WHERE card_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, card_id);
        if(results.next()){
            card = mapRowToCard(results);
        } else {
            throw new CardNotFoundException();
        }
        return card;
    }

    @Override
    public boolean saveCard(Cards cardToSave) {
        String sql = "INSERT INTO cards (card_id, card_front, card_back, category_id, card_difficulty_id) " +
                "VALUES (DEFAULT, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, cardToSave.getFront(), cardToSave.getBack(), cardToSave.getCategoryID(), cardToSave.getDifficultyID()) == 1;
    }

    @Override
    public boolean updateCard(Long card_id, Cards changedCard) {
        String sql = "UPDATE cards SET card_front = ?, card_back = ?, category_id = ?, card_difficulty_id = ? WHERE card_id = ?";
        return jdbcTemplate.update(sql, changedCard.getFront(), changedCard.getBack(), changedCard.getCategoryID(), changedCard.getDifficultyID(), card_id) == 1;
    }

    @Override
    public boolean deleteCard(Long card_id) {
        String sql = "DELETE FROM cards WHERE card_id = ?";
        return jdbcTemplate.update(sql, card_id) == 1;

    }



    @Override
    public List<Deck> listDecks() {
        List<Deck> decks = new ArrayList<>();
        String sql = "SELECT deck_id, deck_name, card_id " +
                "FROM decks";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Deck deck = mapRowToDeck(results);
            decks.add(deck);
        }
        return decks;
    }

    @Override
    public Deck getDeck(Long deck_id) {
        Deck deck = null;
        String sql = "SELECT * " +
                "FROM decks WHERE deck_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, deck_id);
        if (results.next()) {
            deck = mapRowToDeck(results);
        } else {
            throw new DeckNotFoundException();
        }
        return deck;
    }

    @Override
    public boolean saveDeck(Deck deckToSave) {
        String sql = "INSERT INTO decks (deck_id, deck_name, card_id) " +
                "VALUES (DEFAULT, ?, ?)";
        return jdbcTemplate.update(sql, deckToSave.getDeck_id(), deckToSave.getDeck_name(), deckToSave.getCard_id()) == 1;
    }

    @Override
    public boolean updateDeck(Long deck_id, Deck changedDeck) {
        String sql = "UPDATE decks SET deck_name = ?, card_id = ? WHERE deck_id = ?";
        return jdbcTemplate.update(sql, changedDeck.getDeck_name(), changedDeck.getCard_id(), deck_id) == 1;
    }

    @Override
    public boolean deleteDeck(Long deck_id) {
        String sql = "DELETE FROM decks WHERE deck_id = ?";
        return jdbcTemplate.update(sql, deck_id) == 1;
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

    private Deck mapRowToDeck(SqlRowSet rowSet) {
        Deck d = new Deck();
        d.setDeck_id(rowSet.getLong("deck_id"));
        d.setDeck_name(rowSet.getString("deck_name"));
        d.setCard_id(rowSet.getLong("card_id"));

        return d;
    }
    private Cards mapRowToCard(SqlRowSet rowSet) {
        Cards c = new Cards();
        c.setCardID(rowSet.getLong("card_id"));
        c.setDeckID(rowSet.getLong("deck_id"));
        c.setFront(rowSet.getString("card_front"));
        c.setBack(rowSet.getString("card_back"));
        c.setCategoryID(rowSet.getLong("category_id"));
        c.setDifficultyID(rowSet.getLong("card_difficulty_id"));
        return c;
    }


}
