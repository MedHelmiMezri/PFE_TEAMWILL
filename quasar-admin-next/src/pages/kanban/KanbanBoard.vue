<template>
  <div class="row">
      <div class="col-12">
        <q-btn
          v-if="$q.screen.gt.xs"
          outline
          dense
          no-wrap
          icon="add"
          no-caps
          color="green"
          label="Add Task"
          class="q-mt-sm q-ml-sm q-pr-sm bg-white"
          @click="add_new = true"
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
  <div class="row">
    <div class="col-3 col-3 q-px-xs">
      <div class="q-pa-xs column-background">
          <q-item style="cursor: move;" class="q-pa-none text-white q-pa-sm to-do-title">
            <q-item-section avatar style="min-width:25px">
              <q-icon name="list" class="q-pa-none q-ma-none"/>
            </q-item-section>
            <q-item-section class="text-h6 text-weight-bolder">Backlog</q-item-section>
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
        :list="taskbacklog"
        group="done"
        v-bind="dragOptions"
        @change="onChange"
        @drop = "dropHandlebacklog"
        itemKey="id"
      >
      <template #item="{ element, index }">

<q-card
    square
    flat
    bordered
    class="box-shadow cursor-move bg-white q-mt-xs list-group-item border-test"
    @click="showDetails(element)"
  >
  <q-avatar
      class="q-pa-none feature-test bottom-right-radius"
      size="25px"
      dense
      text-color="white"
    >
      <q-icon
        filled
        size="xs"
        name ="assignment"
      />
    </q-avatar>
    <span class="text-caption text-grey-9 q-ml-xs">
      #{{element.id}}
      <q-icon
        filled
        size="xs"
        name="close"
        class="float-right text-weight-bolder"
        />
      <q-badge class="float-right q-my-md" size="md">
        affected user
      </q-badge>
    </span>

  <q-card-section class="q-pt-sm">
      <div class="row items-center no-wrap">
        <div class="col">
          <div>{{element.titreTache}}</div>
        </div>
        <div class="col">
          <div>start date</div>
        </div>
      </div>
    </q-card-section>            <q-badge
      outline
      class="q-mx-xs text-bold tag-badge"
      color="red"
    >  priority
    </q-badge>
</q-card>

</template>
      </draggable>
    </div>
    </div>

    <div class="col-3 col-3 q-px-xs">
      <div class="q-pa-xs column-background">
          <q-item style="cursor: move;" class="q-pa-none text-white q-pa-sm in-progress-title">
            <q-item-section avatar style="min-width:25px">
              <q-icon name="sync" class="q-pa-none q-ma-none"/>
            </q-item-section>
            <q-item-section class="text-h6 text-weight-bolder">In progress</q-item-section>
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
        :list="taskinprogress"
        group="done"
        v-bind="dragOptions"
        @change="onChange"
        @drop = "dropHandleinprogress"
        itemKey="id"
      >
      <template #item="{ element, index }">

<q-card
    square
    flat
    bordered
    class="box-shadow cursor-move bg-white q-mt-xs list-group-item border-in-progress"
    @click="showDetails(element)"
  >
  <q-avatar
      class="q-pa-none feature-in-progress bottom-right-radius"
      size="25px"
      dense
      text-color="white"
    >
      <q-icon
        filled
        size="xs"
         name="assignment"      />
    </q-avatar>
    <span class="text-caption text-grey-9 q-ml-xs">
      #{{element.id}}
      <q-icon
        filled
        size="xs"
        name="close"
        class="float-right text-weight-bolder"
        />
      <q-badge class="float-right q-my-md" size="md">
        affected user
      </q-badge>
    </span>

  <q-card-section class="q-pt-sm">
      <div class="row items-center no-wrap">
        <div class="col">
          <div>{{element.titreTache}}</div>
        </div>
        <div class="col">
          <div>start date</div>
        </div>
      </div>
    </q-card-section>            <q-badge
      outline
      class="q-mx-xs text-bold tag-badge"
      color="red"
    >  priority
    </q-badge>
</q-card>

</template>
      </draggable>
      </div>
    </div>
    <div class="col-3 col-3 q-px-xs">
      <div class="q-pa-xs column-background">
          <q-item style="cursor: move;" class="q-pa-none text-white q-pa-sm test-title">
            <q-item-section avatar style="min-width:25px">
              <q-icon name="compare_arrows" class="q-pa-none q-ma-none"/>
            </q-item-section>
            <q-item-section class="text-h6 text-weight-bolder">Test</q-item-section>
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
        :list="tasktest"
        group="done"
        v-bind="dragOptions"
        @change="onChange"
        @drop = "dropHandletest"
        itemKey="id"
      >
      <template #item="{ element, index }">

