import { boot } from 'quasar/wrappers'

import draggable from 'vuedraggable'


export default boot(async ({ app }) => {
 app.component('draggable' ,draggable  )
})
