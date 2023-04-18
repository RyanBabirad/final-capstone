<template>
  <section class="userProfileContainer">
     
      <h2>Current Status: {{ user.role }}</h2>
       
      <div class="control">
      <p>Need to update your account to Tenant/Landlord/Staff?</p>
      </div>
      <br>
      
      <button @click="toggleForm" class="addPropertybutton" type="submit">Update Account</button>
      <div class="control">
      </div>

      <div class="updateAcount" v-if="showForm">
        <form @submit.prevent="updateAccount">

          <div class="form-in-group">
            <label for="role">Select Role</label>
            <div class="control">
            <select id="selectRole" v-model="user.role" >
              <option  value="Tenant">Tenant</option>
              <option  value="Landlord">Landlord</option>
              <option  value="Staff">Staff</option>
            </select>
            </div>
        </div>

          <div class="form-input-group" id="info">
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
        <button class="UpdateUser" type="submit">Update</button>
        </form>
      </div>  
  </section>
</template>

<script>
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
      showForm: false
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
    }
  }

  }
</script>

<style scoped>
  .userProfileContainer {
    padding-top: 50px;
  }
  .updateAcount {
    display: flex;
    justify-content: center;
  }

  .userProfileContainer{
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

</style>