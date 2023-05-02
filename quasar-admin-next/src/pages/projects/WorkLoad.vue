<template>
      <div id="chart" >
        <apexchart type="bar" height="350"  :options="chartOptions" :series="series"></apexchart>
      </div>
</template>


<script>
export default {
  data () {
    return {
      series: [
            {
              name: 'Actual',
              data: [
                {
                  x: 'john doe',
                  y: 12,
                  goals: [
                    {
                      name: 'Expected',
                      value: 80,
                      strokeWidth: 5,
                      strokeHeight: 10,
                      strokeColor: 'red'
                    }
                  ]
                },
                {
                  x: 'john doe',
                  y: 44,
                  goals: [
                    {
                      name: 'Expected',
                      value: 80,
                      strokeWidth: 5,
                      strokeHeight: 10,
                      strokeColor: 'red'
                    }
                  ]
                },
                {
                  x: 'john doe',
                  y: 54,
                  goals: [
                    {
                      name: 'Expected',
                      value: 80,
                      strokeWidth: 5,
                      strokeHeight: 10,
                      strokeColor: 'red'
                    }
                  ]
                },
                {
                  x: 'john doe',
                  y: 66,
                  goals: [
                    {
                      name: 'Expected',
                      value: 80,
                      strokeWidth: 5,
                      strokeHeight: 10,
                      strokeColor: 'red'
                    }
                  ]
                },
                {
                  x: 'john doe',
                  y: 81,
                  goals: [
                    {
                      name: 'Expected',
                      value: 80,
                      strokeWidth: 5,
                      strokeHeight: 10,
                      strokeColor: 'red'
                    }
                  ]
                },
                {
                  x: 'john doe',
                  y: 67,
                  goals: [
                    {
                      name: 'Expected',
                      value: 80,
                      strokeWidth: 5,
                      strokeHeight: 10,
                      strokeColor: 'red'

                    }
                  ]
                }
              ]
            }
          ],
          chartOptions: {
            chart: {
              height: 350,
              type: 'bar'
            },
            plotOptions: {
              bar: {
                horizontal: true,
              }
            },
            colors: ['#00E396'],
            dataLabels: {
              formatter: function(val, opt) {
                const goals =
                  opt.w.config.series[opt.seriesIndex].data[opt.dataPointIndex]
                    .goals

                if (goals && goals.length) {
                  return `${val} / ${goals[0].value}`
                }
                return val
              }
            },
            legend: {
              show: true,
              showForSingleSeries: true,
              customLegendItems: ['Actual', 'Expected'],
              markers: {
                fillColors: ['#00E396', '#775DD0']
              }
            }
          },


    }
  }

}
</script>
