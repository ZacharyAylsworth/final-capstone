package com.techelevator.dao;

import com.techelevator.model.*;
import com.techelevator.model.exceptions.CardNotFoundException;
import com.techelevator.model.exceptions.CategoryNotFoundException;
import com.techelevator.model.exceptions.DeckNotFoundException;
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
        String sql = "SELECT card_id, deck_id, card_front, card_back " +
                "FROM cards";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Cards card = mapRowToCard(results);
            cards.add(card);
        }
        return cards;
    }

    //
    public List<Cards> getCardsForDeck(Long deck_id){
        List<Cards> cards = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM cards WHERE deck_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, deck_id);
        while(results.next()){
            cards.add(mapRowToCard(results));
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
        String sql = "INSERT INTO cards (card_id, deck_id, card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, cardToSave.getDeckID(), cardToSave.getFront(), cardToSave.getBack()) == 1;
    }

    @Override
    public boolean updateCard(Long card_id, Cards changedCard) {
        String sql = "UPDATE cards SET card_front = ?, card_back = ? WHERE card_id = ?";
        return jdbcTemplate.update(sql, changedCard.getFront(), changedCard.getBack(), card_id) == 1;
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
        //c.setCategoryID(rowSet.getLong("category_id"));
        //c.setDifficultyID(rowSet.getLong("card_difficulty_id"));
        return c;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean saveCardObserving() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("observing");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "observing", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 1) == 1;
    }

    public boolean saveCardHelpful() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("helpful");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "helpful", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 1) == 1;
    }

    public boolean saveCardTeamwork() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("teamwork");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "teamwork", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 1) == 1;
    }
    public boolean saveCardAwesome() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("awesome");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "awesome", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 1) == 1;
    }
    public boolean saveCardAnnoy() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("annoy");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "annoy", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 1) == 1;
    }
    public boolean saveCardEnormous() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("enormous");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "enormous", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 1) == 1;
    }
    public boolean saveCardEntrepreneur() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("entrepreneur");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "entrepreneur", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 2) == 1;
    }
    public boolean saveCardOxymoron() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("oxymoron");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "oxymoron", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 2) == 1;
    }
    public boolean saveCardFraudulent() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("fraudulent");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "fraudulent", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 2) == 1;
    }
    public boolean saveCardPurportedly() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("purportedly");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "purportedly", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 2) == 1;
    }
    public boolean saveCardVendetta() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("vendetta");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "vendetta", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 2) == 1;
    }
    public boolean saveCardMettle() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("mettle");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "mettle", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 2) == 1;
    }
    public boolean saveCardDemagogue() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("demagogue");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "demagogue", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 3) == 1;
    }
    public boolean saveCardUbiquitous() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("ubiquitous");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "ubiquitous", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 3) == 1;
    }
    public boolean saveCardPejorative() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("pejorative");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "pejorative", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 3) == 1;
    }
    public boolean saveCardProtean() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("protean");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "protean", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 3) == 1;
    }
    public boolean saveCardTirade() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("tirade");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "tirade", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 3) == 1;
    }
    public boolean saveCardAbrogate() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("abrogate");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "abrogate", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 3) == 1;
    }
    public boolean saveCardImpecunious() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("impecunious");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "impecunious", dictionaryApi.getDefinitions()[0].getDefinition(), 1, 3) == 1;
    }
}
