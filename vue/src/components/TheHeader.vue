<template>
  <section class="nav">
    <ul>
      <li>
        <router-link class="links router-link-active" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'login' }" v-if="!isLoggedIn">Login</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'logout' }" v-if="isLoggedIn">Logout</router-link>&nbsp;
      </li>
      <li class="mr-auto">
        <router-link class="links router-link-active" v-bind:to="userPage" v-if="isLoggedIn">User Page</router-link>&nbsp;
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  name: "header",

  computed: {
    userPage() {

      const role = this.$store.state.user.authorities[0].name;
      if(role === 'ROLE_LANDLORD') {
        return { name: 'landlord' };
      } else if(role === 'ROLE_STAFF') {
        return { name: 'staff' };
      } else if(role === 'ROLE_TENANT') {
        return { name: 'tenant' };
      }
      else {
        return { name: 'home' };
      }
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
  background-color: #577D86;
  
}
.user-page{
  display: flex;
  justify-content: flex-end;

}
.links{
    margin:5px;
    padding-left: 10px;
    padding-right: 10px;
    color:black;
    border-radius: 8px;
    background-color:#577D86;
    border: 1px solid #577D86;
    font-family:monospace;
    letter-spacing:1px;
}
.links:hover {
  color:black;
  background-color: white;
  border: 1px solid white;
  cursor: pointer;
}
</style>