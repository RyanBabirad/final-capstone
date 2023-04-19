<template>
  <section id="properties">
    <div class="loading" v-if="isLoading">
      <img class="float-left" src="../assets/ppreflex.gif" />
    </div>
    <div v-for="property in properties" v-bind:key="property.zpid">
      <div  class="property" >
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
.image-row{
  display:flex;
  align-items:center;
}
.loading {
  display: flex;
  
}
.property {
  display: flex;
  margin-bottom: 10px;
  border:solid 5px #1A5F7A;
  border-radius:5px;
  padding:10px;
  box-shadow: #1A5F7A 5px 5px 10px 2px;
  
}

.property-image {
  width: 300px;
  height: 200px;
  object-fit: cover;
  margin-right: 10px;
  margin-top:20px;
  border-radius:5px;
  border:solid 5px white;
  box-shadow: #1A5F7A 5px 5px 10px 2px;

}

.property-details {
  display: flex;
  flex-direction: column;
  margin-top: 10px;
  text-shadow: #1A5F7A 5px 5px 10px 2px;;
}

.property-address {
  font-size: 26px;
  font-weight: bold;
  color:white;
  margin-right:10px;
}

.property-unit,
.property-city,
.property-description {
  font-size: 18px;
  color:white ;
  align-items: center;
}

.property-unit::before,
.property-city::before {
  margin-right: 5px;
}

.property-description {
  font-size: 14px;
  color: white;
  text-align: justify;
  padding:5px;
}
.float-left{
float:left;
margin:0 10px 10px 0;
}

</style>