<template>
  <div class="columns">
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
}
.map {
  order: 1;
  border-left: 20px double #B22727;
  margin-top: 35px;

}

</style>
