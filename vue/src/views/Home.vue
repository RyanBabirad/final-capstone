<template>
  <div class="columns" style="myStyle" id="wrapper">
    <rental-map class="column map" />
    <property-list class="column properties" />
  </div>
</template>

<script>

import PropertyList from '../components/PropertyList.vue';
import RentalMap from '../components/RentalMap.vue';

export default {
  name: "home-view",
  components: {
    PropertyList,
    RentalMap,

  }
  
};
</script>


<style scoped>
.properties {
  margin-top: 80px;
  margin-left: 100px;
  margin-right:10px;
  text-align: center;
  background-color:#159895;
 border:solid #159895;
  border-radius:40px;
 /* border-radius: 10px;*/
}
.map {
  order: 1;
  margin-top: 80px;
  margin-right: 90px;
  margin-left:50px;
  text-align: center;
  background-color:#159895;
  border:solid #159895;
  border-radius:40px;
  /*border-radius: 5px;*/
}

</style>
