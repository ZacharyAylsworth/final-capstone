<template>
  <div>
      <h1>Edit Card</h1>
      <card-form v-bind:cardID="parseINT($route.params.cardID)" /> 
  </div>
</template>



<script>
import CardForm from '@/components/CardForm';

export default {
    components: {
        CardForm
    }
};
</script>



<style>
</style>