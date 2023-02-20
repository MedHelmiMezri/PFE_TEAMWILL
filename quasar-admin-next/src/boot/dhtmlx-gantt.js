
//import { boot } from 'quasar/wrappers'





import { boot } from 'quasar/wrappers'
import gantt from 'dhtmlx-gantt'

export default boot(async ({ app }) => {
 app.component('gantt' , gantt   )
})


