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
  margin-top: 35px;
  text-align: center;
  background-color:#f7f6f4fa;
  border: solid #006E7F;
 /* border-radius: 10px;*/
}
.map {
  order: 1;
  margin-top: 35px;
  text-align: center;
  background-color:#ebebeb;
  border: solid #006E7F;
  /*border-radius: 5px;*/
}

</style>
