package com.techelevator.dao;

import com.techelevator.model.Cards;
import com.techelevator.model.Categories;
import com.techelevator.model.Deck;

import java.util.List;

public interface FlashCardsDao {

    List<Cards> list();

    Cards getCard(Long card_id);

    boolean saveCard(Cards cardToSave);

    boolean updateCard(Long card_id, Cards card);

    boolean deleteCard(Long card_id);

    //decks

    List<Deck> listDecks();

    Deck getDeck(Long deck_id);

    boolean saveDeck(Deck deckToSave);

    boolean updateDeck(Long deck_id, Deck deck);

    boolean deleteDeck(Long deck_id);

    //categories

    List<Categories> listCategories();

    Categories getCategory(Long categories_id);

    boolean saveCategory(Categories categoriesToSave);

    boolean updateCategory(Long categories_id, Categories categories);

//    boolean deleteCategory(Long categories_id);

}
