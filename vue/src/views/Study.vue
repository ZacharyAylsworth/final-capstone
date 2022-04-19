<template>
  <div>
      <h1>Study</h1>
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

<style>

</style>