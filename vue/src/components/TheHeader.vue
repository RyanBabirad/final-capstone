<template>
  <section class="nav">
    <ul>
      <li>
        <router-link class="links router-link-active" v-bind:to="{ name: 'home' }" >Home</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'login' }"  v-if="!isLoggedIn">Login</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'logout' }" v-if="isLoggedIn">Logout</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'staff' }"  v-if="isStaff">Staff</router-link>&nbsp;
      </li>
    </ul>
  </section>
</template>

<script>

export default {
    name: "header",
    computed: {
      isLandlord() {
        return this.$store.state.user.authorities[0].name === 'ROLE_LANDLORD';
      },
      isStaff(){
        return this.$store.state.user.authorities[0].name === 'ROLE_STAFF';
      },
      isTenant() {
        return this.$store.state.user.authorities[0].name === 'ROLE_TENANT';
      },
      isLoggedIn() {
        return this.$store.state.token !== '';
      }
    }

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
  background-color: #006e7f;
  
}
.links{
    margin:5px;
    padding-left: 10px;
    padding-right: 10px;
    color:black;
    border-radius: 8px;
    background-color:white;
    border: 1px solid black;
    font-family:monospace;
    font-weight:bold;
    letter-spacing:1px;

}
.links:hover{
    color:white;
    background-color:#F8CB2E ;
    border: 1px solid #F8CB2E;
    cursor:pointer;
}


</style>