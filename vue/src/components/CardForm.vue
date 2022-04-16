<template>
  <div id="cardFormContainer">
    <form v-on:submit.prevent="submitForm" class="cardForm" v-if="!isLoading">
      
      <div id="input_lines">     
        <div class="form-group">
          
          <label for="question">Question:</label>
          <textarea id="question" type="text" class="form-control" v-model="card.question" autocomplete="off" />
        </div>
        <div class="form-group">
          
          <label for="answer">Answer:</label>
          <textarea id="answer" class="form-control" v-model="card.answer"></textarea>
        </div>
      </div>
      
      <div id="buttons">
        <button class="btn btn-submit" id="submitButton">Submit</button>
        <button class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel" id="cancelButton">Cancel</button>

        <div class="dropdown">
          <button class="dropbtn">Deck Selection</button>
            <div class="dropdown-content">
              <a href="#">Link 1</a>
              <a href="#">Link 2</a>
              <a href="#">Link 3</a>
            </div>
        </div>  
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

.form-group {
  width: 100%;
  padding: 10px 0;
  margin: 5px 0;
  border-left: 0;
  border-top: 0;
  border-right: 0;
  border-bottom: 1px solid #999;
  outline: none;
  background: transparent;
}

#buttons{
  display: flex;
  justify-content: space-around;
}

#submitButton {
  margin:8% auto;
  text-align: center;
  color: rgb(0, 0, 0);
  padding: 5px;
  margin: auto;
  border-radius: 5px;
}

#cancelButton {
  color: rgb(0, 0, 0);
  padding: 5px;
  margin: auto;
  border-radius: 5px;
}


.dropbtn {
  color: rgb(0, 0, 0);
  padding: 5px;
  margin: 50px auto;
  border-radius: 5px;
}


.dropdown {
  position: relative;
  display: inline-block;
}


.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}


.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}


.dropdown-content a:hover {background-color: #ddd;}


.dropdown:hover .dropdown-content {display: block;}


.dropdown:hover .dropbtn {background-color: #3e4a8e;}

</style>