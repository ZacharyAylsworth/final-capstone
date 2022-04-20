<template>
  <div>
      <h3>Deck: {{ currentDeck }}</h3>
      <div v-if="!flipped">
          {{ currentCard.front }}
      </div>
      <div v-else>
          {{ currentCard.back }}
      </div>
      <button v-on:click="previousCard" v-bind:disabled="cardIndex == 0">Previous Card</button>
      <button v-on:click="flipCard">Flip Card</button>
      <button v-on:click="nextCard" v-bind:disabled="cardIndex == cards.length-1">Next Card</button>
  </div>
</template>

<script>
import FlashService from '../services/FlashService'
import Deck from '../views/Deck.vue'

export default {
    name: 'study-cards',
    props: ["deckID", "deck"],
    views: { Deck },

computed: {
    currentCard(){
        return this.cards[this.cardIndex]
    },

    currentDeck(){
        return this.deckID
    },
},
data(){
    return {
        cards: [],
        cardIndex: 0,
        flipped: false,
    }
},

created(){
    FlashService.getDeck(this.deckID).then(() => {
    this.retrieveCards();
    });
},

methods: {
    flipCard(){
        this.flipped = !this.flipped;
    },
    retrieveCards() {
      FlashService
        .getCards(this.deckID)
        .then(response => {
        //   this.$store.commit("SET_DECK_CARDS", response.data);
        this.cards = response.data;
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

    nextCard(){
        this.cardIndex++;
        this.flipped = false;
    },

    previousCard(){
        this.cardIndex--;
        this.flipped = false;
    }
  }
}
</script>

<style>

</style>