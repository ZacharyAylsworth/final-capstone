package com.techelevator.dao;

import com.techelevator.model.Deck;
import com.techelevator.model.exceptions.DeckNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

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

    private Deck mapRowToDeck(SqlRowSet rowSet) {
        Deck d = new Deck();
        d.setDeck_id(rowSet.getLong("deck_id"));
        d.setDeck_name(rowSet.getString("deck_name"));
        d.setCard_id(rowSet.getLong("card_id"));

        return d;
    }




}