<template>
  <q-page>
    <div class="row">
      <div class="col-12">
        <q-btn
          v-if="$q.screen.gt.xs"
          outline
          dense
          no-wrap
          icon="add"
          no-caps
          color="blue"
          label="Add Project"
          class="q-mt-sm q-ml-sm q-pr-sm bg-white"
          @click="add_new=true"

        ></q-btn>
        <q-btn-dropdown
          outline
          dense
          color="primary"
          icon="filter_list"
          class="q-mt-sm q-ml-sm bg-white"
          label="Add Filter"
        >
          <q-list>
            <q-item clickable v-close-popup>
              <q-item-section>
                <q-item-label>Filter 1</q-item-label>
              </q-item-section>
            </q-item>

            <q-item clickable v-close-popup>
              <q-item-section>
                <q-item-label>Filter 2</q-item-label>
              </q-item-section>
            </q-item>

            <q-item clickable v-close-popup>
              <q-item-section>
                <q-item-label>Filter 3</q-item-label>
              </q-item-section>
            </q-item>
          </q-list>
        </q-btn-dropdown>
        <q-input class="float-right q-mt-sm q-mr-sm bg-white" v-model="search" label="Search here" outlined dense
                 style="width: 35%">
          <template v-slot:append>
            <q-icon v-if="search !== ''" name="close" @click="search = ''" class="cursor-pointer"/>
            <q-icon name="search"/>
          </template>
        </q-input>
      </div>
    </div>
    <div class="col-3 q-px-xs">
      <div class="q-pa-xs column-background">
        <q-item style="background-color: #5e5e5e;border-top-left-radius: 4px;border-top-right-radius: 4px;"
                class="q-pa-none text-white q-pa-sm">
          <q-item-section avatar style="min-width:25px">
            <q-icon name="folder" class="q-pa-none q-ma-none"/>
          </q-item-section>
          <q-item-section class="text-h6 text-weight-bolder">Projects</q-item-section>
          <q-item-section avatar>
            <q-icon name="more_vert" class="cursor-pointer">
              <q-menu transition-show="rotate" transition-hide="rotate">
                <q-list style="min-width: 100px">
                  <q-item clickable>
                    <q-item-section>Mark all as completed</q-item-section>
                  </q-item>
                  <q-item clickable>
                    <q-item-section>Mark all as in progress</q-item-section>
                  </q-item>
                  <q-item clickable>
                    <q-item-section>Mark all as hold</q-item-section>
                  </q-item>
                </q-list>
              </q-menu>
            </q-icon>
          </q-item-section>
        </q-item>
        <draggable
          class="list-group"
          :list="projects"
          v-bind="dragOptions"
          @start="drag = true"
          @end="drag = false"
        >
        <template #item="{ element, index }">
          <q-list bordered class="rounded-borders cursor-move"
                style="border-left: 5px solid #07C7FA !important"  >
            <q-item class="bg-white">
              <q-item-section avatar>
                <q-icon name="task" color="black" size="34px"/>
              </q-item-section>

              <q-item-section style="font-size: 18px;" class="text-grey-9">
                {{ element.projectTitle}}
              </q-item-section>

              <q-item-section class="col-1">
                <q-avatar size="md">
                  <img src="https://api.dicebear.com/6.x/initials/svg?seed=Felix" alt="avatar"/>
                </q-avatar>
              </q-item-section>
              <q-item-section class="col-2">
                <div class="q-pa-sm q-gutter-md">
                  <q-badge
                    filled
                    class="q-pa-sm text-bold"
                    style="font-size: 15px"
                  >project status
                  </q-badge>
                </div>
              </q-item-section>

              <q-item-section side>
                <div class="text-grey-8 q-gutter-xs">
                  <q-btn class="q-mr-sm" size="12px" dense filled round color="blue" icon="message"/>
                  <q-btn class="q-mr-sm" size="12px" dense filled round color="orange" icon="flag"/>
                  <q-btn class="q-mr-lg" size="12px" dense filled round color="grey" icon="attachment"/>
                  <span style="width:125px" class="inline-block text-grey-9"><span v-if="element.due_date"></span></span>
                  <q-btn size="12px" @click="deleteProject(element.id)" color="red" flat dense round icon="delete"/>
                  <q-btn size="12px" color="green" flat dense round @click="updateLayout(element)" icon="settings"/>
                  <q-btn size="12px" @click="gotoprojectkanban(element.id)" color="blue" flat dense round icon="view_kanban"/>

                </div>
              </q-item-section>
            </q-item>
          </q-list>
        </template>

        </draggable>
      </div>
    </div>
    <q-dialog v-model="add_new" position="right"  >
      <q-card style="width: 600px ; height:600px">
        <q-card-section>
          <div class="text-h6">Add New Project :</div>
        </q-card-section>
        <q-separator/>
        <q-card-section class="row items-center no-wrap">
          <q-form class="q-gutter-md full-width">


            <q-input style="max-width: 1000px;" class="full-width" dense filled v-model="project.projectTitle" label="Project Name" hint="Name and surname" lazy-rules :rules="[val => val && val.length > 0 || 'Please type something']" />
            <q-input style="max-width: 1000px;" class="full-width" dense filled v-model="project.budget" type="number" label="Budget" lazy-rules :rules="[val => val !== null && val !== '' || 'Please type your principal', val => val > 0 || 'Please type a real principal']" />
            <q-input style="max-width: 1000px;" class="full-width" dense v-model="project.startDate" filled type="date"  />
            <q-input style="max-width: 1000px;" class="full-width" v-model="project.description" filled label="Desciption" hint="Name and surname" lazy-rules :rules="[val => val && val.length > 0 || 'Please type something']" />
            <q-input style="max-width: 1000px;" class="full-width" dense v-model="project.duration" filled type="number" label="Duration" lazy-rules :rules="[val => val !== null && val !== '' || 'Please type your principal', val => val > 0 || 'Please type a real principal']" />


            <div class="text-right justify-end">
              <q-btn @click="add_new=false" label="Cancel" type="submit" color="primary"/>
              <q-btn
                @click="saveProject"
                style="width: 90px"
                class="q-ml-sm"
                label="Add"
                type="submit"
                color="blue"
              />
            </div>
          </q-form>
        </q-card-section>

      </q-card>
    </q-dialog>
    <q-dialog v-model="set_project" position="right"  >
      <q-card style="width: 600px ; height:600px">
        <q-card-section>
          <div class="text-h6">Add New Project :</div>
        </q-card-section>
        <q-separator/>
        <q-card-section class="row items-center no-wrap">
          <q-form class="q-gutter-md full-width">
{{ selectedProject.projectTitle }}

            <q-input style="max-width: 1000px;" class="full-width" dense filled v-model="project.projectTitle" label="Project Name" hint="Name and surname" lazy-rules :rules="[val => val && val.length > 0 || 'Please type something']" />
            <q-input style="max-width: 1000px;" class="full-width" dense filled v-model="project.budget" type="number" label="Budget" lazy-rules :rules="[val => val !== null && val !== '' || 'Please type your principal', val => val > 0 || 'Please type a real principal']" />
            <q-input style="max-width: 1000px;" class="full-width" dense v-model="project.startDate" filled type="date"  />
            <q-input style="max-width: 1000px;" class="full-width" v-model="project.description" filled label="Desciption" hint="Name and surname" lazy-rules :rules="[val => val && val.length > 0 || 'Please type something']" />
            <q-input style="max-width: 1000px;" class="full-width" dense v-model="project.duration" filled type="number" label="Duration" lazy-rules :rules="[val => val !== null && val !== '' || 'Please type your principal', val => val > 0 || 'Please type a real principal']" />


            <div class="text-right justify-end">
              <q-btn @click="add_new=false" label="Cancel" type="submit" color="primary"/>
              <q-btn
                @click="saveProject"
                style="width: 90px"
                class="q-ml-sm"
                label="Add"
                type="submit"
                color="blue"
              />
            </div>
          </q-form>
        </q-card-section>

      </q-card>
    </q-dialog>
  </q-page>
