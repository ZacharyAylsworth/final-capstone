<template>
  <div>
    <div class="form-group">
      <label for="title">Title:</label>
      <input id="title" type="text" class="form-control" v-model="card.title" autocomplete="off" />
    </div>
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
                status: "", // right or wrong?
                tag: "", //keyword search?
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
          status: this.card.status,
          tag: this.card.tag,
          userID: Number(this.$route.params.userID)
        };

      if (this.cardID === 0) {
        // add
        flashService
          .addCard(newCard)
          .then(response => {
            if (response.status === 201) {
              this.$router.push(`/decks/${newCard.cardID}`);
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
              this.$router.push(`/decks/${newCard.cardID}`);
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "updating");
          });
      }

    },
        retrieveDecks(){
            flashService.getDecks().then(response => {
                this.$store.commit("SET_DECKS", response.data);
            })
        }
    }
}
</script>

<style>

</style>