<q-card
    square
    flat
    bordered
    class="box-shadow cursor-move bg-white q-mt-xs list-group-item border-test"
    @click="showDetails(element)"
  >
  <q-avatar
      class="q-pa-none feature-test bottom-right-radius"
      size="25px"
      dense
      text-color="white"
    >
      <q-icon
        filled
        size="xs"
        name ="assignment"
      />
    </q-avatar>
    <span class="text-caption text-grey-9 q-ml-xs">
      #{{element.id}}
      <q-icon
        filled
        size="xs"
        name="close"
        class="float-right text-weight-bolder"
        />
      <q-badge class="float-right q-my-md" size="md">
        affected user
      </q-badge>
    </span>

  <q-card-section class="q-pt-sm">
      <div class="row items-center no-wrap">
        <div class="col">
          <div>{{element.titreTache}}</div>
        </div>
        <div class="col">
          <div>start date</div>
        </div>
      </div>
    </q-card-section>            <q-badge
      outline
      class="q-mx-xs text-bold tag-badge"
      color="red"
    >  priority
    </q-badge>
</q-card>

</template>
      </draggable>
    </div>
    </div>
    <div class="col-3 col-3 q-px-xs">
      <div class="q-pa-xs column-background">
          <q-item style="cursor: move;" class="q-pa-none text-white q-pa-sm done-title">
            <q-item-section avatar style="min-width:25px">
              <q-icon name="las la-check-circle" class="q-pa-none q-ma-none"/>
            </q-item-section>
            <q-item-section class="text-h6 text-weight-bolder">Done</q-item-section>
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
        :list="taskdone"
        group="done"
        v-bind="dragOptions"
        @change="onChange"
        @drop = "dropHandledone"
        itemKey="id"
      >
      <template #item="{ element, index }">

<q-card
    square
    flat
    bordered
    class="box-shadow cursor-move bg-white q-mt-xs list-group-item border-done"
    @click="showDetails(element)"
  >
  <q-avatar
      class="q-pa-none feature-done bottom-right-radius"
      size="25px"
      dense
      text-color="white"
    >
      <q-icon
        filled
        size="xs"
         name = "assignment"
      />
    </q-avatar>
    <span class="text-caption text-grey-9 q-ml-xs">
      #{{element.id}}
      <q-icon
        filled
        size="xs"
        name="close"
        class="float-right text-weight-bolder"
        />
      <q-badge class="float-right q-my-md" size="md">
        affected user
      </q-badge>
    </span>

  <q-card-section class="q-pt-sm">
      <div class="row items-center no-wrap">
        <div class="col">
          <div>{{element.titreTache}}</div>
        </div>
        <div class="col">
          <div>start date</div>
        </div>
      </div>
    </q-card-section>            <q-badge
      outline
      class="q-mx-xs text-bold tag-badge"
      color="red"
    >  priority
    </q-badge>
</q-card>

</template>
      </draggable>
    </div>
    </div>
  </div>
  <q-dialog v-model="add_new" position="right">
      <q-card style="width: 600px ; height:1000px">
        <q-card-section>
          <div class="text-h6">Add New Task</div>
        </q-card-section>
        <q-separator/>
        <q-card-section class="row items-center no-wrap">
          <q-form class="q-gutter-md full-width">
            <q-input filled v-model="task_item.task_title" label="First Name" class="q-ml-none"/>

            <q-input filled v-model="task_item.task_type" label="Last Name" class="q-ml-none"/>

            <q-input filled v-model="task_item.task_title" label="First Name" class="q-ml-none"/>

            <q-input filled v-model="task_item.task_title" label="First Name" class="q-ml-none"/>

            <q-input filled v-model="task_item.task_title" label="First Name" class="q-ml-none"/>


            <div class="text-right justify-end">
              <q-btn @click="add_new=false" label="Cancel" type="submit" color="primary"/>
              <q-btn
                @click="addNewTask"
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
<q-dialog v-model="add_new_task">
<q-card style="width: 1000px ; height:700px">
    <q-bar dense style="height: 15px" class="bg-light-blue-13">
    </q-bar>
    <q-card-section>
      {{ selectedtask.id }}
      <center>
        <div class="text-h6">Task Details</div>
        <q-linear-progress size="25px" :value="progress1" color="accent">
      <div class="absolute-full flex flex-center">
        <q-badge color="white" text-color="accent" :label="progressLabel1" />
      </div>
    </q-linear-progress>
      </center>
      <div class="text-h6">Permissions</div>
    </q-card-section>

    <q-card-section class="q-pt-none">
      <div class="text-h6">Permissions</div>
       kuhkluhkug
      <q-select
        label="Roles"
        v-model="newRoles"
        emit-value
        map-options
        outlined
        required
        filled
        dense
        options-dense
        multiple
        counter
        use-chips
        stack-label
        max-values="2"
        hint="Max 2 selections"
        class="q-mb-md">
      </q-select>
      <q-select
        label="Roles"
        v-model="newRoles"
        emit-value
        map-options
        outlined
        required
        filled
        dense
        options-dense
        multiple
        counter
        use-chips
        stack-label
        max-values="2"
        hint="Max 2 selections"
        class="q-mb-md">
      </q-select>


    </q-card-section>
    <q-separator/>
    <q-card-actions align="right">
      <q-btn size="sm"
             id="confirmUpdateRoles"
             label="confirm"
             color="light-blue-13"
             v-close-popup/>
      <q-btn size="sm"
             label="close"
             color="grey"
             v-close-popup/>
    </q-card-actions>
  </q-card>
