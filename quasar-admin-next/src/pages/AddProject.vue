<template>
  <q-page class="q-pa-sm bg-white">
    <div class="row q-col-gutter-sm">
      <div>
    <q-card>
      <q-card-section>
        <div class="text-h6 text-indigo-8">
          Add new project
        </div>
        <div class="text-subtitle2">
        </div>
      </q-card-section>

      <q-separator></q-separator>
      <q-card-section class="q-pa-none">
      <div class="row">
              <div class="col-6">
                <q-item>
                  <q-input dense outlined class="full-width" v-model="project.titreProjet" label="First Name *"/>
                </q-item>
              </div>
              <div class="col-6">
                <q-item>
                  <q-input dense outlined class="full-width" v-model="project.budget" label="Last Name *"/>
                </q-item>
              </div>
              <div class="col-12">
                <q-item>
                  <q-input dense autogrow outlined v-model="project.dateLivraison" class="full-width"
                           label="Address line 1 *"/>
                </q-item>
              </div>
              <div class="col-12">
                <q-item>
                  <q-input dense autogrow outlined v-model="project.description" class="full-width"
                           label="Address line 2 *"/>
                </q-item>
              </div>
              <div class="col-6">
                <q-item>
                  <q-input dense outlined class="full-width" v-model="project.documentProjet" label="City *"/>
                </q-item>
              </div>
              <div class="col-6">
                <q-item>
                  <q-input dense outlined class="full-width" v-model="project.statut" label="State"/>
                </q-item>
              </div>


            </div>
      </q-card-section>
      <q-card-section>


      <q-btn class = "btn1" color="primary" label="Submit" v-on:click="createProject"/>
      <q-btn  class ="btn2" color="secondary" label="Add new Project " />
      </q-card-section>
    </q-card>
      </div>
    </div>

  </q-page>
</template>

<script>
import {defineComponent} from 'vue';
//import {ref} from 'vue';
import api from "../services/ProjectService";


export default defineComponent({
  name: "Checkout",
  data() {
    return {
      project: {
        titreProjet: "",
        budget: 0,
        dateLivraison: "",
        description: "",
        documentProjet: "",
        statut: ""
      },
      responseSuccess: false
    };
  },
  methods :{
    createProject: async function() {
      const requestData = {
        titreProjet: this.project.titreProjet,
        budget: this.project.budget,
        dateLivraison: this.project.dateLivraison,
        description:this.project.description,
        documentProjet: this.project.documentProjet,
        statut:this.project.statut
      };
      await api.createProject(requestData);
        this.project.titreProjet="";
        this.project.budget=0;
        this.project.dateLivraison="";
        this.project.description="";
        this.project.documentProjet="";
        this.project.statut="" ;
        this.$router.push('/pageone')
        this.responseSuccess = true;
    }
  }

})
</script>

<style scoped>
.btn1{
   margin-right: 20px;
}
.btn2{
   margin-right: 20px;
}
</style>
