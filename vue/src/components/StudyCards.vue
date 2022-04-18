<template>
  <div>

  </div>
</template>

<script>
export default {


computed: {
    currentCard(){
        return this.cards[this.cardIndex]
    }
},
data(){
    return {
        cards: [],
        cardIndex: 0
    }
}}
</script>

<style>

</style>