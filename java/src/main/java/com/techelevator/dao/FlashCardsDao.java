package com.techelevator.dao;

import com.techelevator.model.Cards;

import java.util.List;

public interface FlashCardsDao {

    List<Cards> list();

    Cards get(int card_id);

    boolean save(Cards cardToSave);

    boolean update(int id, Cards card);

    boolean delete(int id);


}
