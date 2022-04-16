<!--<template >
  <div >
    <h1 id="h1Text"></h1>
    <div class="decks">
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <div class="loading" v-if="isLoading">
      </div>

      <router-link :to="{ name: 'Deck', params: { id: board.id } }"
        class="decks"
        v-for="deck in this.$store.state.decks"
        v-bind:key="deck.id"
        v-bind:style="{ 'background-color': deck.backgroundColor }"
        v-else
        tag="div"
      >

       <!-- {{ deck.title }}
      </router-link>

      <!--<button class="btn addDeck" v-if="!isLoading && !showAddDeck" v-on:click="showAddDeck = !showAddDeck">Add Deck</button> 
      
      <!--<form v-if="showAddDeck" v-on:submit.prevent="saveNewDeck">
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


methods: {
   retrieveDecks(){
            flashService.getDecks().then(response => {
                this.$store.commit("SET_DECKS", response.data);
            })
        }                    
  }
}
</script>




<style scoped>



</style>