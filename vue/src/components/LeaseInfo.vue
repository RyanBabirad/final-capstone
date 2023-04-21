<template>
  <section class="leaseInfo">
      <h1>Lease Information:</h1>
      <div class="propertyAddress">
        <br>
        <p>Street Address: {{ property.streetAddress }} </p>
        <p>Unit: {{ property.unit }} </p>
        <p>State: {{ property.state }} </p>
        <p>Zipcode: {{ property.zipCode }} </p>
        
      </div>
  </section>
</template>

<script>
import UserService from '../services/UserService';

export default {
  name: "leaseInfo",
  data() {
    return {
      landlord: {
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
      },
      property: {
        streetAddres: "",
        zipCode: "",
        unit: "",
        state: "",
        rentAmount: ""
      },  
    }
  },
  methods: {
  },
  created() {
    UserService.getLandlordByTenant().then(response => {
      this.landlord = response.data;
    })
    UserService.getPropertyByTenant().then(response => {
      this.property = response.data;
    })
  }
}
</script>


    PropertyDetails<style scoped>
  .leaseInfo{
    border: 5px solid #1A5F7A;
        margin-left: 5%;
        margin-right: 5%;
        margin-bottom: 30px;
         background-color:#002B5B;
        padding:5px;
        border-radius:10px;
        color:white;
         box-shadow: #002B5B 5px 5px 10px 2px;
  }
</style>