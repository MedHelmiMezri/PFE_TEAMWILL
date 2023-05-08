<template>
  <q-card class="my-card" >
    <q-card-section>
      <q-card-section class="text-h6 q-pb-none">
        <q-item  style="display: flex; justify-content: center; align-items: center;">
          <q-item-section avatar class="">
            <q-icon color="blue" name="fas fa-chart-line" size="44px"/>
          </q-item-section>

          <q-item-section>
            <div class="text-h6" >Set up a project :</div>
          </q-item-section>
        </q-item>
      </q-card-section>
    </q-card-section>
    <q-card-section>
      <q-separator style="margin-bottom: 16px;"></q-separator>

      <q-container class="q-pa-md" >
        <div class="row justify-evenly">
          <div class="col-md-8">
          <q-form class="q-gutter-md" style="max-width: 1000px;">

            <q-input style="max-width: 1000px;" class="full-width" dense filled v-model="project.projectTitle" label="Project Name" hint="Name and surname" lazy-rules :rules="[val => val && val.length > 0 || 'Please type something']" />
            <q-input style="max-width: 1000px;" class="full-width" dense filled v-model="project.budget" type="number" label="Budget" lazy-rules :rules="[val => val !== null && val !== '' || 'Please type your principal', val => val > 0 || 'Please type a real principal']" />
            <q-input style="max-width: 1000px;" class="full-width" dense v-model="project.startDate" filled type="date"  />
            <q-input style="max-width: 1000px;" class="full-width" v-model="project.description" filled label="Desciption" hint="Name and surname" lazy-rules :rules="[val => val && val.length > 0 || 'Please type something']" />
            <q-input style="max-width: 1000px;" class="full-width" dense v-model="project.duration" filled type="number" label="Duration" lazy-rules :rules="[val => val !== null && val !== '' || 'Please type your principal', val => val > 0 || 'Please type a real principal']" />
            <div class="q-mt-md">
              <q-btn label="Submit" @click="saveProject" type="submit" color="blue" />
              <q-btn label="Reset" type="submit" color="green" flat class="q-ml-sm"  />
            </div>
          </q-form>
          </div>
        </div>
      </q-container>
      <q-separator style="margin-bottom: 16px;"></q-separator>
    </q-card-section>
  </q-card>

</template>

<script>
import ProjectService from "../../services/ProjectService";
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import { useQuasar } from 'quasar'


export default {
  name: "add-project",
  setup() {
    const $q = useQuasar()
    return{
      triggerPositive () {
        $q.notify({
          type: 'positive',
          message: 'This is a "positive" type notification.'
        })
      }

    }

  } ,
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

         ProjectService.create(data) ;
         console.log("hello")

        .then(response => {
          this.project.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
          this.$router.push({ path: '/projectlist'});

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

</style>
