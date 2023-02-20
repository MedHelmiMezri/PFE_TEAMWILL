<template>
  <q-page class="q-pa-sm">

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

<div class="row q-col-gutter-sm q-py-sm">
      <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
        <bar-chart></bar-chart>
      </div>
       <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
        <pie-chart></pie-chart>
      </div>
</div>



  </q-page>
</template>

<script>
import {defineComponent, defineAsyncComponent} from 'vue';

export default defineComponent({
  name: "PageOne",
  components: {
    PieChart: defineAsyncComponent(() => import('components/charts/PieChart')),
    BarChart: defineAsyncComponent(() => import('components/charts/BarChart'))
  },
   setup () {
    return {
      lorem: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'
    }
  } ,
   methods: {
    currentDate() {
      const current = new Date();
      const date = `${current.getDate()}/${current.getMonth()+1}/${current.getFullYear()}`;
      return date;
    }
  }
})
</script>

<style lang="sass" scoped>
.my-card
  width: 100%
  max-width: 250px
</style>
