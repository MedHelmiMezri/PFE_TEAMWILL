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
              <q-btn push  dense class="text-capitalize text-blue shadow-3" icon="lock" @click="showDetails(props.row)"/>
              <q-btn to = "/taskdetails" push  dense class="text-capitalize text-green shadow-3" icon="person" />
              <q-btn push dense  class="text-capitalize text-red shadow-3" icon="lock"/>
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

  <q-card style="width: 400px">
      <q-bar dense style="height: 15px" class="bg-blue-grey-8">
      </q-bar>
      <q-card-section>
        {{ selectedRow.email }}
        <div class="text-h6">Permissions</div>
      </q-card-section>

      <q-card-section class="q-pt-none">
        <q-select
          label="Roles"
          v-model="newRoles"
          :options="rolesList"
          emit-value
          map-options
          outlined
          required
          filled
          dense
          options-dense
          multiple
          counter
          use-chips
          stack-label
          max-values="2"
          hint="Max 2 selections"
          class="q-mb-md">

        </q-select>
      </q-card-section>
      <q-separator/>
      <q-card-actions align="right">
        <q-btn size="sm"
               id="confirmUpdateRoles"
               label="confirm"
               color="blue-grey"
               @click="updateRoles"
               v-close-popup/>
        <q-btn size="sm"
               label="close"
               color="grey"
               v-close-popup/>
      </q-card-actions>
    </q-card>
  </q-dialog>
  </q-page>
</template>

<script>
import { ref } from 'vue'

const columns = [
{
  name: 'username',
  required: true,
  label: 'username',
  align: 'left',
  field: row => row.name,
  format: val => `${val}`,
  sortable: true
},
{ name: 'email', align: 'center', label: 'email', field: 'email', sortable: true },

{ name: "action", align: "left", label: "Action",field: "action", sortable: true}

]

const rows = [
{
  username: 'helmi mezri',
  email: 'helmi@gmail.com'

}

]

export default {
setup () {
  return {
    visibleColumns: ref([ 'username','email','action']),

    columns,
    rows ,
    rolesList: [
        'ROLE_ADMIN', 'ROLE_MODERATOR', 'ROLE_USER'
      ]
  }
} ,
data () {
  return {
    employee_dialog: false,
    selectedRow: null,


  }
} ,
methods :{
  showDetails(row) {
      this.selectedRow = row;
      this.employee_dialog = true;
      console.log(this.selectedRow)
    },
}
}
</script>
