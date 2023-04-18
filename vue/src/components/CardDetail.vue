<template>
  <section>
      <div class="loading" v-if="isLoading">
      <img src="../assets/ppreflex.gif" />
    </div>
    <div v-else>
      <h1>{{ request.title }}</h1>
      <p>{{ request.description }}</p>
      <router-link :to="{ name: 'EditCard', params: {cardID: $route.params.requestID} }" class="btn editCard">Edit Card</router-link>
      <button class="btn deleteCard" v-on:click="deleteCard">Delete Card</button>
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    </div>
  </section>
</template>

<script>
import BoardService from '../services/BoardService';

export default {
    name: "card-detail",
  data() {
    return {
      isLoading: true,
      errorMsg: "",
    };
  },
  methods: {
    retrieveCard() {
      BoardService
        .getCard(this.$route.params.requestID)
        .then(response => {
          this.$store.commit("SET_CURRENT_REQUEST", response.data);
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Card not available. This card may have been deleted or you have entered an invalid card ID."
            );
            this.$router.push({ name: 'staff' });
          }
        });
    },
    deleteCard() {
      if (
        confirm(
          "Are you sure you want to delete this card? This action cannot be undone."
        )
      ) {
        BoardService
          .deleteCard(this.request.id)
          .then(response => {
            if (response.status === 200) {
              alert("Card successfully deleted");
              this.$router.push('staff');
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error deleting card. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting card. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting card. Request could not be created.";
            }
          });
      }
    },
  },
  created() {
    this.retrieveCard();
  },
  computed: {
    card() {
      return this.$store.state.request;
    }
  }
}
</script>

<style scoped>
    .btn.editCard {
  color: #fff;
  text-decoration: none;
  background-color: #508ca8;
  border-color: #508ca8;
  margin-bottom: 10px;
}
.btn.deleteCard {
  color: #fff;
  background-color: #ef031a;
  border-color: #ef031a;
  margin-bottom: 10px;
}
</style>