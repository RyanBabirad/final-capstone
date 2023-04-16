<template>
  <section class="landlordPage">
    <h1 class="userGreeting">Hello, *insert user*!</h1>
    <br>
    <div class="addNewProperty" id="add">
      <form @submit.prevent="add">
        <div class="form-input-group">
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
              <input type="text" id="zipcode" v-model="property.zipcode" required />
            </div>
        </div>
        <div class="form-input-group">
          <label for="imgSrc">Image</label>
            <div class="control">
              <input type="file" class="custom-file-input" id="imgSrc" @change="handleFileUpload" @drop="handleFileDrop" />
              <label for="imgSrc" class="custom-file-label">{{ property.imgName }}</label>
            </div>
        </div>
        <button class="addProperty" type="submit">Add Property</button>
      </form>
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
      }
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
  }
}
    /*component for info box and maintenance request*/ 
};
</script>

<style scoped>
.landlordPage{
  /*temporary to see the form */
  padding-top: 250px;
}
.addNewProperty{
  display: flex;
  justify-content: center;
}
#imgSrc {
  border: 2px dashed #ccc;
  padding: 10px;
}


</style>