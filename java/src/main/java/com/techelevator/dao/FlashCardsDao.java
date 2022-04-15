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

<<<<<<< HEAD
=======
    //////////////////////////

>>>>>>> 72a9da197ad7c5b44e208e259169e6c97e40e767
    boolean saveCardObserving();

    boolean saveCardHelpful();

    boolean saveCardTeamwork();

    boolean saveCardAwesome();

    boolean saveCardAnnoy();

    boolean saveCardEnormous();

    boolean saveCardEntrepreneur();

    boolean saveCardOxymoron();

    boolean saveCardFraudulent();

    boolean saveCardPurportedly();

    boolean saveCardVendetta();

    boolean saveCardMettle();

    boolean saveCardDemagogue();

    boolean saveCardUbiquitous();

    boolean saveCardPejorative();

    boolean saveCardProtean();

    boolean saveCardTirade();

    boolean saveCardAbrogate();

    boolean saveCardImpecunious();





}
