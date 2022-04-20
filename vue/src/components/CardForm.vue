<template>
  <div id="cardFormContainer">
    <form v-on:submit.prevent="submitForm" class="cardForm" v-if="!isLoading">
      
      <div id="input_lines">     
        <div class="form-group">
          
          <label for="front">Front:</label>
          <input id="front" type="text" class="form-control" v-model="card.front" autocomplete="off" />
        </div>
        <div class="form-group">
          
          <label for="back">Back:</label>
          <input id="back" class="form-control" v-model="card.back" />
        </div>
      </div>
      
      <div id="buttons">
        <button class="btn btn-submit" id="submitButton" v-on:click='submitForm'>Submit</button>
        <router-link tag='button' to="/" class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel" id="cancelButton">Cancel</router-link>

        
      </div>
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
              cardID: 1,
              deckID: '1',
              front: '',
              back: ''
            }
        }
    },

    methods: {

      resetForm(){
        
      },

      submitForm() {
        // test
        this.$store.commit('SAVE_CARD', this.card);
        // test

        let newCard = {
          cardID: Number(this.$route.params.cardID),
          deckID: Number(this.$route.params.deckID),
          front: this.card.front,
          back: this.card.back,
        };

        // test
        // this.$router.push({ name: 'ListCards', params: { deckID: newCard.deckID } })
        // test

      if (this.cardID === 0) {
        // add
        flashService
          .addCard(newCard)
          .then(response => {
            if (response.status === 201) {
              // this.$router.push(`/decks/${newCard.deckID}`);
              this.card.front = "";
              this.card.back = "";
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "adding");
          });
      } else {
        // update
        newCard.id = this.cardID;
        newCard.front = this.card.front;
        newCard.back = this.card.back;
        flashService
          .updateCard(newCard)
          .then(response => {
            if (response.status === 200) {
              this.$router.push(`/decks/${newCard.deckID}`); 
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

<style scoped>


#cardFormContainer {
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

.form-group {
  width: 100%;
  padding: 10px 0;
  margin: 3px 0;

  border-bottom: 1px solid #999;
  outline: none;
  background: transparent;
  font-size: 20px;
}



#buttons{
  display: flex;
  justify-content: space-around;
}

#input_lines {
  text-align: center;
}

#submitButton {
  margin:8% auto;
  text-align: center;
  color: rgb(0, 0, 0);
  padding: 5px;
  border-radius: 5px;

  cursor: pointer;
  height: 60px;
  margin: 50px;
  width: 30%;
  display: block;
  border-radius: 20px;
  outline: none;
  background: linear-gradient(to right, #b1ff20, #ff9f05);
  font-family: 'Nunito San';
  font-size: 30px;
    
}

#cancelButton {
  color: rgb(0, 0, 0);
  padding: 5px;
  border-radius: 5px;

  cursor: pointer;
  height: 60px;
  margin: 50px;
  width: 30%;
  padding: 5px;
  display: block;
  border-radius: 20px;
  outline: none;
  background: linear-gradient(to right, #b1ff20, #ff9f05);
  font-family: 'Nunito San';
  font-size: 30px;
    
}




</style>