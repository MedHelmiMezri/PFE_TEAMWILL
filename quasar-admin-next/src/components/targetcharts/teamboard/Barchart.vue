<template>
  
    <q-card>
    <q-card-section style="color:black" class="text-h6 ">
      test
    </q-card-section>
    <q-separator inset></q-separator>

    <q-card-section> 
        <apexchart type="bar" height="350" :options="chartOptions" :series="series"></apexchart>
    </q-card-section>
    <q-resize-observer @resize="onResize"/>
    </q-card>
    
</template>

<script>

export default {
  data() {
    return {
        series: [{
            name: 'Servings',
            data: [44, 55, 41, 67, 22, 43, 21, 33, 45, 31, 87, 65, 35]
          }],
          chartOptions: {
            annotations: {
              points: [{
                x: 'Bananas',
                seriesIndex: 0,
                label: {
                  borderColor: '#775DD0',
                  offsetY: 0,
                  style: {
                    color: '#fff',
                    background: '#775DD0',
                  },
                  text: 'Bananas are good',
                }
              }]
            },
            chart: {
              height: 350,
              type: 'bar',
            },
            plotOptions: {
              bar: {
                borderRadius: 10,
                columnWidth: '50%',
              }
            },
            dataLabels: {
              enabled: false
            },
            stroke: {
              width: 2
            },
            
            grid: {
              row: {
                colors: ['#fff', '#f2f2f2']
              }
            },
            xaxis: {
              labels: {
                rotate: -45
              },
              categories: ['Apples', 'Oranges', 'Strawberries', 'Pineapples', 'Mangoes', 'Bananas',
                'Blackberries', 'Pears', 'Watermelons', 'Cherries', 'Pomegranates', 'Tangerines', 'Papayas'
              ],
              tickPlacement: 'on'
            },
            yaxis: {
              title: {
                text: 'Servings',
              },
            },
            fill: {
              type: 'gradient',
              gradient: {
                shade: 'light',
                type: "horizontal",
                shadeIntensity: 0.25,
                gradientToColors: undefined,
                inverseColors: true,
                opacityFrom: 0.85,
                opacityTo: 0.85,
                stops: [50, 0, 100]
              },
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