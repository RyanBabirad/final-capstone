<template>
  <section id="properties">
    <div class="loading" v-if="isLoading">
      <img src="../assets/ppreflex.gif" />
    </div>
    <div v-for="property in properties" v-bind:key="property.zpid">
      <div  class="property">
        <img :src="property.imgSrc" class="property-image">
        <div class="property-details">
          <div class="property-address">{{ property.streetAddress }}</div>
          <div class="property-unit">{{ property.unit }}</div>
          <div class="property-city">{{ property.city }} {{ property.state }}, {{ property.zipCode }}</div>
          <div class="property-description">{{ property.description }}</div>
        </div>
      </div>
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
      this.isLoading = false;
    });
  }


};
</script>

<style scoped>
.loading {
  display: flex;
  
}
.property {
  display: flex;
  margin-bottom: 10px;
}

.property-image {
  width: 300px;
  height: 200px;
  object-fit: cover;
  margin-right: 10px;
}

.property-details {
  display: flex;
  flex-direction: column;
}

.property-address {
  font-size: 26px;
  font-weight: bold;
}

.property-unit,
.property-city {
  font-size: 18px;
  color: #888;
  display: flex;
  align-items: center;
}

.property-unit::before,
.property-city::before {
  margin-right: 5px;
}

.property-description {
  font-size: 14px;
  color: #777;
}
</style>