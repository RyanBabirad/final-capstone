<template>
  <section id="properties">
    <div class="loading" v-if="isLoading">
      <img src="../assets/ppreflex.gif" />
    </div>
    <div class="property" v-for="property in properties" v-bind:key="property.zpid">
      {{ property.streetAddress }}
      {{ property.city }}
      
    </div>
  </section>
</template>

<script>


export default {
  name: "property-list",
  data() {
    return {
      properties: [{
          streetAddress: "123 Main st",
          state: "PA",
          city: "Pittsburgh"
      },
      {
          streetAddress: "455 Second st",
          state: "PA",
          city: "Pittsburgh"
      }
      ],
      isLoading: true,
    };
  },


};
</script>

<style scoped>
#properties {
  display: flex;
  justify-content: flex-start;
}
</style>