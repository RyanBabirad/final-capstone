<template>
  <section>
      <staff />
  </section>
</template>

<script>
import Staff from '../components/Staff.vue'
export default {
    components: {
        Staff
    },
    created() {
    if (this.$store.state.boards.length > 0) {
      const firstBoard = this.$store.state.boards[0];
      this.$router.push({ name: 'Board', params: { id : firstBoard.id }})
    }         
  }
}
</script>

<style>

</style>