<template>
<body class="main">
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <h1 class="create-account">Create Account</h1>
      <div class="control">
        <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
        </div>
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <div class="control">
        <input class="username-box" type="text" id="username" v-model="user.username" required autofocus />
        </div>
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <div class="control">
        <input class="password-box" type="password" id="password" v-model="user.password" required />
        </div>
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <div class="control">
        <input class="confirm-password-box" type="password" id="confirmPassword" v-model="user.confirmPassword" required />
        </div>
      </div>

      <div class="form-in-group">
        <label for="role">Select Role</label>
        <div class="control">
        <select id="selectRole" v-model="user.role" >
          
          <option  value="user">User</option>
          <option  value="tenant">Tenant</option>
          <option  value="landlord">Landlord</option>
          <option  value="staff">Staff</option>
        </select>


        <div class="form-input-group" id="info" v-if="user.role != 'user'">
        <label for="firstname" >First Name</label>
        <div class="control">
        <input class="first-name-box" type="firstname" id="firstname" v-model="user.firstname" required />
        </div>
      </div>

      <div class="form-input-group" id="info" v-if="user.role != 'user'">
        <label for="lastname"> Last Name</label>
        <div class="control">
        <input class="last-name-box" type="lastname" id="lastname" v-model="user.lastname" required />
        </div>
      </div>

      <div class="form-input-group" id="info" v-if="user.role != 'user'">
        <label for="emailaddress">Email Adrress</label>
        <div class="control">
        <input class="emailaddress-box" type="emailaddress" id="emailaddress" v-model="user.emailaddress" required />
        </div>
      </div>

      <div class="form-input-group" id="info" v-if="user.role != 'user'">
        <label for="phonenumber">Phone Number</label>
        <div class="control">
        <input class="phonenumber-box" type="phonenumber" id="phonenumber" v-model="user.phonenumber" required />
        </div>
      </div>

<!--need to make div and v-show edfault falsey for first last email and phone comp
then can make show or not in if state for if value of user tenant landlord or staff -->
        

        </div>
      </div>
      
      <div class="submit">
      <button class="submit-button" type="submit">Create Account</button>
    
     </div>
      <p>
        <router-link class="links router-link-active" :to="{ name: 'login' }"
          >Already have an account? Log in.</router-link>
      </p>
    </form>
  </div>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
      
       
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  
  },
};
</script>

<style scoped>
body{
  
  background-color: #569DAA;
  
}

.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;

}
#register{
  display:flex;
  justify-content: center;
  align-items: center;
  border:solid #87CBB9 ;
  margin-top:10%;
  padding-top:30px;
  padding-bottom: 50px;
  margin-left:40%;
  margin-right:40%;
  background-color: #87CBB9;
  border-radius:25px;

}
.create-account{
  text-align:center;
  font-family:monospace;
  font-weight:bolder;
  font-size: x-large;
  
}
.username-box{
  border-color:white;
}
.password-box{
  border-color:white;
}
.confirm-password-box{
  border-color:white;
}
#selectRole{
  border-color: white;

}
.submit{
  margin-top:10px;
  border-color: white;
  
}
.links{
  color:white;
}
.links:hover{
  cursor:pointer;
  color:#006E7F;
}
.submit-button:hover{
  cursor:pointer;
  background-color:rgb(165, 162, 162);
  color: white;
  border:solid rgb(165, 162, 162);
  border-radius:2px;
}
.first-name-box{
 border-color:white;
}
.last-name-box{
 border-color:white;
}
.emailaddress-box{
 border-color:white;
}
.phonenumber-box{
 border-color:white;
}
</style>
