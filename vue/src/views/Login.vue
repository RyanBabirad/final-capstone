<template>
<body class="main">
  <div class="login-page" id="login">
    <form @submit.prevent="login">
      <h1 class="sign-in">Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
         <div class="control">
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
         <div class="control">
        <input type="password" id="password" v-model="user.password" required />
      </div>
      </div>
      <button class="sign-submit" type="submit">Sign in</button>
      
      <p>
      <router-link class="links router-link-active" :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
              this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
#login{
  display:flex;
  justify-content: center;
  align-items: center;
  border:solid #57C5B6 ;
  margin-top:10%;
  padding-top:40px;
  padding-bottom: 50px;
  margin-left:40%;
  margin-right:40%;
  background-color: #57C5B6;
  border-radius:25px;
}
.sign-in{
  text-align:center;
  font-family:monospace;
  font-weight:bolder;
  font-size: x-large;
  color:black;
}
.sign-submit:hover{
  cursor:pointer;
  background-color:rgb(165, 162, 162);
  color: white;
  border:solid rgb(165, 162, 162);
  border-radius:2px;
}
.links{
  color:white;
}
.links:hover{
  cursor:pointer;
  color:#006E7F;
}
</style>