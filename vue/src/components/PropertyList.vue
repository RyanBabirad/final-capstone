<template>
  <section class="properties">
    <div class="loading" v-if="isLoading">
      <img src="" />
    </div>
    <div
      class="property"
      v-for="property in properties"
      v-bind:key="property.zpid"
    >{{ property.streetAddress }}</div>
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

<style>
</style>