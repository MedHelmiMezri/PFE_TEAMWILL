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
      <div class="col-3 q-px-xs">

          <q-item style="cursor: move;" class="q-pa-none text-white q-pa-sm to-do-title">
            <q-item-section avatar style="min-width:25px">
              <q-icon name="list" class="q-pa-none q-ma-none"/>
            </q-item-section>
            <q-item-section class="text-h6 text-weight-bolder">To do</q-item-section>
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
            :list="task_to_do"
            group="tasks"
            v-bind="dragOptions"
            @end="seeChange( event , 'todo')"
            @change="logelement(event)"
          >
          <template #item="{ element, index }">
            <q-card
              square
              flat

              bordered
              class="box-shadow cursor-move bg-white q-mt-xs list-group-item border-todo"
              :style="element.task_type=='bug'?'border-left: 5px solid red !important':''"
              @mouseover="task_index.to_do_index = index"
              @mouseleave="task_index.to_do_index = null"
            >
              <q-avatar
                class="q-pa-none"
                size="25px"
                dense
                :class="element.task_type=='bug'? 'bug bottom-right-radius':'feature-to-do bottom-right-radius'"
                text-color="white"
              >
                <q-icon
                  filled
                  size="xs"
                  :name="element.task_type=='bug'? 'bug_report':'assignment'"
                />
              </q-avatar>
              <span class="text-caption text-grey-9 q-ml-xs">
                #{{element.id}}
                <q-icon
                  filled
                  size="xs"
                  name="close"
                  class="float-right text-weight-bolder"
                  :style="{'visibility':index==task_index.to_do_index?'visible':'hidden'}"
                  @click="deleteTask('task_to_do', task_index.to_do_index)"
                />
                <q-avatar class="float-right q-my-md" size="md">
                  <img src="https://cdn.quasar.dev/img/boy-avatar.png"/>
                </q-avatar>
              </span>
              <q-card-section class="q-pt-sm">
                <div class="row items-center no-wrap">
                  <div class="col">
                    <div>{{element.task_title}}</div>
                  </div>
                </div>
              </q-card-section>
              <q-badge
                outline
                class="q-mx-xs text-bold tag-badge"
                v-bind:key="index"
                v-for="(tag, index) in element.tags"
                :color="tag.color"
              >{{tag.name}}
              </q-badge>
              <q-card-actions>
                <q-btn size="xs" dense filled round color="blue" icon="message"/>
                <q-btn size="xs" dense filled round color="orange" icon="flag"/>
                <q-btn size="xs" dense filled round color="grey" icon="attachment"/>
              </q-card-actions>
            </q-card>
          </template>

          </draggable>

      </div>


        <div class="col-3 q-px-xs">
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
            :list="task_in_progress"
            group="tasks"
            v-bind="dragOptions"
            @end="seeChange( event , 'inprogress')"

          >
          <template #item="{ element, index }">
            <q-card
              square
              flat
              bordered
              class="box-shadow cursor-move bg-white q-mt-xs list-group-item border-todo"
              :style="element.task_type=='bug'?'border-left: 5px solid red !important':''"
              @mouseover="task_index.to_do_index = index"
              @mouseleave="task_index.to_do_index = null"
            >
              <q-avatar
                class="q-pa-none"
                size="25px"
                dense
                :class="element.task_type=='bug'? 'bug bottom-right-radius':'feature-to-do bottom-right-radius'"
                text-color="white"
              >
                <q-icon
                  filled
                  size="xs"
                  :name="element.task_type=='bug'? 'bug_report':'assignment'"
                />
              </q-avatar>
              <span class="text-caption text-grey-9 q-ml-xs">
                #{{element.id}}
                <q-icon
                  filled
                  size="xs"
                  name="close"
                  class="float-right text-weight-bolder"
                  :style="{'visibility':index==task_index.to_do_index?'visible':'hidden'}"
                  @click="deleteTask('task_to_do', task_index.to_do_index)"
                />
                <q-avatar class="float-right q-my-md" size="md">
                  <img src="https://cdn.quasar.dev/img/boy-avatar.png"/>
                </q-avatar>
              </span>
              <q-card-section class="q-pt-sm">
                <div class="row items-center no-wrap">
                  <div class="col">
                    <div>{{element.task_title}}</div>
                  </div>
                </div>
              </q-card-section>
              <q-badge
                outline
                class="q-mx-xs text-bold tag-badge"
                v-bind:key="index"
                v-for="(tag, index) in element.tags"
                :color="tag.color"
              >{{tag.name}}
              </q-badge>
              <q-card-actions>
                <q-btn size="xs" dense filled round color="blue" icon="message"/>
                <q-btn size="xs" dense filled round color="orange" icon="flag"/>
                <q-btn size="xs" dense filled round color="grey" icon="attachment"/>
              </q-card-actions>
            </q-card>
          </template>
          </draggable>
        </div>


      <div class="col-3 q-px-xs">

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
            :list="task_test"
            group="tasks"
            v-bind="dragOptions"
            @end="seeChange( event , 'test')"

          >
          <template #item="{ element, index }">
            <q-card
              square
              flat
              bordered
              class="box-shadow cursor-move bg-white q-mt-xs list-group-item border-todo"
              :style="element.task_type=='bug'?'border-left: 5px solid red !important':''"
              @mouseover="task_index.to_do_index = index"
              @mouseleave="task_index.to_do_index = null"
            >
              <q-avatar
                class="q-pa-none"
                size="25px"
                dense
                :class="element.task_type=='bug'? 'bug bottom-right-radius':'feature-to-do bottom-right-radius'"
                text-color="white"
              >
                <q-icon
                  filled
                  size="xs"
                  :name="element.task_type=='bug'? 'bug_report':'assignment'"
                />
              </q-avatar>
              <span class="text-caption text-grey-9 q-ml-xs">
                #{{element.id}}
                <q-icon
                  filled
                  size="xs"
                  name="close"
                  class="float-right text-weight-bolder"
                  :style="{'visibility':index==task_index.to_do_index?'visible':'hidden'}"
                  @click="deleteTask('task_to_do', task_index.to_do_index)"
                />
                <q-avatar class="float-right q-my-md" size="md">
                  <img src="https://cdn.quasar.dev/img/boy-avatar.png"/>
                </q-avatar>
              </span>
              <q-card-section class="q-pt-sm">
                <div class="row items-center no-wrap">
                  <div class="col">
                    <div>{{element.task_title}}</div>
                  </div>
                </div>
              </q-card-section>
              <q-badge
                outline
                class="q-mx-xs text-bold tag-badge"
                v-bind:key="index"
                v-for="(tag, index) in element.tags"
                :color="tag.color"
              >{{tag.name}}
              </q-badge>
              <q-card-actions>
                <q-btn size="xs" dense filled round color="blue" icon="message"/>
                <q-btn size="xs" dense filled round color="orange" icon="flag"/>
                <q-btn size="xs" dense filled round color="grey" icon="attachment"/>
              </q-card-actions>
            </q-card>
          </template>
          </draggable>

      </div>

      <div class="col-3 q-px-xs">

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
            :list="task_done"
            group="tasks"
            v-bind="dragOptions"
            @end="seeChange(event ,  'done')"

          >
          <template #item="{ element, index }">
            <q-card
              square
              flat
              bordered
              class="box-shadow cursor-move bg-white q-mt-xs list-group-item border-todo"
              :style="element.task_type=='bug'?'border-left: 5px solid red !important':''"
              @mouseover="task_index.to_do_index = index"
              @mouseleave="task_index.to_do_index = null"
            >
              <q-avatar
                class="q-pa-none"
                size="25px"
                dense
                :class="element.task_type=='bug'? 'bug bottom-right-radius':'feature-to-do bottom-right-radius'"
                text-color="white"
              >
                <q-icon
                  filled
                  size="xs"
                  :name="element.task_type=='bug'? 'bug_report':'assignment'"
                />
              </q-avatar>
              <span class="text-caption text-grey-9 q-ml-xs">
                #{{element.id}}
                <q-icon
                  filled
                  size="xs"
                  name="close"
                  class="float-right text-weight-bolder"
                  :style="{'visibility':index==task_index.to_do_index?'visible':'hidden'}"
                  @click="deleteTask('task_to_do', task_index.to_do_index)"
                />
                <q-avatar class="float-right q-my-md" size="md">
                  <img src="https://cdn.quasar.dev/img/boy-avatar.png"/>
                </q-avatar>
              </span>
              <q-card-section class="q-pt-sm">
                <div class="row items-center no-wrap">
                  <div class="col">
                    <div>{{element.task_title}}</div>
                  </div>
                </div>
              </q-card-section>
              <q-badge
                outline
                class="q-mx-xs text-bold tag-badge"
                v-bind:key="index"
                v-for="(tag, index) in element.tags"
                :color="tag.color"
              >{{tag.name}}
              </q-badge>
              <q-card-actions>
                <q-btn size="xs" dense filled round color="blue" icon="message"/>
                <q-btn size="xs" dense filled round color="orange" icon="flag"/>
                <q-btn size="xs" dense filled round color="grey" icon="attachment"/>
              </q-card-actions>
            </q-card>
          </template>
          </draggable>

      </div>
