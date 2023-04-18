<template>
  <section>
      <h1>Edit Card</h1>
      <card-form v-bind:cardID="parseInt($route.params.cardID)" />
  </section>
</template>

<script>
import CardForm from '../components/CardForm.vue'
export default {
  components: {
      CardForm
      },

}
</script>

<style>

</style>