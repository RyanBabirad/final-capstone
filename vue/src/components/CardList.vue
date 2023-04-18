<template>
  <section>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ppreflex.gif" />
    </div>
    <div v-else>
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <div class="boards">
        <board-column title="Pending" :requests="0" />
        <board-column title="In Progress" :requests="1" />
        <board-column title="Completed" :requests="2" />
      </div>
    </div>
  </div>
  </section>
</template>

<script>
import BoardColumn from '../components/BoardColumn.vue';
import BoardService from '../services/BoardService';

export default {
  name: "cardsList",
  components: {
    BoardColumn
  },
  data() {
    return {
      isLoading: true,
      errorMsg: ""
    };
  },
  methods: {
     retrieveCards() {
      BoardService
        .getCards()
        .then(response => {
          this.$store.commit("SET_BOARD_REQUESTS", response.data.requests);
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Board cards not available. This board may have been deleted or you have entered an invalid board ID."
            );
            this.$router.push({ name: 'staff' });
          }
        });
    }
  },
  created() {
    this.retrieveCards(); 
  },
  computed: {
    pending() {
      return this.$store.state.boardCards.filter(
        request => request.status === 0
      );
    },
    inProgress() {
      return this.$store.state.boardCards.filter(
        request => request.status === 1
      );
    },
    completed() {
      return this.$store.state.boardCards.filter(
        request => request.status === 2
      );
    }
  }
}
</script>

<style scoped>
  .boards {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}
.board-actions {
  text-align: center;
  padding: 20px 0;
}
.board-actions a:link,
.board-actions a:visited {
  color: blue;
  text-decoration: none;
}
.board-actions a:hover {
  text-decoration: underline;
}
.btn.addNewCard {
  color: #fff;
  text-decoration: none;
  background-color: #508ca8;
  border-color: #508ca8;
}
.header {
  display: flex;
  align-items: center;
}
.header h1 {
  flex-grow: 1;
}
</style>