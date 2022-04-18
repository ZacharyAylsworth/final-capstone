<template >
  <div >
    <h1 id="h1Text"></h1>
    <div class="decks">
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <div class="loading" v-if="isLoading">
      </div>

      <router-link :to="{ name: 'Deck', params: { id: deck.id } }"
        class="deck"
        v-for="deck in this.$store.state.decks"
        v-bind:key="deck.id"
        v-bind:style="{ 'background-color': deck.backgroundColor }"
        v-else
        tag="div"
      >
        {{ deck.title }}
      </router-link>

      <button class="btn addDeck" v-if="!isLoading && !showAddDeck" v-on:click="showAddDeck = !showAddDeck">Add Deck</button> 
      
      <form v-if="showAddDeck" v-on:submit.prevent="saveNewDeck">
        Deck Title:
        <input type="text" class="form-control" v-model="newDeck.title" />
        Background Color:
        <input type="text" class="form-control" v-model="newDeck.backgroundColor" />
        <button class="btn btn-submit" id="sub">Save</button>
        <button class="btn btn-cancel" v-on:click="showAddDeck = !showAddDeck" id="cnl">Cancel</button>
      </form>
    </div>
  </div>
</template>



<script>

import flashService from '../services/FlashService';

export default {
  data() {
    return {
      isLoading: true,
      showAddDeck: false,
      newDeck: {
        title: '',
        backgroundColor: this.randomBackgroundColor()
      },
      errorMsg: ''
    };
  },
  created() {
    this.retrieveDecks();
  },
methods: {
    retrieveDecks(){
      flashService.getDecks().then(response => {
        this.$store.commit("SET_DECKS", response.data);
        this.isLoading = false;
      });
    },
    saveNewDeck() {
      this.isLoading = true;
      this.showAddDeck = false;

      flashService.addDecks(this.newDeck).then(response => {
        if(response.status === 201) {
          this.retrieveDecks();
        }
      }).catch(error => {
        const verb = 'adding';

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
      })
    },
    randomBackgroundColor() {
      return "#" + this.generateHexCode();
    },
    generateHexCode() {
      var bg = Math.floor(Math.random()*16777215).toString(16);
      if (bg.length !== 6) bg = this.generateHexCode();
      return bg;
    }
  }
}                    
</script>




<style scoped>

.decks {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}
.deck {
  color: #f7fafc;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 10px;
  text-align: center;
  cursor: pointer;
  width: 60%;
}
.addDeck {
  color: #f7fafc;
  border-radius: 10px;
  background-color: #28a745;
  font-size: 16px;
  width: 60%;
  margin: 10px;
  padding: 20px;
  cursor: pointer;
}

</style>