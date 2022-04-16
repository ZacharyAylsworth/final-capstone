<template>
  <div id="cardFormContainer">
    <form v-on:submit.prevent="submitForm" class="cardForm" v-if="!isLoading">
      <div class="form-group">
        <label for="question">Question:</label>
        <input id="question" type="text" class="form-control" v-model="card.question" autocomplete="off" />
      </div>
      <div class="form-group">
        <label for="answer">Answer:</label>
        <textarea id="answer" class="form-control" v-model="card.answer"></textarea>
      </div>

      
        <button class="btn btn-submit" id="submitButton">Submit</button>
        <button class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel" id="cancelButton">Cancel</button>
    </form>
    </div>
</template>



<script>
import flashService from "../services/FlashService"; 

export default {
    name: "card-form",
    props: {
        cardID: {
            type: Number,
            default: 0        
    }
},
    data(){
        return {
            card: {
                front: "",
                back: "",
               // tag: "", //keyword search?
                userID: "",
            }
        }
    },

    created(){
        this.retrieveDecks();
    },

    methods: {
      submitForm() {
        const newCard = {
          cardID: Number(this.$route.params.cardID),  // this was deckID instead of cardID
          front: this.card.front,
          back: this.card.back,
          // status: this.card.status,
          // tag: this.card.tag,
          userID: Number(this.$route.params.userID)
        };

      if (this.cardID === 0) {
        // add
        flashService
          .addCard(newCard)
          .then(response => {
            if (response.status === 201) {
              this.$router.push(`/decks/${newCard.cardID}`); // maybe change to `/cards/${newCard.cardID}`
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "adding");
          });
      } else {
        // update
        flashService
          .updateCard(newCard)
          .then(response => {
            if (response.status === 200) {
              this.$router.push(`/decks/${newCard.cardID}`);  // maybe change to `/cards/${newCard.cardID}`
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "updating");
          });
      }

    },
        retrieveDecks(){                                          // ->  store/index.js
            flashService.getDecks().then(response => {
                this.$store.commit("SET_DECKS", response.data);
            })
        }
    }
}
</script>

<style>
#cardFormContainer {
    border: 2px solid;
    width: 500px;
    height: 500px;
    position: relative;
    margin: 10% auto;
    background: #fff;
    padding: 5px; 
    border-radius: 10px;
}

#submitButton {
  margin:8% auto;
  text-align: center;
}


.form-group{
  text-align: center;
}
</style>