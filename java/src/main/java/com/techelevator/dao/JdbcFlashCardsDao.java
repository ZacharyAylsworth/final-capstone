package com.techelevator.dao;

import com.techelevator.model.CardNotFoundException;
import com.techelevator.model.Cards;
import com.techelevator.model.DictionaryApi;
import com.techelevator.services.RestDictionaryService;
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



    public boolean saveCardObserving() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("observing");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back, category_id, card_difficulty_id) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "observing", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 1) == 1;
    }
}
