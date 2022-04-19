<template>
  <div>
      <label for="study-deck">Deck:</label>
      <div v-for='card of cards' :key='card.id'>

      </div>
  </div>
</template>

<script>
export default {


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

methods: {
    flipCard: function(card){
        card.flipped = !card.flipped;
    }
  }
}
</script>

<style>

</style>