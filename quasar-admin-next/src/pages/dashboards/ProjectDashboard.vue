<template>
   <q-page class="bg-blue-grey-1">
    <div class="row q-col-gutter-sm q-ma-xs q-mr-sm">
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
        <q-card>
          <q-card-section :class="$q.dark.isActive?'blue_dark':'bg-blue-8'" class="text-white">
            <div class="row">
              <div class="col-10">
                <div class="text-h6">Tasks</div>
                <div class="text-h5">160</div>
              </div>
              <div class="col-2">
                <q-icon size="62px" name="trending_up"/>
              </div>
            </div>
          </q-card-section>
        </q-card>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
        <q-card>
          <q-card-section :class="$q.dark.isActive?'green_dark':'bg-blue-8'" class="text-white">
            <div class="row">
              <div class="col-10">
                <div class="text-h6">Team</div>
                <div class="text-h5">14</div>
              </div>
              <div class="col-2">
                <q-icon size="62px" name="far fa-dot-circle"/>
              </div>
            </div>
          </q-card-section>
        </q-card>
      </div>
      <div class="row q-col-gutter-sm q-py-sm">
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
        <piechart></piechart>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
        <piechart></piechart>
      </div>
      </div> 
    </div>
    <div class=" q-col-gutter-sm q-ma-xs q-mr-sm">
         <workchart></workchart>
      </div>

   </q-page>
  </template>
  
  <script>
  import {defineComponent, defineAsyncComponent} from 'vue'
  
  export default defineComponent({
    name: "Charts",
    components: {
      piechart: defineAsyncComponent(() => import('../../components/targetcharts/projectboard/PieChart')),
      workchart:defineAsyncComponent(()=>import ('../../components/targetcharts/projectboard/WorkTimeChart'))
    },
  })
  </script>
  
  <style scoped>
  
.table {
    --mdb-table-font-size: 0.9rem;
    --mdb-table-divider-color: rgba(0,0,0,0.1);
    font-size: var(--mdb-table-font-size)
}

.table th {
    font-weight: 500
}

.table tbody {
    font-weight: 400
}

.table>:not(:last-child)>:last-child>* {
    border-bottom-color: inherit
}

.table-primary {
    --mdb-table-color: #000;
    --mdb-table-bg: #d8e3f4;
    --mdb-table-border-color: #c2ccdc;
    --mdb-table-striped-bg: #cdd8e8;
    --mdb-table-striped-color: #000;
    --mdb-table-active-bg: #c2ccdc;
    --mdb-table-active-color: #000;
    --mdb-table-hover-bg: #c8d2e2;
    --mdb-table-hover-color: #000
}

.table-primary,.table-secondary {
    color: var(--mdb-table-color);
    border-color: var(--mdb-table-border-color)
}
  </style>