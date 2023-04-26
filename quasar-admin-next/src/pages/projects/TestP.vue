<template>


  <div class="content-center" style="height: 100vh" >
    <!--        redirection to createTopic Form  -->
    <h5>-- Create project Form --</h5>
    <q-slide-transition>
      <div ref="addTopic">
        <div class="row justify-evenly col-6 col-md-6 flex wrap">
          <q-card bordered v-bind:style="$q.screen.lt.sm ? {'width': '40%'} : {'width': '70%'}" >
            <q-bar dense style="height: 15px; background-color: blue;">
            </q-bar>
            <q-card-section>
              <q-avatar size="8rem" class="absolute-center shadow-12">
                <q-icon name="list"></q-icon>
              </q-avatar>
            </q-card-section>
            <q-card-section>
              <div class="q-pt-lg">
                <div class="col text-h4 ellipsis flex justify-center">
                  &nbsp;
                </div>
              </div>
            </q-card-section>
            <q-card-section>
              <q-form id="userCreateForm" ref="addTopic" @submit.prevent="submitTopicForm">
                <div class="row justify-evenly">
                  <div class="col-md-8">
                    <q-input
                      id="nametopic"
                      ref = "nametopic"
                      label="Topic Name"
                      outlined
                      required
                      filled
                      dense
                      hint="hint: size 60 alphabet"
                      v-model="newtopic.nametopic"
                      :rules="[this.isRequired, this.isValid]"
                      class="q-mb-md"
                    >
                      <template v-slot:prepend>
                        <q-icon name="title" />
                      </template>
                    </q-input>
                    <q-input
                      id="headline"
                      ref = "headline"
                      label="Headline"
                      outlined
                      required
                      filled
                      clearable
                      autogrow
                      dense
                      hint="hint: size 80 alphabet"
                      v-model="newtopic.headline"
                      :rules="[this.isRequired, this.isValid]"
                      class="q-mb-md"
                    >
                      <template v-slot:prepend>
                        <q-icon name="label" />
                      </template>
                    </q-input>
                    <div class="row justify-between">
                      <q-select
                        label="Category"
                        v-model="newtopic.category"
                        :rules="[this.isRequired]"
                        :options="Categories"
                        outlined
                        required
                        filled
                        dense
                        options-dense
                        hint="Max 1 selections"
                        class="col-md-6"
                      >
                        <template v-slot:prepend>
                          <q-icon name="category" />
                        </template>
                      </q-select>
                      <q-select
                        label="Speciality"
                        v-model="newtopic.speciality"
                        :rules="[this.isRequired]"
                        :options="Specialities"
                        outlined
                        required
                        filled
                        dense
                        options-dense
                        stack-label
                        hint="Max 1 selections"
                        class="col-md-5"
                      >
                        <template v-slot:prepend>
                          <q-icon name="admin_panel_settings" />
                        </template>
                      </q-select>
                    </div>
<!--                    <q-select
                      label="Events"
                      v-model="newtopic.events"
                      :options="eventsList"
                      emit-value
                      map-options
                      :rules="[this.isRequired]"
                      outlined
                      required
                      filled
                      dense
                      options-dense
                      multiple
                      counter
                      use-chips
                      stack-label
                      class="q-mb-md"
                    />-->
                    <br>
                    <div class="row justify-end">
                      <q-btn label="Create Topic"
                             class="col-md-5"
                             style="background-color: #009688;"
                             glossy
                             type="submit"/>
                    </div>
                  </div>
                </div>
              </q-form>
            </q-card-section>
            <q-card-section>
            </q-card-section>
          </q-card>
        </div>
      </div>
    </q-slide-transition>
  </div>

  <q-dialog v-model="alert"
            persistent transition-show="flip-down" transition-hide="flip-up">
    <q-card style="width: 400px">
      <q-bar dense style="height: 15px">
      </q-bar>
      <q-card-section>
        <q-icon :name="alertIcon" :color="alertColor" size="3rem"/>
        <q-item-label>{{this.responseD}}</q-item-label>
      </q-card-section>
      <q-separator/>
      <q-card-actions align="right">
        <q-btn label="OK" dense v-close-popup :color="alertColor"/>
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>

<script>
import { ref } from 'vue'
// import { authHeader } from 'src/services/auth-header'
// import { api } from 'boot/axios'
//import TopicService from '../services/topic.service'
// import { createTopic } from '../../../services/topic.service'

export default {
  components: { },
  name: 'CreateTopic',
  setup () {
    // confirm dialog creating user

    return {

      alert: ref(false),
      alertType: ref(''),
      alertIcon: ref(''),
      alertColor: ref(''),
      responseD: ref(''),

      eventsList: [
        'events...'
      ],
      Categories: [
        'Category-1', 'Category-2', 'Category-3', 'Category-4'
      ],
      Specialities: [
        'Speciality-1', 'Speciality-2', 'Speciality-3', 'Speciality-4'
      ]
    }
  },
  created () {
  },
  data () {
    return {
      // dialog forconfirm createTopic
      showAddTopicDialog: false,
      // newtopic: []
      newtopic: {
        nametopic: '', // unique ref
        headline: '',
        category: '',
        speciality: ''
        // events: []
      }
    }
  },
  methods: {
    /*
    async submitTopicForm () {
      console.log('this.newtopic - registerTopicForm: ' + JSON.stringify(this.newtopic))
      try {
        console.log(this.newtopic)
        await this.createTopic(this.newtopic)
        this.autoClose()
      } catch (err) {
        console.log('err.response.data.detail : ' + err.response.data.response)
        if (err.response.data.detail) {
          this.$q.notify({
            type: 'negative',
            message: err.response.data.detail
          })
        }
      }
    },
  */
    async submitTopicForm () {
      // Call the API to add a new user with the form data
      /*
      const newtopic = {
        topicName: this.newtopic.nametopic,
        headline: this.newtopic.headline,
        category: this.newtopic.category,
        speciality: this.newtopic.speciality
        // events: this.newtopic.events
      }
      console.log('newtopic : ' + newtopic)
    */

      console.log('this.newtopic - registerTopicForm: ' + JSON.stringify(this.newtopic))
      try {
        const response = await TopicService.createTopic(this.newtopic)
        this.responseD = response.data
        console.log('response.data ' + JSON.stringify(response.data))
        this.alertType = 'text-positive'
        this.alertIcon = 'add_task'
        this.alertColor = 'positive'
        // await this.fetchTopics
        this.alertType = 'text-positive'
        // this.$router.push('/home')
        /* } else {
          this.error(response)
        } */
      } catch (err) {
        console.error('catched')
        this.error(err)
      }
      this.alert = true
    },
    error (error) {
      this.alertType = 'text-negative'
      this.alertIcon = 'report_problem'
      this.alertColor = 'negative'
      this.responseD = JSON.stringify(error.response.data)
      console.log(JSON.stringify(error.response.data))
    },
    isRequired (val) {
      console.log(val)
      return (val && val.length > 0) || 'This Field is missing! '
    },
    isValid (val) {
      console.log(val)
      const namePattern = /^[a-zA-Z0-9\s.\-,_]+$/
      return (namePattern.test(val)) || 'Invalid Format!'
    }
  }
}
</script>

<style scoped>

</style>
