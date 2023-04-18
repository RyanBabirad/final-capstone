import axios from 'axios';

export default {

    getProperties(property) {
        return axios.get('/', property)
    }

}