</template>

<script>
    import ProjectService from "../../services/ProjectService";
    import draggable from "vuedraggable";
    import {Notify} from "quasar";


    export default {
        name: "Projects",


        data() {
            return {
              projects: [],
              project: {

              projectTitle: "",
              budget :0 ,
              startDate : "",
              description: "",
              duration : 0

              },
                search: "",

                add_new: false,
                set_project : false ,
                drag: false,
                submitted :false ,
                notification :  false ,
                selectedProject : null

            };
        },
        mounted(){
          const notification = this.$route.query.notification;
    if (notification === true) {
      this.$q.notify({
        type: 'positive',
        message: 'The new task is added successfully.'
      });
    }
        },
        created() {
            this.fetchProject() ;
          },
        computed: {
            dragOptions() {
                return {
                    animation: 200,
                    group: "description",
                    disabled: false,
                    ghostClass: "ghost"
                };
            },
        },
        methods: {
          saveProject() {
      var data = {
        projectTitle: this.project.projectTitle ,
        budget :this.project.budget ,
        startDate :this.project.startDate,
        description: this.project.description,
        duration : this.project.duration,

      };
         ProjectService.create(data)
        .then(response => {
          this.project.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
          this.$router.push({ path: '/projects'});

        })
        .catch(e => {
          console.log(e);
        });
    },


          async  fetchProject() {
              try {
                       const response = await ProjectService.getAll();
                       this.projects = response.data;
                       window.console.log(this.projects) ;
             }       catch (error) {
                      console.error(error);
                }
            } ,
            gotoprojectkanban(id) {
              this.$router.push({ path: '/k-board/' + id });

            } ,

            deleteProject(id) {
              ProjectService.delete(id);
              this.$router.go({path:'/projects'}) ;
              this.notification = true ;
              console.log(this.notification) ;
            //  this.$r outer.go({ path: '/projects' , query: { notification: 'success' }});
            },

            updateLayout(project) {
                 this.selectedProject = project ;
                 this.set_project = true ;
            }
        }
    };
