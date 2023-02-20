{{ src/App.vue }}
<template>
  <q-page class="q-pa-sm bg-white">
  <div class="container">
  <button v-on:click="logOut" class="btn btn-primary btn-block">

          <span>Logout</span>
       </button>
    <GanttComponent class="left-container" ></GanttComponent>
  </div>
  </q-page>
</template>

<script>
import GanttComponent from '../components/GanttComponent.vue';

export default {
  name: 'G',
  components: {GanttComponent} ,
  methods :{
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }

}
</script>

<style>
  html, body {
    height: 100%;
    margin: 0;
    padding: 0;
  }
  .container {
    height: 100vh;
    width: 100%;
  }
  .left-container {
    overflow: hidden;
    position: relative;
    height: 100%;
  }
</style>
