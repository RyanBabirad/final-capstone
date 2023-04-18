import axios from 'axios';

export default {

    createLandlord(landlord) {
        return axios.post('/landlord/testing', landlord)
    },

    saveProperty(property) {
        return axios.post('/landlord/', property)
    }

}