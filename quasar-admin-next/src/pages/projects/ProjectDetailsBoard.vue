<template>
  <q-page class="q-pa-sm">
    <div>
      <q-card class="bg-transparent no-shadow no-border">
        <q-card-section class="q-pa-none">
          <div class="row q-col-gutter-sm ">
            <div class="col-md-3 col-sm-12 col-xs-12">
              <q-item style="background-color: #4fbb91" class="q-pa-none q-ml-xs">
                <q-item-section side style="background-color: #419e7a" class="q-pa-lg q-mr-none text-white">
                  <q-icon name="list" color="white" size="44px"></q-icon>
                </q-item-section>
                <q-item-section class="q-pa-md q-ml-none  text-white">
                  <q-item-label class="text-white text-h3 text-weight-bolder">40</q-item-label>
                  <q-item-label>Tasks Added Today</q-item-label>
                </q-item-section>
              </q-item>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
              <q-item style="background-color: #ee9835" class="q-pa-none q-ml-xs ">
                <q-item-section side style="background-color: #d3862d" class="q-pa-lg q-mr-none text-white">
                  <q-icon name="sync" size="44px"></q-icon>
                </q-item-section>
                <q-item-section class="q-pa-md q-ml-none  text-white">
                  <q-item-label class="text-white text-h3 text-weight-bolder">50</q-item-label>
                  <q-item-label>Tasks In Progress Today</q-item-label>
                </q-item-section>
              </q-item>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
              <q-item style="background-color: #8f64e3" class="q-pa-none q-ml-xs">
                <q-item-section side style="background-color: #6d46bb" class="q-pa-lg q-mr-none text-white">
                  <q-icon name="compare_arrows" size="44px"></q-icon>
                </q-item-section>
                <q-item-section class="q-pa-md q-ml-none  text-white">
                  <q-item-label class="text-white text-h3 text-weight-bolder">30</q-item-label>
                  <q-item-label>Tasks In Testing Today</q-item-label>
                </q-item-section>
              </q-item>
            </div>
            <div class="col-md-3 col-sm-12 col-xs-12">
              <q-item style="background-color: #3d8117" class="q-pa-none q-ml-xs q-mr-xs">
                <q-item-section side style="background-color: #376a1a" class="q-pa-lg q-mr-none text-white">
                  <q-icon name="las la-check-circle" size="44px"></q-icon>
                </q-item-section>
                <q-item-section class="q-pa-md q-ml-none  text-white">
                  <q-item-label class="text-white text-h3 text-weight-bolder">80</q-item-label>
                  <q-item-label>Tasks Completed Today</q-item-label>
                </q-item-section>
              </q-item>
            </div>
          </div>
        </q-card-section>
        <q-card-section class="q-pa-none q-mt-sm">
          <div class="row text-center q-ma-xs bg-white q-pa-sm">
            <div class="col-md-3 col-sm-12 col-xs-12">
              <div class="column" style="height: 150px">
      <div class="col">
        <div>
          Project Title :
        </div>
        <div class="text-h6">
          test test
        </div>
      </div>
      <div class="col">
         <div>
          Project budget :
         </div>
         <div class="text-h6">
          test test
         </div>
      </div>
    </div>
            </div>



            <div class="col-md-3 col-sm-12 col-xs-12">
              <div class="column" style="height: 150px">
      <div class="col">
        <div>
          Project description :
        </div>
        <div class="text-h6">
          test test
        </div>
      </div>
      <div class="col">
        <div>
         Project duration :
        </div>
        <div class="text-h6">
         test test
        </div>
      </div>
    </div>
            </div>

            <q-separator vertical />

            <div class="col-md-3 col-sm-12 col-xs-12">
              <h5 class="q-pa-none q-ma-none text-grey-9">Progress</h5>
              <q-circular-progress
                show-value
                font-size="12px"
                value="75"
                size="90px"
                :thickness="0.22"
                style="color:#16B6E0"
                track-color="grey-3"
                class="q-ma-none"
              >
                75%
              </q-circular-progress>
              <br>
            </div>

            <div class="col-md-3 col-sm-12 col-xs-12" style="background-color: #16B6E0;border-radius: 7px; width:300px">
              <h5 class="q-pa-none q-ma-none text-grey-9">Project</h5>
              <h5 class="q-pa-none q-ma-none text-grey-9">Launch Date</h5>
              <q-icon size="56px" color="white" name="fas fa-flag-checkered" class="q-pa-none q-ma-none"/>
              <span class="text-h6 text-grey-9" style="vertical-align: bottom;">80 Days</span>
              <br>
              <span class="text-grey-9" style="font-size: 16px">Friday, May 29</span>
            </div>
          </div>
        </q-card-section>
      </q-card>
    </div>
    <div class="row q-pa-xs q-col-gutter-sm">
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" style="max-height: 500px">
        <q-card flat bordered >
          <q-card-section class="row">
            <div class="text-h6 col-12">Project Budget
            </div>
          </q-card-section>

          <q-separator inset></q-separator>

          <q-card-section style="height: 400px !important;">

             <work-load></work-load>

          </q-card-section>
        </q-card>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
        <q-card flat bordered style="height:470px">
          <q-card-section >
            <div class="text-h6 col-12 " >Team
              <q-btn  label="Add Members" class="float-right  col-12 text-capitalize text-blue shadow-3" @click="showDialog()"  icon="settings"></q-btn>
            </div>



          </q-card-section>

          <q-separator inset></q-separator>

          <q-card-section style="height: 282px !important;">
            <q-list dense bordered class="rounded-borders cursor-move"
                style="border-left: 5px solid grey !important"  >
            <q-item class="bg-white">
              <q-item-section avatar>
                <q-icon name="task" color="black" size="34px"/>
              </q-item-section>

              <q-item-section style="font-size: 18px;" class="text-grey-9">
                Project Name
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
            </q-item>
          </q-list>
          </q-card-section>
        </q-card>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" style="max-height: 500px">
        <q-card flat bordered class="" style="height:500px">
          <q-card-section class="row">
            <div class="text-h6 col-12">Task Distribution :
            </div>
          </q-card-section>
          <q-separator inset></q-separator>
          <q-card-section style="height: 282px !important;">
            <task-distribution></task-distribution>
          </q-card-section>
        </q-card>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
        <q-card flat bordered style="height:500px">
          <q-card-section class="row" >
            <div class="text-h6 col-12">Deadlines
            </div>
          </q-card-section>

          <q-separator inset></q-separator>

          <q-card-section style="height: 282px !important;">
            <q-table
              :data="overdue_data"
              :columns="overdue_columns"
              row-key="name"
              :filter="filter"
              :pagination.sync="pagination"
            >
              <template v-slot:body-cell-overdue="props">
                <q-td :props="props">
                  <div class="my-table-details">
                    <span v-if="props.value>5" class="text-weight-bolder" style="color: red">{{ props.value }} Days</span>
                    <span v-else class="text-weight-bolder" style="color: yellow">{{ props.value }} Days</span>
                  </div>
                </q-td>
              </template>
            </q-table>
          </q-card-section>
        </q-card>
      </div>
    </div>

    <q-dialog v-model="affect_users" >
