<template>
  <div>
      <h1 id="headingText">Study Session</h1>
    <study-cards v-bind:deckID="$route.params.deckID" />
  </div>
</template>

<script>
import StudyCards from '@/components/StudyCards';

export default {
  components: {
    StudyCards
  }
};
</script>



<style scoped>

#headingText {
  color: rgb(228, 228, 228);
  font-size: 50px;
  display: flex;
  justify-content: center;
}
</style>