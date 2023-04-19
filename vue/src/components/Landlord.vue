<template>
  <section >Hello, *insert user*!>
    <div class="landlordPage columns">
      <div class="column is-2 " id="firstcolumn">
        
        <div class="getPropertyByLandlord" v-for="property in properties" v-bind:key="property.id">
        <!--this need to show properties -->
          <div>{{property.streetAddress}}</div>
        </div>
        <div class="control">
          <button @click="toggleForm" class="addPropertybutton" type="submit">Add Properties</button>
        </div>
        <div class="addNewProperty" id="add" v-if="showForm">
          <form v-on:submit.prevent="addProperty">
      
        
            <div class="form-input-group" >
              <label for="streetAddress">Street Address</label>
              <div class="control">
                <input type=text id="streetAddress" v-model="property.streetAddress" required autofocus />
              </div>
            </div>
            <div class="form-input-group">
              <label for="unit">Unit</label>
                <div class="control">
                  <input type="text" id="unit" v-model="property.unit" />
                </div>
            </div>
            <div class="form-input-group">
              <label for="state">State</label>
                <div class="control">
                  <input type="text" id="state" v-model="property.state" required />
                </div>
            </div>
            <div class="form-input-group">
              <label for="zipcode">Zipcode</label>
                <div class="control">
                  <input type="text" id="zipcode" v-model="property.zipCode" required />
                </div>
            </div>
            <div class="form-input-group">
              <label for="imgSrc">Image</label>
                <div class="control">
                  <input type="file" class="custom-file-input" id="imgSrc" @change="handleFileUpload" @drop="handleFileDrop" />
                  <label for="imgSrc" class="custom-file-label">{{ property.imgName }}</label>
                </div>
            </div>
            <br>

            <div class="form-input-group">
              <label for="description"> Description:</label>
              <div class="control">
                <textarea type="text" id="description" v-model="property.description" placeholder="Enter something..." rows="3" max-rows="6"></textarea>
              </div>
            </div>

             <div class="form-input-group" >
              <label for="rent">Set Rent $</label>
              <div class="control">
                <input type=text id="rent" v-model="property.rent" required autofocus />
              </div>
              </div>
              <br>

            <button class="addProperty" type="submit">Add</button>
          </form>
        </div>
          <br>

          <div class="control">
            <button @click="toggleForm2" class="addTenantButton" type="submit" >Add Tenants</button>
          </div>
          <div class="addNewProperty" id="add" v-if="showForm2">
            <form @submit.prevent="add">
              <div class="form-input-group" >
                <label for="tenantName">Tenant Name</label>
                <div class="control">
                  <input type=text id="tenantName" v-model="property.tenantName" required autofocus />
                </div>
              </div>

              <div class="form-input-group" >
                <label for="tenantPhoneNumber">Tenant Phone Number</label>
                  <div class="control">
                    <input type=text id="tenantPhoneNumber" v-model="property.tenantPhoneNumber" required autofocus />
                  </div>
              </div>

              <div class="form-input-group" >
                <label for="tenantEmail">Tenant Email</label>
                <div class="control">
                  <input type=text id="tenantEmail" v-model="property.tenantEmail" required autofocus />
                </div>
              </div>
              <br>
              <button class="addTenant-button" type="submit">Add Tenant</button>
            </form>
          </div>
      </div>
      <div class="column is-full is-2" id="secondcolumn">
        <h3 class="column maintenance"> Pending Maintenance Requests</h3>
        <board-column :requests="pending" />

      </div>
    </div>
  </section>
</template>

<script>
import PropertyService from '../services/PropertyService';
import BoardColumn from './BoardColumn.vue';

