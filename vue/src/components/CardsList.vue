<template>
  <div>
    <div class="header">
      <div v-for="card in this.$store.state.deckCards" :key="card.cardID"> 
        <!-- {{ card.cardID }}
        {{ card.front }} -->
      </div>
      <div id="addDeck">
        <h1 >{{ title }}</h1>
      </div>
          <form v-on:submit.prevent="submitForm" class="cardForm" v-if="!isLoading">
      
      <div id="input_lines">     
        <div class="form-group">
          
          <div id="inside-container">
            <label for="deck-name" id="deckName">Deck Name:</label>
            <input id="deck-name" type="text" class="form-control" v-model="deck.deck_name" autocomplete="off" />
          </div>
          
        </div>
      </div>
      <div id="deck-buttons">
        <input type="submit" class="btn btn-submit" id="submitButton" value="Submit" />
        
        
        <router-link tag='button' to="/" class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel" id="cancelButton">Cancel</router-link>
      </div>
      </form>

      <router-link tag="button" class="btn addNewCard" :to="{ name: 'AddFlashCard', params: {deckID: this.deckId} }" v-if="!isLoading && deckId">Add New Card</router-link>
      
      <button class="btn btn-cancel deleteDeck" v-if="!isLoading && deckId" v-on:click="deleteDeck">Delete Deck</button>
    </div>
    <div class="loading" v-if="isLoading">
    </div>
    <div v-else>
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
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
      errorMsg: "",
      deck: {
        deck_name: ""
      }
    };
  },
  methods: {
      submitForm(){
        FlashService.addDecks(this.deck).then(response => {
          this.deckId = response.data.deck_id;
          this.$router.push({ name: 'AddFlashCard', params: { deckID: this.deckId } })
        })
      },

  viewCardDetails(cardID) {
      this.$router.push(`/decks/${this.deckId}/cards/${cardID}`);
    },

    retrieveCards() {
      FlashService
        .getCards(this.deckId)
        .then(response => {
          this.title = response.data.title;
          this.$store.commit("SET_DECK_CARDS", response.data);
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
    this.deckId = this.$route.params.deckID;
    if (this.deckId) this.retrieveCards();
    else this.isLoading = false;
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token;
    },
  }
}
</script>


<style scoped>
#webpage_background {
  color: rgb(228, 228, 228);
  
  font-size: 25px;
}

#addDeck {
  display: flex;
  justify-content: center;
  margin:  -50px auto;
  
}

.form-group {
  border: 2px solid;
  width: 400px;
  height: 200px;
  position: relative;
  margin: 10% auto;
  background: rgb(70, 70, 70);
  padding: 5px; 
  border-radius: 15px;
  color: white;

}

#inside-container {
  display: flex;
  justify-content: space-around;
  padding-top: 20%;
  
}
img {
  max-height: 80%;
  max-width: 80%;
}

#deckName {
  font-size: 20px;
}

#deck-name {
  display: flex;
  align-items: center;
  width: 250px;
  font-size: 30px;
  border-radius: 5px; 
  
}

#deck-buttons {
  display: flex;
  justify-content: space-around;
}

#submitButton {
  cursor: pointer;
    height: 60px;
    margin: 50px;
    width: 25%;
    padding: 5px;
    display: block;
    border-radius: 20px;
    outline: none;
    background: linear-gradient(to right, #b1ff20, #ff9f05);
    font-family: 'Nunito Sans';
    font-size: 40px;
}

#cancelButton {
  cursor: pointer;
    height: 60px;
    margin: 50px;
    width: 25%;
    padding: 5px;
    display: block;
    border-radius: 20px;
    outline: none;
    background: linear-gradient(to right, #b1ff20, #ff9f05);
    font-family: 'Nunito Sans';
    font-size: 40px;
}

#routerLinkButton {
    background: linear-gradient(to right, #b1ff20, #05ffff);
    cursor: pointer;
    height: 30px;
    width: 7%;
    padding: 5px;
    display: block;
    border-radius: 20px;
    outline: none;
    font-family: 'Nunito Sans';
    font-size: 20px;

    display: flex;
    justify-content: flex-end;
    
}
  


</style>