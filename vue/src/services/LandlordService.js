import axios from 'axios';

export default {

    createLandlord(landlord) {
        return axios.post('/landlord', landlord)
    },

    saveProperty(property) {
        return axios.post('/landlord/properties', property)
    }

}