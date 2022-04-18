import axios from 'axios';

export default {

    getDecks() {
        return axios.get('/decks');
      },
    
    addDecks(deck) {
        return axios.post('/decks', deck);
      },
    
    deleteDecks(deckID) {
        return axios.delete(`/decks/${deckID}`);
      },
    
    getCards(deckID) {
        return axios.get(`/decks/${deckID}`)
      },
    
    getCard(cardID) {
        return axios.get(`/cards/${cardID}`)
      },
    
    addCard(card) {
        return axios.post('/flashcards/cards', card);
      },
    
    updateCard(card) {
        return axios.put(`/cards/${card.id}`, card);
      },
    
    deleteCard(cardID) {
        return axios.delete(`/cards/${cardID}`);
      }
}