import axios from 'axios';

export default {

    getProperties() {
        return axios.get('/');
    },
    createProperty(property) {
        return axios.post('/landlord/properties', property)
    }

}