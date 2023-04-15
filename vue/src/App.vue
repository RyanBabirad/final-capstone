<template>
  <section id="app">
    <the-header />
    <router-view />
  </section>
</template>

<script>
import TheHeader from "./components/TheHeader.vue";

export default {
  components: {
    TheHeader,
  },
};
</script>

<style scoped>

  
</style>

