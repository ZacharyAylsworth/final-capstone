import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    decks: [],
    deckCards: [],
    card: {
      cardID: 1,
      deckID: 1,
      front: 'front',
      back: 'back'
    }
  },
  mutations: {
    SAVE_CARD(state, card) {
      state.deckCards.push(card);
    },
    SET_DECKS(state, data) {
      state.decks = data;
    },
    SET_DECK_CARDS(state, data) {
      state.deckCards = data;  
    },
    SET_CURRENT_CARD(state, data) {
      state.card = data;
    },
    DELETE_DECK(state, deckIdToDelete) {
      state.decks = state.decks.filter((deck) => {
        return deck.id != deckIdToDelete;
      });
    },
    UPDATE_CARD_STATUS(state, data) {
      const cardToUpdate = state.deckCards.find(update => update.id === data.cardId);
      cardToUpdate.status = data.status;
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