export default {
  components: {
    BoardColumn
    },
  name: "landlord",
  data() {
    return {
      Form2:{
        TenantName:"",
        TenantPhoneNumber:"",
        TenantEmail:""
      },
      property: {
        imgSrc: [],
        imgName: "",
        streetAddress: "",
        zipCode: "",
        state: "",
        unit: "",
        description: "",
        text:""
      },
      showForm: false,
      showForm2: false,
      properties: []
    };
  },
  methods: {
    handleFileUpload(event) {
      const files = event.target.files;

      for(let i = 0; i < files.length; i++) {
        const file = files[i];
        const reader = new FileReader();
        reader.onload = () => {
        this.property.imgSrc = reader.result;
      };
      reader.readAsDataURL(file);
      }
    },
    handleFileDrop(event) {
      event.preventDefault();
      const files = event.dataTransfer.files;

       for(let i = 0; i < files.length; i++) {
        const file = files[i];

        const fileExtension = file.name.split('.').pop().toLowerCase();
         // console.log("File extension:", fileExtension);
        if (['png', 'jpeg', 'jpg', 'gif'].includes(fileExtension)) {
        const reader = new FileReader();
        reader.onload = () => {
        this.property.imgSrc = reader.result;
        this.property.imgName = file.name;
      };
      reader.readAsDataURL(file);
      } else {
        console.error("Invalid image file:", file.name);
      }
    }
  },
  addProperty() {
      const newProperty = {
        imgSrc : this.property.imgSrc,
        imgName : this.property.imgName,
        streetAddress : this.property.streetAddress,
        zipCode : this.property.zipCode,
        state : this.property.state,
        unit : this.property.unit,
        description : this.property.description,
        text : this.property.text
      };
      PropertyService.createProperty(newProperty).then(response => {
        console.log(response.data);
      }).catch(error => {
        console.log(error);
      })
    },
    assignTenant() {
      
    },
    toggleForm() {
      this.showForm = !this.showForm;
    },
    toggleForm2() {
      this.showForm2 = !this.showForm2;
    },
  },
  computed: {
    pending() {
      return this.$store.state.boardCards.filter(request => request.status === 0);
    }
  },
  created() {
    PropertyService.getPropertiesByLandlordId().then((response) => {
      this.properties = response.data;
      this.isLoading = false;
    })
  }

};
  //  onForm1Submit() {
  //     // handle form 1 submission here
  //     console.log('Form 1 submitted with data:', this.form1);
  //   },
  //   onForm2Submit() {
  //     // handle form 2 submission here
  //     console.log('Form 2 submitted with data:', this.form2);
  //   }
    /*component for info box and maintenance request*/ 
</script>

<style scoped>

.landlordPage{
  /*temporary to see the form */
  padding-top: 95px;
  
}
.addNewProperty{
  display: flex;
  justify-content: center;
  
  
}
#imgSrc {
  border: 2px dashed #ccc;
  padding: 10px;
  
}

#firstcolumn{
  margin-top:10%;
margin-left:25%;
background-color:#159895;
 border:solid 5px #1A5F7A;
  border-radius:40px;
  padding:50px;
  color:white;
   box-shadow: #002B5B 5px 5px 10px 2px;
}
.maintenance{
  display: flex;
  justify-content: center;
}
#secondcolumn{
  margin-top:10%;
 margin-right:25%;
 background-color:#159895;
 border:solid 5px #1A5F7A;
 border-radius:40px;
  padding:50px;
  color:white;
   box-shadow: #002B5B 5px 5px 10px 2px;
}
.columns{
   column-gap:16%;
}
#description{
  border-color:grey;
}
.addPropertybutton{
  background-color:#57C5B6;
  border:solid #57C5B6;
  border-radius:15px;
  color:white;
  display:flex;
  align-items: center;
  justify-content:center;
}
.addTenantButton{
   background-color:#57C5B6;
  border:solid #57C5B6;
  border-radius:15px;
  color:white;
}
.addTenant-button{
  background-color:#57C5B6;
  border:solid #57C5B6;
  border-radius:15px;
  color:white;
}
.addProperty{
   background-color:#57C5B6;
  border:solid #57C5B6;
  border-radius:15px;
  color:white;
}
.addPropertybutton:hover{
background-color:#1A5F7A;
border:#1A5F7A solid;
}
.addTenantButton:hover{
  background-color:#1A5F7A;
border:#1A5F7A solid;
}
.addProperty:hover{
  background-color:#1A5F7A;
border:#1A5F7A solid;
}
.addTenant-button:hover{
   background-color:#1A5F7A;
border:#1A5F7A solid;
}
.getPropertyByLandlord {
  border:solid white 5px;
}
</style>