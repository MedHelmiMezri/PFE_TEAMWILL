<template>
  <div class="q-pa-md row column items-end">
    <q-btn id="expand-btn"
           label="New Topic"


           style="width: 200px"
           outline
           icon="playlist_add"
           text-color="black"
           to="/addtask"
    />

  </div>
  <div class="q-pa-md">
    <q-table
      title="Tasks :"
      :rows="data"
      :columns="columns"
      row-key="id"
      dense
    >
    <template v-slot:body-cell-actions="props">
          <q-td :props="props">
            <div class="q-gutter-sm">
              <q-btn push  dense class="text-capitalize text-blue shadow-3" icon="lock" @click="showDetailsTask(props.row)"/>
              <q-btn to = "/taskdetails" push  dense class="text-capitalize text-green shadow-3" icon="person" />
              <q-btn push dense  class="text-capitalize text-red shadow-3" icon="lock"/>
            </div>
          </q-td>
        </template>
  </q-table>

  </div>
  <div>

  </div>
</template>

<script>
import TaskService from '../../services/TaskService.js';
import axios from 'axios' ;
import authHeader from '../../services/auth-header';



export default {
data () {
  return {
    data : [] ,
    columns : [
      {name :"id",field:"id",label:"id"} ,
      {name :"titreTache",field:"titreTache",label:"titreTache"} ,
      {name :"typeTask",field:"typeTask",label:"typeTask"} ,
      {name :"description",field:"description",label:"description"} ,
      {name :"startDate",field:"startDate",label:"startDate"} ,
      {name :"taskduration",field:"taskduration",label:"taskduration"} ,
      {name :"priorityTask",field:"priorityTask",label:"priorityTask"} ,
      {name :"taskStatus",field:"TaskStatus",label:"taskStatus"} ,
      {name:"actions" ,field:"actions" ,label:"actions"}


    ]
  }
},
created() {
    axios.get("http://localhost:8083/target/show-tasks" , { headers: authHeader() })
      .then(response => {
        this.data = response.data ;
        console.log(response.data)
      })
      .catch(error => {
        console.log(error)
      })
  } ,
//mounted() {
   // this.fetchTasks() ;
////},
methods : {


  showDetailsTask(row) {
      this.selectedRow = row.id;
      this.employee_dialog = true;
    return  console.log(this.selectedRow)
    },
}

}

</script>
