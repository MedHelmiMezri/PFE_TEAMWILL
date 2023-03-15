<template>
  <div ref="gantt_here"></div>
</template>

<script>
import {gantt} from 'dhtmlx-gantt';
export default {


  mounted: function () {
    
  gantt.config.date_format = "%Y-%m-%d %H:%i:%s";

  gantt.init(this.$refs.gantt_here);
  
  gantt.load("http://localhost:1337/data");
  const dp = new gantt.dataProcessor("http://localhost:1337/data");
  console.log(gantt) ; 
  dp.init(gantt);
  dp.setTransactionMode("REST");
  }
}
</script>
<style>
    @import "~dhtmlx-gantt/codebase/dhtmlxgantt.css";
</style>


