<template>
  <q-page class="q-pa-sm ">
    <q-card>
      <q-card-section class="row">
        <div class="text-h6 text-weight-bolder text-grey-8">
          Welcome Helmi Mezri
        </div>
      </q-card-section>
      <q-separator></q-separator>
       <q-card-section class="row">
        <div class="text-h6 text-weight-bolder text-grey-8">
         TODAY : {{currentDate()}}
        </div>
      </q-card-section>

    </q-card>
    <div class="row q-col-gutter-sm q-ma-xs q-mr-sm">
      <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
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
      <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
        <q-card>
          <q-card-section :class="$q.dark.isActive?'green_dark':'bg-green-8'" class="text-white">
            <div class="row">
              <div class="col-10">
                <div class="text-h6">Projects</div>
                <div class="text-h5">14</div>
              </div>
              <div class="col-2">
                <q-icon size="62px" name="far fa-dot-circle"/>
              </div>
            </div>
          </q-card-section>
        </q-card>
      </div>
      <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
        <q-card>
          <q-card-section :class="$q.dark.isActive?'orange_dark':'bg-orange-9'" class="text-white">
            <div class="row">
              <div class="col-10">
                <div class="text-h6"> Team</div>
                <div class="text-h5">
                  26
                </div>
              </div>
              <div class="col-2">
                <q-icon size="62px" name="list"/>
              </div>
            </div>
          </q-card-section>
        </q-card>
      </div>
    </div>
  
    <div class="row q-col-gutter-sm q-py-sm">
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
      <GtaskChart></GtaskChart>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
      <UserCard></UserCard>
      </div>
     
    </div>
    <div>
      <ProjectCard></ProjectCard>

    </div>
  </q-page>
</template>

<script>
import {defineComponent, defineAsyncComponent} from 'vue'

export default defineComponent({
  name: "Charts",
  components: {
    GtaskChart: defineAsyncComponent(() => import('../../components/targetcharts/GTaskChart')),
    ProjectCard : defineAsyncComponent(() => import('../../components/targetcharts/ProjectCard')) ,
    UserCard : defineAsyncComponent(() => import('../../components/targetcharts/UserCard')) , 
  },
  methods: {
    currentDate() {
      const current = new Date();
      const date = `${current.getDate()}/${current.getMonth()+1}/${current.getFullYear()}`;
      return date;
    }
  }
})
</script>

<style scoped>

</style>