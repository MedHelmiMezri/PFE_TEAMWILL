<template>

<q-toolbar>
      <h6 class="text-weight-bolder">Dashboard</h6>
      <q-space></q-space>
      <q-icon name="fas fa-calendar-minus" size="" class="q-mr-sm" />
      <div class="text-overline">Wednesday, 21.03.2022</div>
    </q-toolbar>
    <div class="row q-col-gutter-md top">
      <div class="col-3">
        <q-card class="q-mx-md" bordered>
          <div class="flex flex-center column">
            <q-circular-progress
              show-value
              font-size="12px"
              value="70"
              size="100px"
              :thickness="0.22"
              color="green-7"
              track-color="green-2"
              class="q-ma-md"
            >
              784 Patients
            </q-circular-progress>
            <div>
              <q-badge color="green-2" rounded class="q-mr-sm" />Woman 40%
            </div>
            <div class="q-mb-xl">
              <q-badge color="green-7" rounded class="q-mr-sm" />Man 60%
            </div>
          </div>
        </q-card>
      </div>
      <div class="col-3">
        <q-card class="q-mx-md q-pa-md" bordered>
          <div class="text-overline">New patients</div>
          <div class="flex flex-center row">
            <div class="text-h4 text-weight-bolder q-mr-md">54</div>
            <q-chip
              color="green-1"
              text-color="green-3"
              icon="fas fa-chevron-up"
              >51%</q-chip
            >
          </div>
        </q-card>
        <q-card class="q-mx-md q-pa-md q-mt-sm" bordered>
          <div class="text-overline">Old patients</div>
          <div class="flex flex-center row">
            <div class="text-h4 text-weight-bolder q-mr-md">32</div>
            <q-chip color="red-1" text-color="red-3" icon="fas fa-chevron-down"
              >02%</q-chip
            >
          </div>
        </q-card>
      </div>
      <div class="col-6">
        <q-card class="q-mx-md q-pa-md doctors" bordered>
          <div class="text-overline">Statistic</div>
          <div class="">
            <q-carousel
              v-model="slide"
              vertical
              transition-prev="slide-down"
              transition-next="slide-up"
              swipeable
              animated
              control-color="green-7"
              navigation-icon="radio_button_unchecked"
              navigation
              padding
              arrows
              height="160px"
              class="text-black shadow-1 rounded-borders"
            >
              <q-carousel-slide name="style" class="column no-wrap flex-center">
                <q-icon name="style" size="36px" />
                <div class="q-mt-md text-center">
                  {{ lorem }}
                </div>
              </q-carousel-slide>
              <q-carousel-slide name="tv" class="column no-wrap flex-center">
                <q-icon name="live_tv" size="36px" />
                <div class="q-mt-md text-center">
                  {{ lorem }}
                </div>
              </q-carousel-slide>
              <q-carousel-slide
                name="layers"
                class="column no-wrap flex-center"
              >
                <q-icon name="layers" size="36px" />
                <div class="q-mt-md text-center">
                  {{ lorem }}
                </div>
              </q-carousel-slide>
            </q-carousel>
          </div>
        </q-card>
      </div>
    </div>
    <q-toolbar>
      <div class="text-overline">Events</div>
      <q-space></q-space>

      <div class="text-overline">Your patients today</div>
      <div class="text-caption text-green q-ml-md">All patients</div>
      <q-icon
        name="fas fa-chevron-right"
        size="10px"
        class=""
        color="green-7"
      />
    </q-toolbar>
  <q-card>
    <q-card-section>
      <q-card-section class="text-h6 q-pb-none bg-blue-grey-1">
        <q-item  style="display: flex; justify-content: center; align-items: center;">
          <q-item-section avatar class="">
            <q-icon color="blue" name="fas fa-chart-line" size="44px"/>
          </q-item-section>

          <q-item-section>
            <div class="text-h6" >Projects :</div>
          </q-item-section>
        </q-item>
      </q-card-section>
    </q-card-section>

      <q-separator style="margin-bottom: 16px;"></q-separator>
        <q-card-section>
          <ul>
      <li v-for="project in projects" :key="project.id">
        <q-item clickable v-ripple >
        <q-item-section avatar top>
          <q-avatar icon="folder" color="blue" text-color="white" />
        </q-item-section>

        <q-item-section>
          <q-item-label lines="1">{{ project.projectTitle }}</q-item-label>
          <q-item-label caption>{{ project.startDate }}</q-item-label>
          <q-item-label caption lines="2">
            <span class="text-weight-bold">Manager : </span>
          John Doe
          </q-item-label>
        </q-item-section>

        <q-item-section side >
          <q-btn class="bg-white float-right" push round color ="blue" icon="edit_location" @click="goToProjectDetails(project.id)"/>


        </q-item-section>
      </q-item>

      </li>
    </ul>

        </q-card-section>
        <q-resize-observer @resize="onResize"/>
        </q-card>


</template>

<script>
import ProjectService from "../../services/ProjectService";

export default {
  data() {
    return {
      projects: [],
    };
  },
  created() {
    this.fetchProjects();
  },
  methods: {
    async fetchProjects() {
      try {
        const response = await ProjectService.getAll();
        this.projects = response.data;
      } catch (error) {
        console.error(error);
      }
    },
    goToProjectDetails(id) {
      this.$router.push({ path: '/projectdetails/' + id });
    }
  },
};
</script>
