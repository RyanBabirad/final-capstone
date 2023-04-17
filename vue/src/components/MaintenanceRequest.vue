<template>
    <section class="maintenanceRequests">
        <h1>Open Requests</h1>
        <br>
        <div class="openRequestsContainer">
            <p>You currently have no open requests</p>
        </div>
        <br>
        
        <button  @click="toggleForm" type="submit" class="newRequest-button">Create New Request</button>
            <div class="newRequest" id="add" v-if="showForm">
                <form @submit.prevent="add">

                    <br>
            
        <div class="form-input-group" >
          <label for="firstname">First Name</label>
          <div class="control">
            <input class="enter-boxes" type="firstname" id="firstname" v-model="property.firstname" required autofocus />
          </div>
        </div>

         <div class="form-input-group" >
          <label for="lastname">Last Name</label>
          <div class="control">
            <input class="enter-boxes" type="lastname" id="lastname" v-model="property.lastname" required autofocus />
          </div>
        </div>

         <div class="form-input-group" >
          <label for="streetaddress">Your Street Address</label>
          <div class="control">
            <input class="enter-boxes" type="streetaddress" id="streetaddress" v-model="property.streetaddress" required autofocus />
          </div>
        </div>

         <div class="form-input-group" >
          <label for="city">City</label>
          <div class="control">
            <input class="enter-boxes" type="city" id="city" v-model="property.city" required autofocus />
          </div>
        </div>

         <div class="form-input-group" >
          <label for="zip">Zip</label>
          <div class="control">
            <input class="enter-boxes" type="zip" id="zip" v-model="property.zip" required autofocus />
          </div>
        </div>

         <div class="form-input-group" >
          <label for="request">Type of Request</label>
          <div class="control">
            <input class="enter-boxes" type="request" id="request" v-model="property.request" required autofocus />
          </div>
        </div>

        <div class="form-input-group" >
          <label for="description">Please leave a description</label>
          <div class="control">
            <input class="enter-boxes" type="description" id="description" v-model="property.description" required autofocus />
          </div>
        </div>
            <br>
         <button class="sendRequestForm" type="submit" id="sendrequestform-button">Submit Request</button>

      </form>
      </div>
      
    </section>
</template>

<script>
export default {
    name: "maintenanceRequest",
    data() {
        return{
      property: {
          firstname:"",
          lastname:"",
          streetaddress:"",
          city:"",
          zip:"",
          request:'',
          description:"",

        
      },

            showForm: false
        };
    },
    methods:{
        toggleForm(){

    this.showForm = !this.showForm;
  }
    }
};
</script>

<style scoped>
    .maintenanceRequests{
        border-left:5px solid #81B214;
        margin-top: 5%;
        margin-left: 10.5%;
        margin-bottom: 60%;
        background-color:#EEEEEE;
        padding:5px;
        border-radius:10px;
    }
    .newRequest-button:hover{
        cursor:pointer;
        background-color:rgb(165, 162, 162);
        color: white;
        border:solid rgb(165, 162, 162);
        border-radius:2px; 
    }
    #sendrequestform-button:hover{
        cursor:pointer;
        background-color:rgb(165, 162, 162);
        color: white;
        border:solid rgb(165, 162, 162);
        border-radius:2px; 
    }
    .enter-boxes{
        border-color:white;
    }
</style>