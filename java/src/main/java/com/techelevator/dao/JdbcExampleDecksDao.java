package com.techelevator.dao;

import com.techelevator.model.Cards;
import com.techelevator.model.DictionaryApi;
import com.techelevator.services.RestDictionaryService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component

public class JdbcExampleDecksDao implements ExampleDecksDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcExampleDecksDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean megaSave() {
        saveCardObserving(null);
        saveCardHelpful();
        saveCardTeamwork();
        saveCardAwesome();
        saveCardAnnoy();
        saveCardEnormous();
        saveCardEntrepreneur();
        saveCardOxymoron();
        saveCardFraudulent();
        saveCardPurportedly();
        saveCardVendetta();
        saveCardMettle();
        saveCardDemagogue();
        saveCardUbiquitous();
        saveCardPejorative();
        saveCardProtean();
        saveCardTirade();
        saveCardAbrogate();
        saveCardImpecunious();
        return true;
    }

    public boolean saveCardObserving(Cards observing) {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("observing");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "Observing", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }

    public boolean saveCardHelpful() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("helpful");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "Helpful", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }

    public boolean saveCardTeamwork() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("teamwork");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "Teamwork", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardAwesome() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("awesome");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "Awesome", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardAnnoy() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("annoy");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "Annoy", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardEnormous() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("enormous");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 1, "Enormous", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardEntrepreneur() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("entrepreneur");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "Entrepreneur", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardOxymoron() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("oxymoron");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "Oxymoron", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardFraudulent() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("fraudulent");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "Fraudulent", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardPurportedly() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("purportedly");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "Purportedly", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardVendetta() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("vendetta");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "Vendetta", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardMettle() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("mettle");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 2, "Mettle", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardDemagogue() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("demagogue");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "Demagogue", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardUbiquitous() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("ubiquitous");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "Ubiquitous", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardPejorative() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("pejorative");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "Pejorative", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardProtean() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("protean");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "Protean", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardTirade() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("tirade");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "Tirade", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardAbrogate() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("abrogate");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "Abrogate", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }
    public boolean saveCardImpecunious() {
        RestDictionaryService rdService = new RestDictionaryService();
        DictionaryApi dictionaryApi = rdService.listWordAndDefinitions("impecunious");
        String sql = "INSERT INTO cards (card_id, deck_id , card_front, card_back) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql, 3, "Impecunious", dictionaryApi.getDefinitions()[0].getDefinition()) == 1;
    }



}
