<template>
  <q-page class="q-pa-sm bg-white">
    <div class="row q-col-gutter-sm">
      <div>
    <q-card>
      <q-card-section>
        <div class="text-h6 text-indigo-8">
          Add new project
        </div>
        <div class="text-subtitle2">
        </div>
      </q-card-section>

      <q-separator></q-separator>
      <q-card-section class="q-pa-none">
      <div class="row">
              <div class="col-6">
                <q-item>
                      <q-input filled v-model="text" label="Project Name"  class="full-width"/>
                </q-item>
              </div>
              <div class="col-6">
                <q-item>
                      <q-input filled v-model="text" label="Budget"  class="full-width"/>

                  </q-item>
              </div>
               <div class="col-12">
                <q-item>
                                        <q-input filled v-model="text" label="Description"  class="full-width"/>

                </q-item>
              </div>
              <div class="col-6">
                <q-item>
                        <q-input v-model="time" filled type="date" hint="Native date" />

                </q-item>
              </div>

              <div class="col-6">
                <q-item>
                  <q-input dense outlined class="full-width" label="City *"/>
                </q-item>
              </div>
              <div class="col-6">
                <q-item>
                  <q-input dense outlined class="full-width" label="State"/>
                </q-item>
              </div>


            </div>
      </q-card-section>
      <q-card-section>


      <q-btn class = "btn1" color="primary" label="Submit" />
      <q-btn  class ="btn2" color="secondary" label="Add new Project " />
      </q-card-section>
    </q-card>
      </div>
    </div>

  </q-page>
</template>

<script>
import {defineComponent} from 'vue';
//import {ref} from 'vue';


export default defineComponent({
  

})
</script>

<style scoped>
.btn1{
   margin-right: 20px;
}
.btn2{
   margin-right: 20px;
}
</style>
