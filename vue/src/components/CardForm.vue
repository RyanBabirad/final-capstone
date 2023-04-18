<template>
  <section>
    <form v-on:submit.prevent="submitRequest" class="cardForm">
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <div class="form-group">
        <label for="description">Description:</label>
        <textarea id="description" class="form-control" v-model="request.description"></textarea>
      </div>
      <button class="btn btn-submit">Submit</button>
    </form>
  </section>
</template>

<script>
//import moment from 'moment';
import BoardService from '../services/BoardService';

export default {
     name: "card-form",
  props: {
    requestID: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      request: {
        id: 0,
        status: 0,
        description: "",
        //avatar: "",
        date: null
      },
      errorMsg: ""
    };
  },
  methods: {
    submitRequest() {
      const newRequest = {
        id: this.request.id,
        description: this.request.description,
        status: this.request.status,
        //avatar: "https://randomuser.me/api/portraits/lego/1.jpg",
        //date: moment().format("MMM Do YYYY")
      };

      if (this.requestID === 0) {
        BoardService.addCard(newRequest).then(response => {
            if (response.status === 201) {
              this.$router.push({ name: 'staff' });
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "adding");
          });
      } else {
        newRequest.id = this.requestID;
        newRequest.description = this.request.description;
        //newCard.avatar = this.card.avatar;
        newRequest.date = this.request.date;
        BoardService.updateCard(newRequest).then(response => {
            if (response.status === 200) {
              this.$router.push({ name: 'staff' });
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "updating");
          });
      }
    },
    handleErrorResponse(error, verb) {
      if (error.response) {
        this.errorMsg =
          "Error " + verb + " request. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg =
          "Error " + verb + " request. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " request. Request could not be created.";
      }
    }
  },
  created() {
    if (this.requestID != 0) {
      BoardService.getCard(this.requestID).then(response => {
          this.request = response.data;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Request not available. This request may have been deleted or you have entered an invalid request ID."
            );
            this.$router.push({ name: 'staff' });
          }
        });
   }
  }
}
</script>

<style scoped>
    .cardForm {
  padding: 10px;
  margin-bottom: 10px;
}
.form-group {
  margin-bottom: 10px;
  margin-top: 10px;
}
label {
  display: inline-block;
  margin-bottom: 0.5rem;
}
.form-control {
  display: block;
  width: 80%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}
.btn-submit {
  color: #fff;
  background-color: #0062cc;
  border-color: #005cbf;
}
.btn-cancel {
  color: #fff;
  background-color: #dc3545;
  border-color: #dc3545;
}
.status-message {
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
}
</style>