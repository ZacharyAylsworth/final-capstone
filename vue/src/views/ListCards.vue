<template>
  <div class="ListCards">
    <!-- <h1>Cards</h1> -->
    <cards-list />
       <!-- <router-link v-bind:to="{name: 'CardForm'}"> Add A New Card </router-link> -->
  </div>
 
</template>
   

<script>

import CardsList from '../components/CardsList.vue';


export default {
    components: {
        
        CardsList
    }
}
</script>
