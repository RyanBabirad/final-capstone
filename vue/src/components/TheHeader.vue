<template>
  <section class="nav">
    <ul>
      <li>
        <router-link class="links router-link-active" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'login' }" v-if="!isLoggedIn">Login</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'logout' }" v-if="isLoggedIn">Logout</router-link>&nbsp;
       <router-link class="links router-link-active" v-bind:to="userPage" v-if="isLoggedIn">User Page</router-link>&nbsp;
          <img :src="logo" alt="Logo"  style="width: 100px; height: 40px;" class="log" >&nbsp;
        
 
      </li>
      
     
    </ul>
  </section>
</template>

<script>
import logo from '@/assets/logo.jpg';

export default {
  name: "header",

  computed: {
    userPage() {
    
      const role = this.$store.state.user;
      const initial = this.$store.state.user.authorities[0].name;
      if(role === 'ROLE_LANLORD') {
        return { name: 'landlord' };
      } else if(role === 'ROLE_STAFF') {
        return { name: 'staff' };
      } else if(role === 'ROLE_TENANT') {
        return { name: 'tenant' };
      } else if(initial === 'ROLE_USER') {
        return { name: 'user'};
      } else {
        return { name: 'home' };
      }
    },
    isLoggedIn() {
      return this.$store.state.token !== "";
    }
  },
   data() {
    return {
      logo: logo,
    };
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
  background-color: white;
  img: url("../assets/logo.jpg") no-repeat center center fixed;
 
  
}
.links{
    margin:5px;
    padding-left: 10px;
    padding-right: 10px;
    color:black;
    border-radius: 8px;
    background-color: white;
    border: 1px solid white;
    font-family:monospace;
    letter-spacing:1px;
}
.links:hover {
  color:white;
  background-color:#57C5B6;
  border: 1px solid white;
  cursor: pointer;
}
.log{
  justify-content: center;
  align-items: center;
  margin-top:5px;
}
</style>