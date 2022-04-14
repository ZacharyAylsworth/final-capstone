package com.techelevator.model;

public class StudySession {
    private Deck deck;
    private User currentUser;
    private boolean isCardFlipped;
    private Integer cardsInDeck;
    private Integer correctAnswers;

    public StudySession(){}

    public StudySession(Deck deck, User currentUser, boolean isCardFlipped, Integer cardsInDeck, Integer correctAnswers){
        this.deck = deck;
        this.currentUser = currentUser;
        this.isCardFlipped = isCardFlipped;
        this.cardsInDeck = cardsInDeck;
        this.correctAnswers = correctAnswers;

    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Integer getCardsInDeck() {
        return cardsInDeck;
    }

    public void setCardsInDeck(Integer cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }




}
