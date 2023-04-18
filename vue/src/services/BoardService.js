import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080/staff"
});

export default {

  getCards() {
    return 
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)
  },

  addCard(card) {
    return http.post('/cards', card);
  },

  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);
  },
}
