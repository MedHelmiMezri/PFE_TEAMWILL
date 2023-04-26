<template>
    <q-page>
      <div class="q-pa-md">
    <q-table
      dense
      flat-bordered

      title="Users"
      :rows="rows"
      :columns="columns"
      row-key="name"

      no-data-label="We had a problem loading your data !"
      :visible-columns="visibleColumns"

    >
      <template v-slot:header="props">
        <q-tr :props="props">
          <q-th
            v-for="col in props.cols"
            :key="col.name"
            :props="props"
            class="text-italic text-white bg-grey"
          >
            {{ col.label }}
          </q-th>
        </q-tr>
      </template>
      <template v-slot:body-cell-action="props">
            <q-td :props="props">
              <div class="q-gutter-sm">
                <q-btn push  dense class="text-capitalize text-blue shadow-3" icon="edit" @click="employee_dialog=true"/>
                <q-btn to = "/taskdetails" push  dense class="text-capitalize text-green shadow-3" icon="source" />
                <q-btn push dense  class="text-capitalize text-red shadow-3" icon="delete"/>
              </div>
            </q-td>
          </template>

      <template v-slot:top>
        <img
          style="height: 50px; width: 50px"
          src="https://cdn.quasar.dev/logo-v2/svg/logo.svg"
        >

        <q-space />

        <q-select
          v-model="visibleColumns"
          multiple
          outlined
          dense
          options-dense
          :display-value="$q.lang.table.columns"
          emit-value
          map-options
          :options="columns"
          option-value="name"
          options-cover
          style="min-width: 150px"
        />
      </template>

    </q-table>
  </div>
  <q-dialog v-model="employee_dialog">
      <q-card  class="my-card" flat bordered style="width:1000px ; height:500px">
        <q-card-section class="bg-blue">
          <div class="text-h6 text-white ">
            Employee Details
            <q-btn round flat dense icon="close" class="float-right" color="grey-8" v-close-popup></q-btn>
          </div>
        </q-card-section>

      <q-card-section>
        <div class="q-pa-md q-gutter-sm">

        <q-form>
          <div class="row">
            <div class="col-6">          <q-input v-model="input1" label="Input 1"></q-input>
</div>
            <div class="col-6">          <q-input v-model="input1" label="Input 1"></q-input>
</div>
            <div class="col-6">          <q-input v-model="input1" label="Input 1"></q-input>
</div>
            <div class="col-6">          <q-input v-model="input1" label="Input 1"></q-input>
</div>
            <div class="col-6">          <q-input v-model="input1" label="Input 1"></q-input>
</div>
            <div class="col-6">          <q-input v-model="input1" label="Input 1"></q-input>
</div>

          </div>

        </q-form>
        </div>
      </q-card-section>
      <q-separator/>

      <q-card-actions align="right">
        <q-btn label="Cancel" color="primary" @click="dialogVisible = false" v-close-popup/>
        <q-btn label="Save" color="positive" @click="saveData" />
      </q-card-actions>



      </q-card>
    </q-dialog>

    </q-page>
</template>

<script>
import { ref } from 'vue'

const columns = [
  {
    name: 'name',
    required: true,
    label: 'Dessert (100g serving)',
    align: 'left',
    field: row => row.name,
    format: val => `${val}`,
    sortable: true
  },
  { name: 'calories', align: 'center', label: 'Calories', field: 'calories', sortable: true },
  { name: 'fat', label: 'Fat (g)', field: 'fat', sortable: true },
  { name: 'carbs', label: 'Carbs (g)', field: 'carbs' },
  { name: 'protein', label: 'Protein (g)', field: 'protein' },
  { name: 'sodium', label: 'Sodium (mg)', field: 'sodium' },
  { name: 'calcium', label: 'Calcium (%)', field: 'calcium', sortable: true, sort: (a, b) => parseInt(a, 10) - parseInt(b, 10) },
  { name: 'iron', label: 'Iron (%)', field: 'iron', sortable: true, sort: (a, b) => parseInt(a, 10) - parseInt(b, 10) } ,
  {
                          name: "action",
                          align: "left",
                          label: "Action",
                          field: "action",
                          sortable: true
                      }

]

const rows = [
  {
    name: 'Frozen Yogurt',
    calories: 159,
    fat: 6.0,
    carbs: 24,
    protein: 4.0,
    sodium: 87,
    calcium: '14%',
    iron: '1%'
  },
  {
    name: 'Ice cream sandwich',
    calories: 237,
    fat: 9.0,
    carbs: 37,
    protein: 4.3,
    sodium: 129,
    calcium: '8%',
    iron: '1%'
  },
  {
    name: 'Eclair',
    calories: 262,
    fat: 16.0,
    carbs: 23,
    protein: 6.0,
    sodium: 337,
    calcium: '6%',
    iron: '7%'
  },
  {
    name: 'Cupcake',
    calories: 305,
    fat: 3.7,
    carbs: 67,
    protein: 4.3,
    sodium: 413,
    calcium: '3%',
    iron: '8%'
  },
  {
    name: 'Gingerbread',
    calories: 356,
    fat: 16.0,
    carbs: 49,
    protein: 3.9,
    sodium: 327,
    calcium: '7%',
    iron: '16%'
  },
  {
    name: 'Jelly bean',
    calories: 375,
    fat: 0.0,
    carbs: 94,
    protein: 0.0,
    sodium: 50,
    calcium: '0%',
    iron: '0%'
  },
  {
    name: 'Lollipop',
    calories: 392,
    fat: 0.2,
    carbs: 98,
    protein: 0,
    sodium: 38,
    calcium: '0%',
    iron: '2%'
  },
  {
    name: 'Honeycomb',
    calories: 408,
    fat: 3.2,
    carbs: 87,
    protein: 6.5,
    sodium: 562,
    calcium: '0%',
    iron: '45%'
  },
  {
    name: 'Donut',
    calories: 452,
    fat: 25.0,
    carbs: 51,
    protein: 4.9,
    sodium: 326,
    calcium: '2%',
    iron: '22%'
  },
  {
    name: 'KitKat',
    calories: 518,
    fat: 26.0,
    carbs: 65,
    protein: 7,
    sodium: 54,
    calcium: '12%',
    iron: '6%'
  }
]

export default {
  setup () {
    return {
      visibleColumns: ref([ 'calories', 'desc', 'fat', 'carbs', 'protein', 'sodium', 'calcium', 'iron', 'action']),

      columns,
      rows
    }
  } ,
  data () {
    return {
      employee_dialog: false,

    }
  }
}
</script>
