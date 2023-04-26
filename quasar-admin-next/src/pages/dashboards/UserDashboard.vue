<template>
   <h5>
    hello world userboard
   </h5>
  </template>
  
  <script>
  import {defineComponent, defineAsyncComponent} from 'vue'
  
  export default defineComponent({
    name: "Charts",
    components: {
      GtaskChart: defineAsyncComponent(() => import('../../components/targetcharts/GTaskChart')),
      ProjectCard : defineAsyncComponent(() => import('../../components/targetcharts/ProjectCard')) ,
      UserCard : defineAsyncComponent(() => import('../../components/targetcharts/UserCard')) , 
    },
  })
  </script>
  
  <style scoped>
  
  </style>