</q-dialog>
</template>

<script>
import draggable from "vuedraggable";
import { watchEffect } from 'vue';

import TaskService from "../../services/TaskService";


export default {
  name: "two-lists",
  display: "Two Lists",
  order: 1,
  components: {
    draggable
  },
  data() {
    return {
      task_backlog: [
        { task_title: "John", id: 1, task_type:"feature", priority: "test1" , task_status:"backlog"},
        { task_title: "John", id: 2, task_type:"bug", priority: "test1" , task_status:"backlog"},
        { task_title: "John", id: 3, task_type:"bug", priority: "test1" , task_status:"backlog"},
        { task_title: "John", id: 4, task_type:"feature", priority: "test1" , task_status:"backlog"},
      ],
      task_inprogress: [
        { task_title: "John", id: 5, task_type:"design", priority: "test1" , task_status:"inprogress"},
        { task_title: "John", id: 6, task_type:"feature", priority: "test1" , task_status:"inprogress"},
        { task_title: "John", id: 7, task_type:"feature", priority: "test1" , task_status:"inprogress"},
        { task_title: "John", id: 8, task_type:"design", priority: "test1" , task_status:"inprogress"},
      ],
      task_testing: [
        { task_title: "John", id: 9, task_type:"feature", priority: "test1" , task_status:"testing"},
        { task_title: "John", id: 10, task_type:"bug", priority: "test1" , task_status:"testing"},
        { task_title: "John", id: 11, task_type:"feature", priority: "test1" , task_status:"testing"},
        { task_title: "John", id: 12, task_type:"feature", priority: "test1" , task_status:"testing"},
      ],
      task_done: [
        { task_title: "John", id: 13, task_type:"feature", priority: "test1" , task_status:"done"},
        { task_title: "John", id: 14, task_type:"design", priority: "test1" , task_status:"done"},
        { task_title: "John", id: 15, task_type:"feature", priority: "test1" , task_status:"done"},
        { task_title: "John", id: 16, task_type:"design", priority: "test1" , task_status:"done"},
      ],

      taskbacklog :[] ,
      taskinprogress:[],
      tasktest :[] ,
      taskdone:[],
      tasks:[] ,

      element_id : null ,
      element_status : '' ,
      add_new_task :false ,
      selectedtask : null
    };
  },

  async created(){

      const projectId = this.$route.params.id;
      const response = await TaskService.gettaskperProject(projectId) ;
      this.tasks =response.data;
      this.taskbacklog = this.tasks.filter((task)=> task.taskStatus ==='backlog')
      this.taskinprogress = this.tasks.filter((task) => task.taskStatus === 'inprogress');
      this.tasktest= this.tasks.filter((task) => task.taskStatus === 'test');
      this.taskdone = this.tasks.filter((task)=> task.taskStatus ==='done')
      window.console.log(this.taskbacklog) ;
      window.console.log(this.taskinprogress) ;
      window.console.log(this.tasktest) ;
      window.console.log(this.taskdone) ;
      console.log(response.data) ;


  } ,

  computed: {
            dragOptions() {
                return {
                    animation: 200,
                    group: "description",
                    disabled: false,
                    ghostClass: "ghost"
                };
            }
        },

  methods: {

    test1Method() {
      window.console.log("this is test1")
    } ,
    test2Method() {
     window.console.log("this is test2")
    } ,

    onChange(event) {
      if(event.removed) {
        const id = event.removed.element.id ;
        this.element_id = id  ;
        return id ;
      }
    } ,
    dropHandleinprogress () {
    this.element_status = "inprogress" ;
    return this.element_status ;

    }
    ,
    dropHandlebacklog () {
    this.element_status = "backlog" ;
    return this.element_status ;

    }  ,
      showDetails(task) {
      this.selectedtask = task;
      this.add_new_task = true;
      console.log(this.selectedtask.id)
    },

    dropHandledone () {
    this.element_status = "done" ;
    return this.element_status ;

    } ,
    dropHandletest () {
    this.element_status = "test" ;
    return this.element_status ;
    } ,
    updateList() {
    //  window.console.log(`I will move the element with ID ${this.element_id} to ${this.element_status}`);

      TaskService.updatetaskStatus(this.element_id , this.element_status ) ;
      console.log("started") ;
      console.log(this.element_id ) ;
      console.log(this.element_status) ;
      this.element_id = null ;
      this.element_status = '' ;
    }
  } ,
  mounted() {
    watchEffect(() => {
      if (this.element_id && this.element_status ) {
        this.updateList() ;
      }
    });
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
  .border-backlog {
    border-left: 5px solid #00BFFF !important;
  }
  .feature-to-do {
    background-color: #00BFFF;
  }
  .to-do-title {
    background-color: #00BFFF	;
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
    border-left: 5px solid green !important;
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
    background-color: #00BFFF	;
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
</style>
