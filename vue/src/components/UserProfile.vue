<template>
  <section class="userProfileContainer">
    <div class="status-message success" v-show="successMsg !== ''">{{successMsg}}</div>
      <h2>Current Status: {{ user.role }}</h2>
      <p>Need to update your account to Tenant/Landlord/Staff?</p>
      <button @click="toggleForm" class="addPropertybutton" type="submit">Update Account</button>
      </div>
        <br>
      <div class="updateAcount" v-if="showForm">
        <form v-on:submit.prevent="submitUser">

          <div class="form-input-group">
            <label for="role">Select Role</label>
            <div class="control">
            <select id="selectRole" v-model="user.role" >
              <option  value="Tenant">Tenant</option>
              <option  value="Landlord">Landlord</option>
              <option  value="Staff">Staff</option>
            </select>
            </div>
        </div>
          
          <div class="form-in-group" id="info">
            <label for="firstname" >First Name</label>
            <div class="control">
            <input class="first-name-box" type="firstname" id="firstname" v-model="user.firstName" required />
            </div>
          </div>

        <div class="form-input-group" id="info">
          <label for="lastname"> Last Name</label>
          <div class="control">
          <input class="last-name-box" type="lastname" id="lastname" v-model="user.lastName" required />
          </div>
        </div>

        <div class="form-input-group text-center" id="info">
          <label for="emailaddress">Email Adrress</label>
          <div class="control">
          <input class="emailaddress-box" type="emailaddress" id="emailaddress" v-model="user.emailAddress" required />
          </div>
        </div>

        <div class="form-input-group" id="info">
          <label for="phonenumber">Phone Number</label>
          <div class="control">
          <input class="phonenumber-box" type="phonenumber" id="phonenumber" v-model="user.phoneNumber" required />
          </div>
        </div>
        <div class="control"
>        <button class="UpdateUser btn-submit" type="submit">Update</button>
</div>
        </form>
      </div>  
  </section>
</template>

<script>
import UserService from '../services/UserService';
export default {
  name: "user",
  data() {
    return {
      user: {
        role: "",
        firstName: "",
        lastName: "",
        emailAddress: "",
        phoneNumber: ""
      },
      showForm: false,
      successMsg: ""
    };
  },
    created() {
      const role = this.$store.state.user.authorities[0].name;
      if (role === 'ROLE_LANDLORD') {
        this.user.role === 'Landlord';
      } else if (role === 'ROLE_STAFF') {
        this.user.role === 'Staff';
      } else if (role === 'ROLE_TENANT') {
        this.user.role === 'Tenant';
      } else {
        this.user.role === 'User';
      }
      return this.user.role;
      
    },
  
  methods: {
    toggleForm() {
      this.showForm = !this.showForm;
    },
    submitUser() {
      const newUser = {
        role : this.user.role,
        firstName : this.user.firstName,
        lastName : this.user.lastName,
        email : this.user.emailAddress,
        phone : this.user.phoneNumber
      };
      
      UserService.createUser(newUser).then(response => {
        console.log(response.data);
        UserService.updateRole(newUser).then(response => {
          console.log(response.data)
          if (response.status === 200) {
              this.successMsg = "Your status has been updated!"
              this.user.role = "",
              this.user.firstName = "",
              this.user.lastName = "",
              this.user.emailAddress = "",
              this.user.phoneNumber = "",
              this.showForm = false;
          }
        })
        .catch(error => {
          console.log(error);
        });
      })
      .catch(error => {
        console.log(error);
      });
      
    }
  }

  }
</script>

<style scoped>
  .updateAcount {
    display: flex;
    justify-content: center;
  }

  .userProfileContainer{
     top: 20%;
  left: 10%;
  transform: translate(-50%, -50%);
  position: fixed;
  display:flex;
  justify-content: center;
  align-items: center;
  border-left:solid 5px #002B5B;
  margin-top:10%;
  padding-left:40px;
  padding-right:40px;
 
  
  margin-left:40%;
  margin-right:40%;
  background-color: #159895;
  border-radius:25px;
  color:white;
   width: 25%;
  height: 30%;
  }

</style>