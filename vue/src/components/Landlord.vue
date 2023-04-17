<template>
  <section >Hello, *insert user*!>
    <div class="landlordPage columns">
    <div class="column is-2 " id="firstcolumn">

      <!--this need to show properties -->

       <button @click="toggleForm" class="addPropertybutton" type="submit">Add Properties</button>
   
      <button @click="toggleForm" class="addTenantButton" type="submit">Add Tenants</button>


    <div class="addNewProperty" id="add" v-if="showForm">
      <form @submit.prevent="add">
        
         
        <div class="form-input-group" >
          <label for="streetAddress">Street Address</label>
          <div class="control">
            <input type=text id="streetAddress" v-model="property.streetAddress" required autofocus />
          </div>
        </div>
        <div class="form-input-group" v-if="showForm">
          <label for="unit">Unit</label>
            <div class="control">
              <input type="text" id="unit" v-model="property.unit" />
            </div>
        </div>
        <div class="form-input-group" v-if="showForm">
          <label for="state">State</label>
            <div class="control">
              <input type="text" id="state" v-model="property.state" required />
            </div>
        </div>
        <div class="form-input-group" v-if="showForm">
          <label for="zipcode">Zipcode</label>
            <div class="control">
              <input type="text" id="zipcode" v-model="property.zipcode" required />
            </div>
        </div>
        <div class="form-input-group" v-if="showForm">
          <label for="imgSrc">Image</label>
            <div class="control">
              <input type="file" class="custom-file-input" id="imgSrc" @change="handleFileUpload" @drop="handleFileDrop" />
              <label for="imgSrc" class="custom-file-label">{{ property.imgName }}</label>
            </div>
        </div>
        <br>
        <button class="addProperty" type="submit" v-if="showForm">Add</button>
      </form>
      </div>
      </div>
      <div class="column is-full is-2" id="secondcolumn">
        <p class="column maintenance"> Maintenance Requests</p>
        <!-- second column for the form -->
        </div>
      </div>
    <!-- import info box component(contains property info)  -->
    <!-- import maintenance Request overview component (landlord sees all incoming requests)  -->
  </section>
</template>

<script>
export default {
  name: "landlord",
  data() {
    return {
      property: {
        imgSrc: [],
        imgName: "",
        streetAddress: "",
        zipcode: "",
        state: "",
        unit: ""
      },
      showForm: false
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
  toggleForm(){
    this.showForm = !this.showForm;
  }
}
    /*component for info box and maintenance request*/ 
};
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
margin-left:25%;
 border:solid white;
  padding:50px;
}
.maintenance{
  display: flex;
  justify-content: center;
}
#secondcolumn{
 margin-right:25%;
 border:solid white;
  padding:50px;
}
.columns{
   column-gap:16%;
}



</style>