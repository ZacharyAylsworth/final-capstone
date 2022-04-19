<template>
  <div>
      <label for="study-deck">Deck:</label>
      <div v-if="!flipped">
          {{ currentCard.front }}
      </div>
      <div v-else>
          {{ currentCard.back }}
      </div>
      <button v-on:click="flipCard">Flip Card</button>
      <button v-on:click="nextCard" v-bind:disabled="cardIndex == cards.length-1">Next Card</button>
  </div>
</template>

<script>
import FlashService from '../services/FlashService'

export default {
props: ["deckID"],

computed: {
    currentCard(){
        return this.cards[this.cardIndex]
    }
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
    }
  }
}
</script>

<style>

</style>