<template>
  <section class="contactInfo">
    <h1>Contact info</h1>
    <br>
    <div class="landlordInfo">
        <h3>My Landlord: {{ landlord.firstName }}. {{ landlord.lastName }} </h3>
        <p>Phone Number: {{ landlord.phone }} </p>
        <p>Email: {{ landlord.email }} </p>
    </div>
    <br>
    <div class="emergencyMaintenance">
        <h3>Emergency Contact Number:</h3>
        <p>412-867-5309</p>
    </div>
  </section>
</template>

<script>
import UserService from '../services/UserService'
export default {
  data() {
    return {
      landlord: {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
      }
    }
  },
  created() {
  UserService.getLandlordByTenant().then(response => {
      this.landlord = response.data;
    });
}

}
</script>

<style scoped>
    .contactInfo{
        border:5px solid #1A5F7A;
        margin-top: 5%;
        margin-right: 10.5%;
        box-shadow: #002B5B 5px 5px 10px 2px;
         background-color:#159895;
        padding:5px;
        border-radius:10px;
        color:white;
    }
</style>