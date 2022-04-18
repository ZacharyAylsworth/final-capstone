package com.techelevator.dao;

import com.techelevator.model.Deck;
import com.techelevator.model.exceptions.DeckNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDeckDao implements DeckDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcDeckDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
//use this to call example decks
    @Override
    public Deck getDeck(Long deck_id) {
        Deck deck = null;
        String sql = "SELECT * " +
                "FROM decks WHERE deck_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, deck_id);
        if (results.next()) {
            deck = mapRowToDeck(results);
        } else {
            //if deck id <= 3, build with helper method
//            //then call deck id 1/2/3
//            String sql = "SELECT * " +
//                    "FROM decks WHERE deck_id = ? ";
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, deck_id);
            throw new DeckNotFoundException();
        }
        return deck;
    }

    @Override
    public boolean saveDeck(Deck deckToSave) {
        String sql = "INSERT INTO decks (deck_id, deck_name) " +
                "VALUES (DEFAULT, ?) returning deck_id";
        Long deckId = jdbcTemplate.queryForObject(sql, Long.class, deckToSave.getDeck_name());
        if (deckId == null)
            return false;
            else {
                deckToSave.setDeck_id(deckId);
                return true;
        }
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

    private Deck mapRowToDeck(SqlRowSet rowSet) {
        Deck d = new Deck();
        d.setDeck_id(rowSet.getLong("deck_id"));
        d.setDeck_name(rowSet.getString("deck_name"));
        d.setCard_id(rowSet.getLong("card_id"));

        return d;
    }


//create private helper method to call all cards in deck 1/2/3

}
