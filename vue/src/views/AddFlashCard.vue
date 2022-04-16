<template>
  <div>
      <h1 id="card_title"> Add New Flash Card</h1>
      <card-form />
  </div>
</template>

<script>
import CardForm from "@/components/CardForm";

export default {
    components: {
        CardForm
    }
};
</script>

<style scoped>
#card_title {
    text-align: center;
}

</style>