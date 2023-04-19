<template>
  <section class="maintenanceRequests">
    <h1>Open Requests</h1>
    <br>
    <div class="openRequestsContainer">
      <p>You currently have no open requests</p>
    </div>
    <br>
    <button  @click="toggleForm" class="newRequest-button">Create New Request</button>
      <div class="newRequest" id="add" v-if="showForm">
        <card-form />
    </div>
  </section>
</template>

<script>
import CardForm from './CardForm.vue';

export default {
  components: { CardForm },
    name: "maintenanceRequest",
    data() {
        return{
      property: {
        // firstname:"",   **This should only contain the information relevant to the maintenanceRequest table**
        // lastname:"",
        // streetaddress:"",
        // city:"",
        // zip:"",
        // request:'',
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
        border:5px solid #1A5F7A;
        margin-top: 5%;
        margin-left: 10.5%;
        box-shadow: #002B5B 5px 5px 10px 2px;
        background-color:#159895;
        padding:5px;
        border-radius:10px;
        color:white;
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