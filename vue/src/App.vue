<template>
  <div class="rainbow">
    <section id="app" class="josie-testing">
      <the-header />
      <router-view />
    </section>
  </div>
</template>

<script>
import TheHeader from "./components/TheHeader.vue";

export default {
  components: {
    TheHeader,
  },
};
</script>

<style scoped>
.rainbow {
  /* background-image: url("assets/rainbow.jpg");
  background-size: 100%;
  height: 100%;
  width: 100%;
  left: 0;
  top: 0;
  overflow: hidden;
  position: fixed;
  display: "flex";
  align-items: "center";
  justify-content: center;
  height: "100%";
   */
   
  position: relative;
  overflow: hidden;
  height: 100vh;
  background: url("assets/rainbow.jpg") no-repeat center center fixed;
  background-size: cover;
}
.rainbow::before {
  content: "";
  position: absolute;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  transform: rotate(90deg);
  z-index: -1;
}
#josie-testing {
  height: 100vh;
}

</style>

