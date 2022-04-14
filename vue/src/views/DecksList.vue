<template>
  <div>

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
#sideNav {
  height: 100%;
  width: 20%;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  padding-top: 20px;
  padding-bottom: 20px;
  overflow-x: hidden;
  border-right: solid lightgrey 1px;
}

</style>