<template>
  <section class="nav">
    <ul>
      <li>
        <router-link class="links router-link-active" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;
        <router-link class="links router-link-active" v-if="$store.state.token === ''" v-bind:to="{ name: 'login' }">Login</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'landlord' }" v-if="$store.state.role = 'landlord'">Landlord</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'staff' }" v-if="$store.state.role= 'staff'">Staff</router-link>
        <router-link class="links router-link-active" v-bind:to="{ name: 'home' }" tag="button">Home</router-link>&nbsp;
        <router-link class="links router-link-active" v-if="$store.state.token === ''" v-bind:to="{ name: 'login' }" tag="button">Login</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" tag="button">Logout</router-link>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
    
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
.links:hover{
    color:white;
    background-color:#F8CB2E ;
    border: 1px solid #F8CB2E;
    cursor:pointer;
}
.profile{
    justify-content: flex-end;
}


</style>