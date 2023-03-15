<template>
    <q-page class="q-pa-sm">
      <div class="row">
      <div class="col">
        <q-btn color="blue" icon="list" label="Dashboard" />
      </div>
      
      </div>
      
      <q-card>
      
      <q-card-section class="q-mt-sm bg-light-blue">
        <q-btn  label="Click me" class="float-right text-capitalize text-blue shadow-3" icon="settings">
        <q-menu>
          <q-list dense style="min-width: 100px">
            <q-item clickable v-close-popup>
              <q-item-section>Open...</q-item-section>
            </q-item>
            <q-item clickable v-close-popup>
              <q-item-section>New</q-item-section>
            </q-item>
            <q-separator />
            <q-item clickable>
              <q-item-section>Preferences</q-item-section>
              <q-item-section side>
                <q-icon name="keyboard_arrow_right" />
              </q-item-section>

              <q-menu anchor="top end" self="top start">
                <q-list>
                  <q-item
                    v-for="n in 3"
                    :key="n"
                    dense
                    clickable
                  >
                    <q-item-section>Submenu Label</q-item-section>
                    <q-item-section side>
                      <q-icon name="keyboard_arrow_right" />
                    </q-item-section>
                    <q-menu auto-close anchor="top end" self="top start">
                      <q-list>
                        <q-item
                          v-for="n in 3"
                          :key="n"
                          dense
                          clickable
                        >
                          <q-item-section>3rd level Label</q-item-section>
                        </q-item>
                      </q-list>
                    </q-menu>
                  </q-item>
                </q-list>
              </q-menu>

            </q-item>
            <q-separator />
            <q-item clickable v-close-popup>
              <q-item-section>logout</q-item-section>
            </q-item>
          </q-list>
        </q-menu>
      </q-btn>


        <div class="text-h5 text-weight-bolder ">
          <q-icon name="style" size="1em" class="mdi-size-l" />
          Project File 
        </div>
      </q-card-section>
      <q-separator></q-separator>
      <q-list >
        <q-item>
          <q-item-section v-if="project">
            <div class="row">
                   <div class="col">
                    <div class="text-weight-bolder  text-h6">
                        Project Title :
                    </div>
                    <div>
                      {{ project.projectTitle }}

                    </div>
                    </div>
            <div class="col">
                    <div class="text-weight-bolder text-h6">
                        Budget : 
                    </div>
                    <div>
                      {{ project.budget }}

                    </div>
              
                      {{ project.moudles }}
            </div>
            </div>
          </q-item-section>
        </q-item>

        <q-separator inset="item"/>
        <q-item>
          <q-item-section>
            <div class="row">
                   <div class="col">
                    <div class="text-weight-bolder text-h6">
                        Start Date : 
                    </div>
                    <div>
                      {{ project.startDate }}
                    </div>
                    </div>
            <div class="col">
                    <div class="text-weight-bolder text-h6">
                        Duration : 
                    </div>
                   <div>
                    {{ project.duration }}
                   </div>
                       
            </div>
            </div>
            <q-separator inset="item"/>
            <q-card-section>
              <div class="row">
                <div class="col">
                <div class="text-weight-bolder text-h6">
                        Description : 
                    </div>
                    <div>
                      <p>{{ project.description }}</p>
                    </div>
                   
              </div>
              </div>
              
              
            </q-card-section>
          </q-item-section>
        </q-item>
      </q-list>
    </q-card>

    <q-card class="q-mt-sm">
        <div class="q-mt-sm" >
    <q-tree
      :nodes="simple"
      node-key="label"
    />
  </div>
    </q-card>
    <q-card class="q-mt-sm">
    <div>

      <table-actions class="q-mt-lg"></table-actions>    </div>
    </q-card>
    </q-page>
  
    
</template>
<script>
import {defineComponent, defineAsyncComponent} from 'vue';
//import {ref} from 'vue';

import ProjectService from "../../services/ProjectService";


export default defineComponent({
    components: {
      TableActions: defineAsyncComponent(() => import('components/tables/TableActions')),
  },
  data() {
    return {
      project: {},
    };
  },
    setup () {
    return {
      simple: [
        {
          label: 'Project Modules',
          children: [
            {
              label: 'module 1 ',
              icon: 'list',
              
            },
            {
              label: 'module 1 ',
              icon: 'list',
              
            },
            {
              label: 'module 1 ',
              icon: 'list',
              
            },
            {
              label: 'module 1 ',
              icon: 'list',
              
            },
           
          ]
        }
      ]
    }
  } ,
  async created(){
    const projectId = this.$route.params.id;
    try {
      const response = await ProjectService.get(projectId) ; 


      
      this.project =response.data;
      console.log(response.data) ;
    } catch (error) {
      console.error(error);
    }
  }
})


</script>