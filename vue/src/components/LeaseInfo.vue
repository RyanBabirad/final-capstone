<template>
  <section class="leaseInfo">
      <h1>Lease Information:</h1>
      <div class="propertyAddress">
        <p>*Show property info from store, probably using a prop or something idk*</p>
        <br>
        <p>Street Address:</p>
        <p>Unit:</p>
        <p>State:</p>
        <p>Zipcode:</p>
        
      </div>
  </section>
</template>

<script>


export default {
  name: "leaseInfo",

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