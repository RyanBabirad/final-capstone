<template>
  <section>
      <request-board />
      <contact />
  </section>
</template>

<script>
import RequestBoard from '../views/RequestBoard.vue';
import Contact from './Contact.vue';

export default {
  components: {
    RequestBoard,
    Contact
  }

}
</script>

<style>

</style>