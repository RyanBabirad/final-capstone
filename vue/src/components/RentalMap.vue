<template>
  <section id="map"  style="position: relative;">
    <!-- responsible for displaying the map container on pages -->
     <div id="search-overlay" style="position: absolute; top: 10px; left: 10px; z-index: 1;">
    <div class="control">
    <input type="text" id="search-input" placeholder="Search for a place"></div>
     </div>
     <br>
     <br>
    <iframe
    
      

      width="800"
      height= "700"
      frameborder="0"
      style="border: solid #1A5F7A"
      referrerpolicy="no-referrer-when-downgrade"
      src="https://www.google.com/maps/embed/v1/search?key=AIzaSyCue3ihJyw2UNLJDQ23W8gagIfOVfkk800&q=rental+properties+in+Pittsburgh"
      allowfullscreen
    >
    
    </iframe>
  </section>
</template>

<script>





export default {

};
</script>

<style scoped>
  iframe{
    border-radius:5px;
    box-shadow: #1A5F7A 5px 5px 10px 2px;
  }
  #search-input{
    display: "flex";
    justify-content: "center";
    align-content: center;
    border:solid #1A5F7A;
    border-radius:4px;
    margin-left:6px;
    
  }
  #search-input:hover{
  cursor:pointer;
  background-color:rgb(240, 235, 235);
  color: white;
  border:solid rgb(165, 162, 162);
  border-radius:2px;
  }
</style>