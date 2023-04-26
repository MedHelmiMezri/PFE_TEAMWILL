
import { boot } from 'quasar/wrappers'

import VueApexCharts from 'vue3-apexcharts'


export default boot(async ({ app }) => {
 app.component('apexchart' ,VueApexCharts  )
})
