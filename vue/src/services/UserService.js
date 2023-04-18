import axios from 'axios';

export default {
    
    createLandlord(landlord) {
        return axios.post('/landlord', landlord)
    },
    createTenant(tenant) {
        return axios.post('/tenant', tenant)
    },
    createStaff(staff) {
        return axios.post('/staff', staff)
    }
}