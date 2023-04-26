<template>
  
        <q-card>
        <q-card-section style="color:black" class="text-h6 bg-blue-grey-2">
          Overall Tasks
        </q-card-section>
        <q-separator inset></q-separator>

        <q-card-section>
          <apexchart type="donut" :options="chartOptions" :series="series"></apexchart>
        </q-card-section>
        <q-resize-observer @resize="onResize"/>
        </q-card>
        
    </template>
    
    <script>
    import axios from 'axios';
    import authHeader from '../../services/auth-header';
    export default {
      data() {
        return {
         
          
          series: [],
            chartOptions: {
              chart: {
                type: 'donut',
              },
              responsive: [{
                breakpoint: 480,
                options: {
                  chart: {
                    width: 50
                  },
                  legend: {
                    position: 'bottom'
                  }
                }
              }]
            }, 
            
        };
      },
      mounted() {
      axios.get("http://localhost:8083/target/task-counts", { headers: authHeader() })
        .then(response => {
          this.series.push(response.data.Pending);
          this.series.push(response.data.Resolved);
          this.series.push(response.data.Closed);
        });
    },
     
    };
    </script>
    
    <style>
    .apexcharts {
      max-height: 400px;
    }
    </style>
    