<template>
  <section class="rentDetails">
      <h1>Your next rent is due *insert date*</h1>
      <br>
      <button @click="toggleForm" class="makePayment" type="submit">Make a Payment</button>
         <div class="money" id="add" v-if="showForm">
                <form @submit.prevent="add">
                    <br>

             <div class="form-input-group" >
          <label for="dollaramount">$</label>
            <input class="money-boxes" type="dollaramount" id="dollaramount" v-model="property.dollaramount" required autofocus />
        </div>

         <div class="form-input-group" >
          <label for="date">Date</label>
          <div class="control">
            <input class="money-boxes" type="date" id="date" v-model="property.date" required autofocus />
        </div>
        </div>

         <div class="form-input-group" >
          <label for="routingNumber">Routing Number</label>
          <div class="control">
            <input class="routingNumber-box" type="routingNumber" id="routingNumber" v-model="property.routingNumber" required autofocus />
        </div>
        </div>

         <div class="form-input-group" >
          <label for="bankAccountNumber">Bank Account Number</label>
          <div class="control">
            <input class="bankAccountNumber-box" type="bankAccountNumber" id="bankAccountNumber" v-model="property.bankAccountNumber" required autofocus />
        </div>
        </div>

        </form>
        </div>
  </section>
</template>

<script>
export default {
    name: "rentDetails",
    data() {
        return{
      property: {
          EnterDollarAmount:"",
          Date:"",
          RoutingNumber:"",
          BankAccountNumber:""
      },

            showForm: false
        };
    },
    methods:{
        toggleForm(){

    this.showForm = !this.showForm;
  }
    }
}
</script>

<style scoped>
    .rentDetails{
        border:5px solid #EE5007;
        margin-left: 5%;
        margin-right: 5%;
        background-color:white;
        padding:5px;
        border-radius:10px;
    }

</style>