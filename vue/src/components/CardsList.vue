<template>
  <div>
    <div class="header">
      <h1>{{ title }}</h1>
      <router-link tag="button" class="btn addNewCard" :to="{ name: 'AddFlashCard', params: {deckID: this.deckId} }" v-if="!isLoading">Add New Card</router-link>
      <button class="btn btn-cancel deleteDeck" v-if="!isLoading && isLoggedIn" v-on:click="deleteDeck">Delete Deck</button>
    </div>
    <div class="loading" v-if="isLoading">
    </div>
    <div v-else>
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    </div>
    <div class="deck-actions" v-if="!isLoading">
      <router-link to="/">Back to Decks</router-link>
    </div>
  </div>
</template>

<script>
import FlashService from '../services/FlashService';
export default {
  name: 'cards-list',

  data() {
    return {
      title: "",
      deckId: 0,
      isLoading: true,
      errorMsg: ""
    };
  },
  methods: {
    retrieveCards() {
      FlashService
        .getCards(this.deckId)
        .then(response => {
          this.title = response.data.title;
          this.$store.commit("DECK", response.data.cards);
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Deck cards not available. This deck may have been deleted or you have entered an invalid deck ID."
            );
            this.$router.push("/");
          }
        });
    },
    deleteDecks() {
      const shouldDelete = confirm('Are you sure you want to delete this deck?');

      if(shouldDelete) {
        this.isLoading = true;
        FlashService
          .deleteDecks(this.deckId)
          .then(response => {
            if(response.status === 200) {
              this.$store.commit('DELETE_DECK', this.deckId);
              alert('Delete was successful.');
              this.$router.push({ name: 'Home'});
            }
          })
          .catch(error => {
            const verb = 'deleting';

            if (error.response) {
              this.errorMsg =
                  "Error " + verb + " deck. Response received was '" +
                  error.response.statusText +
                  "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error " + verb + " deck. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error " + verb + " deck. Request could not be created.";
            }

            this.isLoading = false;
          });
      }
    }
  },
  created() {
    this.deckId = this.$route.params.id;
    this.retrieveCards();
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token;
    },
  }
}
</script>

<style>

</style>