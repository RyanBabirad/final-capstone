<template>
  <section class="nav">
    <ul>
      <li>
        <router-link class="links router-link-active" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'login' }" v-if="!isLoggedIn">Login</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'logout' }" v-if="isLoggedIn">Logout</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'landlord' }" v-if="isRole">landlord</router-link>&nbsp;
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  name: "header",
  computed: {
    isRole() {
      if (
        !this.$store.state.user ||
        !this.$store.state.user.authorities ||
        this.$store.state.user.authorities.length === 0
      ) {
        return false;
      } 

      if (this.$store.state.user.authorities[0].name === "ROLE_LANDLORD") {
      return this.$store.state.user.authorities[0].name === "ROLE_LANDLORD";
      }
      if (this.$store.state.user.authorities[0].name === "ROLE_STAFF") {
      return this.$store.state.user.authorities[0].name === "ROLE_STAFF";
      }
      if (this.$store.state.user.authorities[0].name === "ROLE_TENANT") {
      return this.$store.state.user.authorities[0].name === "ROLE_TENANT";
      }
      return this.$store.state.user.authorities[0].name
    },
    isLoggedIn() {
      return this.$store.state.token !== "";
    }
  },
};
</script>

<style scoped>
.nav {
  display: flex;
  flex-direction: row;
  width: 100%;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background-color: #1A5F7A;
  
}
.links{
    margin:5px;
    padding-left: 10px;
    padding-right: 10px;
    color:black;
    border-radius: 8px;
    background-color:white;
    border: 1px solid white;
    font-family:monospace;
    letter-spacing:1px;



}
.links:hover {
  color: white;
  background-color: #f8cb2e;
  border: 1px solid #f8cb2e;
  cursor: pointer;
}
</style>