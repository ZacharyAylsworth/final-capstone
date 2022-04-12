package com.techelevator.model;

public class Cards {
    private Long cardID;
    private Long deckID;
    private String front;
    private String back;
    private Long categoryID;
    private Long difficultyID;



    public Cards(Long cardID, Long deckID, String front, String back, Long categoryID, Long difficultyID) {
        this.cardID = cardID;
        this.deckID = deckID;
        this.front = front;
        this.back = back;
        this.categoryID = categoryID;
        this.difficultyID = difficultyID;
    }

    public Cards() {

    }

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public Long getDifficultyID() {
        return difficultyID;
    }

    public void setDifficultyID(Long difficultyID) {
        this.difficultyID = difficultyID;
    }

    public Long getDeckID() {
        return deckID;
    }

    public void setDeckID(Long deckID) {
        this.deckID = deckID;
    }
}
