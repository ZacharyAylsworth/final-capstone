import axios from 'axios';

export default {

    getDecks() {
        return axios.get('/decks');
      },

      getDeck(deckID){
        return axios.get(`/decks/${deckID}`)
      },
    
    addDecks(deck) {
        return axios.post('/decks', deck);
      },
    
    deleteDecks(deckID) {
        return axios.delete(`/decks/${deckID}`);
      },
    
    getCards(deckID) {
        return axios.get(`/decks/${deckID}/cards`)
      },
    
    getCard(cardID) {
        return axios.get(`/flashcards/cards/${cardID}`)
      },
    
    addCard(card) {
        return axios.post('/flashcards/cards', card);
      },
    
    updateCard(card) {
        return axios.put(`/flashcards/cards/${card.id}`, card);
      },
    
    deleteCard(cardID) {
        return axios.delete(`/flashcards/cards/${cardID}`);
      }
}