<template>
  <section id="properties">
    <div class="loading" v-if="isLoading">
      <img src="../assets/ppreflex.gif" />
    </div>
    <div class="property" v-for="property in properties" v-bind:key="property.zpid">
      {{ property.streetAddress }}
      {{ property.city }}
      <br>
      
    </div>
  </section>
</template>

<script>
import PropertyService from '../services/PropertyService';

export default {
  name: "property-list",
  data() {
    return {
      properties:[],
      isLoading: true,
    };
  },
  created() {
    PropertyService.getProperties()
    .then((response) => {
      this.properties = response.data;
    });
  }


};
</script>

<style scoped>
#properties {
  display: flex;
  justify-content: flex-start;
}
</style>