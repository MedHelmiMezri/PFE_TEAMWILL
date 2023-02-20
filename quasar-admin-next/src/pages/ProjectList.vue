<template>
  <q-page class="q-pa-sm bg-white">
    <div class="row q-col-gutter-sm">
    <table>
    <thead>
              <tr>
                <th class="text-left">
                 ID :
                </th>
                <th class="text-left">
                 Project Title :
                </th>
                <th class="text-left">
                 Description :
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="project in projects" :key="project.id">
                <td>{{ project.id }}</td>
                <td>{{ project.titreProjet }}</td>
                <td>{{ project.description }}</td>
              </tr>
            </tbody>
    </table>

    </div>
  </q-page>
</template>

<script>
import {defineComponent} from 'vue';
import {ref} from 'vue';
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
      projects : [] ,
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
    } ,
     readProjects: async function() {
      const data = await api.readProjects();
      this.projects = data;
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
