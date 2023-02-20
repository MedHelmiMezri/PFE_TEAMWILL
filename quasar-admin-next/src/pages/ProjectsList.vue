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
                 <th class="text-left">
                 Date :
                </th>
                 <th class="text-left">
                 Budget :
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="project in projects" :key="project.id">
                <td>{{ project.id }}</td>
                <td>{{ project.titreProjet }}</td>
                <td>{{ project.description }}</td>
                <td>{{ project.dateLivraison }}</td>
                <td>{{ project.budget }}</td>
                <td><ul>
                <li v-for="sprint  in project.sprints" :key="sprint">{{sprint.id}}</li>
                </ul></td>

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
      projects:[] ,
      responseSuccess: false
    };
  },
  methods :{

     readProjects: async function() {
      const data = await api.readProjects();
      this.projects = data;
    }
  } ,
    mounted() {
     this.readProjects();
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