</script>

<style scoped>
  .button {
    margin-top: 35px;
  }
  .flip-list-move {
    transition: transform 0.5s;
  }
  .no-move {
    transition: transform 0s;
  }
  .ghost {
    opacity: 0.5;
    background: #c8ebfb;
  }
  .list-group {
    min-height: 100vh;
  }
  .list-group-item {
    cursor: move;
  }
  .list-group-item i {
    cursor: pointer;
  }
  .cursor-move {
    cursor: move;
  }
  .border-todo {
    border-left: 5px solid #2fbb91 !important;
  }
  .feature-to-do {
    background-color: #2fbb91;
  }
  .to-do-title {
    background-color: rgb(47, 187, 145);
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
  }
  .border-in-progress {
    border-left: 5px solid #ee9835 !important;
  }
  .feature-in-progress {
    background-color: #ee9835;
  }
  .in-progress-title {
    background-color: #ee9835;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
  }
  .border-test {
    border-left: 5px solid blueviolet !important;
  }
  .feature-test {
    background-color: blueviolet;
  }
  .test-title {
    background-color: blueviolet;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
  }
  .border-done {
    border-left: 5px solid !important;
  }
  .feature-done {
    background-color: green;
  }
  .done-title {
    background-color: green;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
  }
  .to-do-title {
    background-color: rgb(47, 187, 145);
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
  }
  .bottom-right-radius {
    border-bottom-right-radius: 4px !important;
  }
  .tag-badge {
    border: 1px solid currentColor !important;
    border-radius: 4px !important;
  }
  .bug {
    background-color: red;
  }
  .box-shadow:hover {
    box-shadow: 0 2px 4px -1px rgba(0, 0, 0, 0.2), 0 4px 5px rgba(0, 0, 0, 0.14),
    0 1px 10px rgba(0, 0, 0, 0.12) !important;
  }
  .overlapping{ border: 2px solid white ;
  position: absolute;}

</style>
