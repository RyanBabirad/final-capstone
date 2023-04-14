<template>
  <section class="nav">
    <ul>
      <li>
        <router-link class="links router-link-active" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;
        <router-link class="links router-link-active" v-if="$store.state.token === ''" v-bind:to="{ name: 'login' }">Login</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'landlord' }" v-if="$store.state.role = 'landlord'">Landlord</router-link>&nbsp;
        <router-link class="links router-link-active" v-bind:to="{ name: 'staff' }" v-if="$store.state.role= 'staff'">Staff</router-link>
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
  background-color: #006e7f;
  
}
.links{
    padding-left: 10px;
    padding-right: 10px;
    color: white;
}
.links:hover{
    color: #F8CB2E;
}
.profile{
    justify-content: flex-end;
}


</style>