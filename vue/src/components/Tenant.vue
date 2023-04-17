<template>
  <section class="tenantContainer">
      <h1 class="userGreeting">Hello, *insert user*!</h1>
      <br>
       <rent-details />

      <div class="columns">
        <div class="column maintenance">
          <maintenance-request />
        </div>
        <div class="column contact">
          <contact />
        </div>
      </div>

      <lease-info />
  </section>
</template>

<script>
import Contact from './Contact.vue'
import LeaseInfo from './LeaseInfo.vue'
import MaintenanceRequest from './MaintenanceRequest.vue'
import RentDetails from './RentDetails.vue'

export default {
  name: "tenant",
  components: {
    RentDetails,
    LeaseInfo,
    MaintenanceRequest,
    Contact

    },

}
</script>

<style scoped>
.tenantContainer{
  padding-top: 50px;
}

</style>