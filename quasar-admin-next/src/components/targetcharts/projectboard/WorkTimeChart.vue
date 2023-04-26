<template>
  
    <q-card>
    <q-card-section style="color:black" class="text-h6 ">
     Project Time Line :
    </q-card-section>
    <q-separator inset></q-separator>

    <q-card-section> 
        <apexchart type="rangeBar" height="350" :options="chartOptions" :series="series"></apexchart>
    </q-card-section>
    <q-resize-observer @resize="onResize"/>
    </q-card>
    
</template>

<script>

export default {
  data() {
    return {
     
        series: [
            {
              data: [
                {
                  x: 'Analysis',
                  y: [
                    new Date('2019-02-27').getTime(),
                    new Date('2019-03-04').getTime()
                  ],
                  fillColor: '#008FFB'
                },
                {
                  x: 'Design',
                  y: [
                    new Date('2019-03-04').getTime(),
                    new Date('2019-03-08').getTime()
                  ],
                  fillColor: '#00E396'
                },
                {
                  x: 'Coding',
                  y: [
                    new Date('2019-03-07').getTime(),
                    new Date('2019-03-10').getTime()
                  ],
                  fillColor: '#775DD0'
                },
                {
                  x: 'Testing',
                  y: [
                    new Date('2019-03-08').getTime(),
                    new Date('2019-03-12').getTime()
                  ],
                  fillColor: '#FEB019'
                },
                {
                  x: 'Deployment',
                  y: [
                    new Date('2019-03-12').getTime(),
                    new Date('2019-03-17').getTime()
                  ],
                  fillColor: '#FF4560'
                }
              ]
            }
          ],
          chartOptions: {
            chart: {
              height: 350,
              type: 'rangeBar'
            },
            plotOptions: {
              bar: {
                horizontal: true,
                distributed: true,
                dataLabels: {
                  hideOverflowingLabels: false
                }
              }
            },
            dataLabels: {
              enabled: true,
             
              style: {
                colors: ['#f3f4f5', '#fff']
              }
            },
            xaxis: {
              type: 'datetime'
            },
            yaxis: {
              show: false
            },
            grid: {
              row: {
                colors: ['#f3f4f5', '#fff'],
                opacity: 1
              }
            }
          },
           
          
    };
  },
 
};
</script>

<style>
.apexcharts {
  max-height: 400px;
}
</style>