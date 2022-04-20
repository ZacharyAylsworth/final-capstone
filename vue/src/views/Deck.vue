<template>
  <div>
    <h1 id="upper_deck_text">Add Deck</h1>
    <cards-list />
  </div>
</template>

<script>
import CardsList from '@/components/CardsList';

export default {
  components: {
    CardsList
  }
};
</script>

<style>
#upper_deck_text {
  color: rgb(228, 228, 228);
  font-size: 50px;
  display: flex;
  justify-content: center;
}


</style>