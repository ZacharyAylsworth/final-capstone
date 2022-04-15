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




}
