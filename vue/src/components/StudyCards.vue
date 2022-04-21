<template>
  <div id="study_container">
      <label for="study-deck" id="study_title"> {{ deck.deck_name }}</label>
      
      <div v-if="!flipped" id="word">
          {{ currentCard.front }}
      </div>
      <div v-else id="meaning">
          {{ currentCard.back }}
    
      </div >
        
        <div id="threeButtons">
            <button v-on:click="previousCard" v-bind:disabled="cardIndex == 0" id="previousBtn">Previous Card</button>
            <button v-on:click="flipCard" id="flipBtn">Flip Card</button>
            <button v-on:click="nextCard" v-bind:disabled="cardIndex == cards.length-1" id="nextBtn">Next Card</button>
        </div>
    </div>

</template>



<script>
import FlashService from '../services/FlashService'
import Deck from '../views/Deck.vue'

export default {
    name: 'study-cards',
    props: ["deckID"],
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
        deck: {}
    }
},

created(){
    FlashService.getDeck(this.deckID).then((response) => {
      this.deck = response.data;
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
    previousCard () {
        this.cardIndex--;
        this.flipped = false;
    }
  }
}
</script>



<style scoped>

#word {
padding-top: 10%;
font-size: 30px;
display: flex;
justify-content: center;
}

#meaning{
   padding-top: 10%; 
   font-size: 30px; 
   display: flex;
   justify-content: center;
}

#study_title {
    font-size: 30px;
    margin-bottom: 2%;
}

#study_container {
    border: 2px solid;
    width: 500px;
    height: 500px;
    position: relative;
    margin: 10% auto;
    background: rgb(70, 70, 70);
    padding: 5px; 
    border-radius: 10px;
    color: white;
}

#studyBtns {
  display: flex;
  justify-content: space-around;
}

#flipBtn {
  cursor: pointer;
  height: 60px;
  margin: 50px;
  width: 155%;
  display: block;
  border-radius: 20px;
  outline: none;
  background: linear-gradient(to right, #b1ff20, #ff9f05);
  font-family: 'Nunito San';
  font-size: 25px;
}

#nextBtn {
  cursor: pointer;
  height: 60px;
  margin: 50px;
  width: 155%;
  display: block;
  border-radius: 20px;
  outline: none;
  background: linear-gradient(to right, #b1ff20, #ff9f05);
  font-family: 'Nunito San';
  font-size: 25px;
} 

#previousBtn {
  cursor: pointer;
  height: 60px;
  margin: 50px;
  width: 155%;
  display: block;
  border-radius: 20px;
  outline: none;
  background: linear-gradient(to right, #b1ff20, #ff9f05);
  font-family: 'Nunito San';
  font-size: 25px;
} 

#threeButtons {
    position: absolute;
    bottom: -20px;
    margin: auto;
    
}

</style>