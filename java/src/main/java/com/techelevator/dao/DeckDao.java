package com.techelevator.dao;

import com.techelevator.model.Cards;
import com.techelevator.model.Deck;

import java.util.List;

public interface DeckDao {

    //decks

    List<Deck> listDecks();

    Deck getDeck(Long deck_id);

    boolean saveDeck(Deck deckToSave);

    boolean updateDeck(Long deck_id, Deck deck);

    boolean deleteDeck(Long deck_id);


}
