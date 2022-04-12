<template>
  <div>

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
        cardId: Number(this.$route.params.cardId),
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
              this.$router.push(`/board/${newCard.boardId}`);
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "adding");
          });
      } else {
        // update
        newCard.id = this.cardID;
        newCard.avatar = this.card.avatar;
        newCard.date = this.card.date;
        flashService
          .updateCard(newCard)
          .then(response => {
            if (response.status === 200) {
              this.$router.push(`/board/${newCard.boardId}`);
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