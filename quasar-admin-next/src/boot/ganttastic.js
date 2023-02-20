import { boot } from 'quasar/wrappers'
import  ganttastic from '@infectoone/vue-ganttastic'


export default boot(async ({ app }) => {
 app.component('ganttastic' , ganttastic   )
})
