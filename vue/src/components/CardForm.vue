<template>
  <div id="cardFormContainer">
    <form v-on:submit.prevent="submitForm" class="cardForm" v-if="!isLoading">
      <div class="form-group">
        <label for="question">Question:</label>
        <input id="question" type="text" class="form-control" v-model="card.question" autocomplete="off" />
      </div>
      <div class="form-group">
        <label for="answer">Answer:</label>
        <input id="answer" class="form-control" v-model="card.answer" autocomplete="off" />
      </div>      
        <button class="btn btn-submit" id="submitButton">Submit</button>
        <router-link tag='button' to="/" class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel" id="cancelButton">Cancel</router-link>
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
                question: "",
                answer: "",
               // tag: "", //keyword search?
                userID: "",
            }
        }
    },

    methods: {
      submitForm() {
        const newCard = {
          cardID: Number(this.$route.params.cardID),  // this was deckID instead of cardID
          question: this.card.question,
          answer: this.card.answer,
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
cancelForm() {
      this.$router.push(`/deck/${this.$route.params.cardID}`);
    },
    handleErrorResponse(error, verb) {
      if (error.response) {
        this.errorMsg =
          "Error " + verb + " card. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg =
          "Error " + verb + " card. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " card. Request could not be created.";
      }
    }
  },
  created() {
    if (this.cardID != 0) {
      flashService
        .getCard(this.cardID)
        .then(response => {
          this.card = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Card not available. This card may have been deleted or you have entered an invalid card ID."
            );
            this.$router.push("/");
          }
        });
    } else {
      this.isLoading = false;
    }
  }
};
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