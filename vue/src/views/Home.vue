<template>
  <div>
    <the-header />
    <br>
    <!-- map component --> 
    <property-list />
  </div>
</template>

<script>
import PropertyList from '../components/PropertyList.vue';
import TheHeader from '../components/TheHeader.vue';

export default {
  name: "home-view",
  components: {
    TheHeader,
    PropertyList
    
  }
};
</script>


<style scoped>

</style>
