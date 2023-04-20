import axios from 'axios';

export default {
    
    createUser(user) {
        const role = user.role;
        if (role === 'Landlord') {
          return axios.post('/landlord', user);
        } else if (role === 'Tenant') {
          return axios.post('/tenant', user);
        } else if (role === 'Staff') {
          return axios.post('/staff', user);
        } else {
          // Handle error if role is not recognized
          return Promise.reject(new Error(`Invalid user role: ${role}`));
        }
      },
      updateRole(user) {
        const role = user.role;
        if (role === 'Landlord') {
          return axios.put('/role', user);
        } else if (role === 'Tenant') {
          return axios.put('/role', user);
        } else if (role === 'Staff') {
          return axios.put('/role', user);
        } else {
          // Handle error if role is not recognized
          return Promise.reject(new Error(`Invalid user role: ${role}`));
      }
    },
    assignTenant(tenantId) {
      return axios.put(`/landlord/tenant/${tenantId}`)
    },
    getUpdatedRole() {
      return axios.get('/changeRole')
    }
    
}