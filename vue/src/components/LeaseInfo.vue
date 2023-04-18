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
    border: solid #002B5B;
        margin-left: 5%;
        margin-right: 5%;
        margin-bottom: 30px;
         background-color:#002B5B;
        padding:5px;
        border-radius:10px;
        color:white;
  }
</style>