<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="projectTitle">Project Title</label>
        <input
          type="text"
          class="form-control"
          id="projectTtile"
          required
          v-model="project.projectTitle"
          name="projectTtile"
        />
      </div>
      <div class="form-group">
        <label for="Budget">Budget</label>
        <input
          type="text"
          class="form-control"
          id="budget"
          required
          v-model="project.budget"
          name="budget"
        />
      </div>
      <div class="form-group">
        <label for="startDate">startDate</label>
        <input
          type="date"
          class="form-control"
          id="startDate"
          required
          v-model="project.startDate"
          name="startDate"
        />
      </div>
      
      <div class="form-group">
        <label for="description">Description</label>
        <input
          class="form-control"
          id="description"
          required
          v-model="project.description"
          name="description"
        />
      </div>
     
      <div class="form-group">
        <label for="duration">Duration</label>
        <input
          class="form-control"
          id="duration"
          required
          v-model="project.duration"
          name="duratio"
        />
      </div>

      <button @click="saveProject" class="btn btn-success">Submit</button>
    </div>

    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newTutorial">Add</button>
    </div>
    <ul>
      <li v-for="notification in notifications" :key="notification.id">
        {{ notification.projectTitle }}
      </li>
    </ul>
  </div>
</template>

<script>
import ProjectService from "../../services/ProjectService";
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';

export default {
  name: "add-project",
  data() {
    return {
      project: {
        
        projectTitle: "",
        budget :0 , 
        startDate : "",
        description: "",
        duration : 0 
        
      },
      submitted: false ,
      notifications: []
    };
  }, 
  mounted() {
      this.connect() ;
  } ,
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
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newTutorial() {
      this.submitted = false;
      this.project = {};
    }, 
    connect() {
      const socket = new SockJS('http://localhost:8083/websocket');
      const stompClient = Stomp.over(socket);

      stompClient.connect({}, () => {
        stompClient.subscribe('/topic/notifications', (message) => {
          const notification = JSON.parse(message.body);
          console.log(notification) ;
          this.notifications.push(notification);
        });
      });
    },
  }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>