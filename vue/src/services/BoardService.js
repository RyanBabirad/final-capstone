import axios from 'axios';

export default {

  getCards() {
    return 
  },

  getCard(requestID) {
    return axios.get(`/cards/${requestID}`)
  },

  addCard(request) {
    return axios.post('/staff/maintenance_request', request);
  },

  updateCard(request) {
    return axios.put(`/cards/${request.id}`, request);
  },

  deleteCard(requestID) {
    return axios.delete(`/cards/${requestID}`);
  },
}