</div>
    <q-dialog v-model="add_new" position="left">
      <q-card style="width: 300px">
        <q-card-section>
          <div class="text-h6">Add New Task</div>
        </q-card-section>
        <q-separator/>
        <q-card-section class="row items-center no-wrap">
          <q-form class="q-gutter-md full-width">
            <q-input filled v-model="task_item.task_title" label="First Name" class="q-ml-none"/>

            <q-input filled v-model="task_item.task_type" label="Last Name" class="q-ml-none"/>

            <div class="text-right">
              <q-btn @click="add_new=false" label="Cancel" type="submit" color="primary"/>
              <q-btn
                @click="addNewTask"
                style="width: 90px"
                class="q-ml-sm"
                label="Add"
                type="submit"
                color="green"
              />
            </div>
          </q-form>
        </q-card-section>
      </q-card>
    </q-dialog>
  </q-page>
</template>

<script>

    import draggable from "vuedraggable";
    import {Notify} from "quasar";
    export default {
        name: "RealKanban",
        components: {
    draggable
  },
        data() {
            return {
                search: "",
                task_index: {
                    to_do_index: null,
                    in_progress_index: null,
                    test_index: null,
                    done_index: null
                },
                task_item: {
                    task_title: "Task Name",
                    task_type: "feature",
                    id: null
                },
                add_new: false,
                drag: false,
                task_to_do: [
                    {
                        task_title: "Develop the add new call feature",
                        task_type: "feature",
                        id: 1,
                        tags: [
                            {name: "css", color: "yellow"},
                            {name: "html", color: "pink"}
                        ]
                    },
                    {
                        task_title: "Improvements",
                        task_type: "enhancement",
                        id: 2,
                        tags: [
                            {name: "js", color: "orange"},
                            {name: "html", color: "pink"},
                            {name: "api", color: "teal"}
                        ]
                    },
                    {
                        task_title: "Fix the issue in send email",
                        task_type: "bug",
                        id: 3,
                        tags: [{name: "api", color: "teal"}]
                    },
                    {
                        task_title: "Remove static handling",
                        task_type: "feature",
                        id: 4,
                        tags: [
                            {name: "js", color: "orange"},
                            {name: "api", color: "teal"}
                        ]
                    }
                ],
                task_in_progress: [
                    {
                        task_title: "Fix upgrade issues",
                        task_type: "bug",
                        id: 5,
                        tags: [
                            {name: "api", color: "teal"},
                            {name: "html", color: "pink"}
                        ]
                    },
                    {
                        task_title: "Convert list to grid",
                        task_type: "feature",
                        id: 6,
                        tags: [
                            {name: "html", color: "pink"},
                            {name: "api", color: "teal"},
                            {name: "css", color: "yellow"}
                        ]
                    },
                    {
                        task_title: "Update back-end API",
                        task_type: "feature",
                        id: 7,
                        tags: [
                            {name: "css", color: "yellow"},
                            {name: "api", color: "teal"}
                        ]
                    }
                ],
                task_test: [
                    {
                        task_title: "Test project upgrade version",
                        task_type: "feature",
                        id: 5,
                        tags: [{name: "api", color: "teal"}]
                    },
                    {
                        task_title: "The edit blog functionalities",
                        task_type: "feature",
                        id: 6,
                        tags: [
                            {name: "html", color: "pink"},
                            {name: "api", color: "teal"},
                            {name: "js", color: "orange"}
                        ]
                    },
                    {
                        task_title: "Back-end API enhancements",
                        task_type: "feature",
                        id: 7,
                        tags: [
                            {name: "api", color: "teal"},
                            {name: "html", color: "pink"}
                        ]
                    }
                ],
                task_done: [
                    {
                        task_title: "Handle new user API",
                        task_type: "feature",
                        id: 5,
                        tags: [
                            {name: "api", color: "teal"},
                            {name: "html", color: "pink"},
                            {name: "css", color: "yellow"}
                        ]
                    },
                    {
                        task_title: "Handle issues in front-end linking",
                        task_type: "bug",
                        id: 6,
                        tags: [
                            {name: "js", color: "orange"},
                            {name: "html", color: "pink"}
                        ]
                    },
                    {
                        task_title: "Manage back-end API calls",
                        task_type: "feature",
                        id: 7,
                        tags: [
                            {name: "api", color: "teal"},
                            {name: "css", color: "yellow"}
                        ]
                    }
                ]
            };
        },
        computed: {
            dragOptions() {
                return {
                    animation: 200,

                    disabled: false,
                    ghostClass: "ghost"
                };
            }
        },
        methods: {
            addNewTask() {
                let max_id = Math.max.apply(
                    Math,
                    this.task_to_do.map(function (o) {
                        return o.id;
                    })
                );
                this.task_item.id = max_id + 1;
                this.task_to_do.push(this.task_item);
                this.add_new = false;

            },
            deleteTask(task_lane, index) {
                this[task_lane].splice(index, 1);
            } ,
            seeChange: function(  evt  ,listName ) {
      //const updatedList = this[listName].map(item => item.name);
      //window.console.log(listName) ;
   // const destinationList  = this[listName] ;
    window.console.log(`item moved to ${listName}`) ;
    window.console.log(evt);



    } ,
    logelement(evt) {
      window.console.log(evt) ;
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
</style>
