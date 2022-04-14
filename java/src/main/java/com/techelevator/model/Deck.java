package com.techelevator.model;

public class Deck {
    private Long deck_id;
    private Long card_id;
    private String deck_name;

    public Deck(Long deck_id, Long card_id, String deck_name) {
        this.deck_id = deck_id;
        this.card_id = card_id;
        this.deck_name = deck_name;
    }
    public Deck() {}

    public Long getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(Long deck_id) {
        this.deck_id = deck_id;
    }

    public Long getCard_id() {
        return card_id;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }

    public String getDeck_name() {
        return deck_name;
    }

    public void setDeck_name(String deck_name) {
        this.deck_name = deck_name;
    }
}