<q-card style="width: 500px ; height:250px">
    <q-bar dense style="height: 15px" class="bg-light-blue-13">

    </q-bar>


    <q-card-section class="q-pt-none">
      <br/>

      <div class="text-h6">Affect Task Owner :</div>
    <br/>
    <br/>
    <q-select
          filled
          v-model="modelMultiple"
          multiple
          :options="options"
          use-chips
          stack-label
          label="Multiple selection"
        />
    </q-card-section>
    <q-separator/>
    <q-card-actions align="right">
      <q-btn size="sm"
             id="confirmUpdateRoles"
             label="confirm"
             color="light-blue-13"
             v-close-popup
             />
      <q-btn size="sm"
             label="close"
             color="grey"
             v-close-popup/>
    </q-card-actions>
  </q-card>
</q-dialog>
  </q-page>
</template>

<script>
    import Vue from "vue";
    import draggable from "vuedraggable";
    import {Notify} from "quasar";
    import TaskDistribution from "./TaskDistribution.vue" ;
    import WorkLoad from "./WorkLoad.vue" ;


    export default {
        name: "Home",
        components :{
         TaskDistribution ,
         WorkLoad
        } ,
        data() {
            return {
                progress: 0.75,
                filter: '',
                affect_users : false ,
                modelMultiple :[],
            options: [
                  'Google', 'Facebook', 'Twitter', 'Apple', 'Oracle'
             ] ,

          series: [44, 55, 41, 17, 15],
          chartOptions: {
            chart: {
              type: 'donut',
            },
            responsive: [{
              breakpoint: 480,
              options: {
                chart: {
                  width: 200
                },
                legend: {
                  position: 'bottom'
                }
              }
            }]
          },

                columns: [
                    {
                        name: 'name',
                        required: true,
                        label: 'Employee',
                        align: 'left',
                        field: row => row.name,
                        sortable: true,
                        style: 'font-size: 17px',
                        headerStyle: 'font-size: 17px'
                    },
                    {name: 'task', align: 'left', label: 'Task', field: 'task', sortable: true, style: 'font-size: 17px',
                        headerStyle: 'font-size: 17px'},
                    {
                        name: 'deadline_date',
                        align: 'left',
                        label: 'Deadline',
                        field: 'deadline_date',
                        sortable: true,
                        style: 'font-size: 17px',
                        headerStyle: 'font-size: 17px'
                    },
                    {
                        name: 'progress',
                        align: 'left',
                        label: 'Workload',
                        field: 'progress',
                        sortable: true,
                        style: 'font-size: 17px',
                        headerStyle: 'font-size: 17px'
                    }
                ],
                data: [
                    {
                        emp_id: "C001",
                        name: 'John',
                        task: 'Develop the static routing',
                        progress: 0.3,
                        deadline_date: '12-09-2019'
                    },
                    {
                        activity_id: "C002",
                        name: 'Jacob',
                        task: 'Fix the sharing issue',
                        progress: 0.65,
                        deadline_date: '09-02-2019'
                    },
                    {
                        activity_id: "C003",
                        name: 'Nancy',
                        task: 'Back-end API enhancement',
                        progress: 0.15,
                        deadline_date: '03-25-2019'
                    },
                ],
                overdue_columns: [
                    {
                        name: 'overdue',
                        align: 'left',
                        label: 'Overdue',
                        field: 'overdue',
                        sortable: true,
                        style: 'font-size: 17px',
                        headerStyle: 'font-size: 17px'
                    },
                    {
                        name: 'name',
                        required: true,
                        label: 'Employee',
                        align: 'left',
                        field: row => row.name,
                        sortable: true,
                        style: 'font-size: 17px',
                        headerStyle: 'font-size: 17px'
                    },
                    {name: 'task', align: 'left', label: 'Task', field: 'task', sortable: true,style: 'font-size: 17px',
                        headerStyle: 'font-size: 17px'},
                    {
                        name: 'deadline_date',
                        align: 'left',
                        label: 'Deadline',
                        field: 'deadline_date',
                        sortable: true,
                        style: 'font-size: 17px',
                        headerStyle: 'font-size: 17px'
                    }
                ],
                overdue_data: [
                    {
                        emp_id: "C001",
                        name: 'John',
                        task: 'Develop the static routing',
                        overdue: 2,
                        deadline_date: '12-09-2019'
                    },
                    {
                        activity_id: "C002",
                        name: 'Jacob',
                        task: 'Fix the sharing issue',
                        overdue: 9,
                        deadline_date: '09-02-2019'
                    },
                    {
                        activity_id: "C003",
                        name: 'Nancy',
                        task: 'Back-end API enhancement',
                        overdue: 15,
                        deadline_date: '03-25-2019'
                    },
                ],
                pagination: {
                    rowsPerPage: 10
                }

            }
        } ,
        methods :{
          showDialog() {
          this.affect_users = true ;
        }
        }

    }
</script>

<style scoped>
  font-size{
    font-size: 18px;
  }
</style>
