<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          @click="toggleLeftDrawer"
          icon="menu"
          aria-label="Menu"
        />
        <q-toolbar-title>
          TARGET
        </q-toolbar-title>

        <q-space/>
        <div class="q-gutter-sm row items-center no-wrap">
          <q-btn round dense flat color="white" :icon="$q.fullscreen.isActive ? 'fullscreen_exit' : 'fullscreen'"
                 @click="$q.fullscreen.toggle()"
                 v-if="$q.screen.gt.sm">
          </q-btn>

          <q-btn round  padding="none">
            <div v-html="avatar" style="width:50px">
            </div>
            <q-menu>
          <q-list dense style="min-width: 100px">
            <q-item clickable v-close-popup>
              <q-item-section>Open...</q-item-section>
            </q-item>
            <q-item clickable v-close-popup>
              <q-item-section>New</q-item-section>
            </q-item>
            <q-separator />
            <q-item clickable>
              <q-item-section>Preferences</q-item-section>
              <q-item-section side>
                <q-icon name="keyboard_arrow_right" />
              </q-item-section>

              <q-menu anchor="top end" self="top start">
                <q-list>
                  <q-item
                    v-for="n in 3"
                    :key="n"
                    dense
                    clickable
                  >
                    <q-item-section>Submenu Label</q-item-section>
                    <q-item-section side>
                      <q-icon name="keyboard_arrow_right" />
                    </q-item-section>
                    <q-menu auto-close anchor="top end" self="top start">
                      <q-list>
                        <q-item
                          v-for="n in 3"
                          :key="n"
                          dense
                          clickable
                        >
                          <q-item-section>3rd level Label</q-item-section>
                        </q-item>
                      </q-list>
                    </q-menu>
                  </q-item>
                </q-list>
              </q-menu>

            </q-item>
            <q-separator />
            <q-item v-on:click="logOut"  clickable v-close-popup>
              <q-item-section>Logout</q-item-section>
            </q-item>
          </q-list>
        </q-menu>
          </q-btn>
        </div>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
      class="bg-light-blue-8

 text-white"
    >

      <q-list>
       <q-item to="/" active-class="q-item-no-link-highlighting">

          <q-item-section>
          <center><q-item-label><img class="logo" src="../assets/tm.png"/></q-item-label>
         </center>
          </q-item-section>
        </q-item>
        <q-item to="/pageone" active-class="q-item-no-link-highlighting">
          <q-item-section avatar>
            <q-icon name="dashboard"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Home</q-item-label>
          </q-item-section>
        </q-item>
        <q-item to="/pageone" active-class="q-item-no-link-highlighting">
          <q-item-section avatar>
            <q-icon name="notifications_active"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Notifications</q-item-label>
          </q-item-section>
        </q-item>
        <q-item to="/pageone" active-class="q-item-no-link-highlighting">
          <q-item-section avatar>
            <q-icon name="attachment"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Library</q-item-label>
          </q-item-section>
        </q-item>

        <q-expansion-item
          icon="folder_open"
          label="Portfolio"
        >
          <q-item to="/projectlist" class="q-ml-xl" active-class="q-item-no-link-highlighting">
          <q-item-section avatar>
            <q-icon name="workspaces"/>
          </q-item-section>
            <q-item-section>
              <q-item-label>Projects</q-item-label>
            </q-item-section>
          </q-item>
          <q-item to ="/testtest" class="q-ml-xl" active-class="q-item-no-link-highlighting">
         <q-item-section avatar>
            <q-icon name="confirmation_number"/>
          </q-item-section>
            <q-item-section>
              <q-item-label>Tasks</q-item-label>
            </q-item-section>
          </q-item>
          <q-item to="/users" class="q-ml-xl" active-class="q-item-no-link-highlighting">
            <q-item-section avatar>
            <q-icon name="people"/>
          </q-item-section>
            <q-item-section>
              <q-item-label>Members</q-item-label>
            </q-item-section>
          </q-item>
        </q-expansion-item>


        <q-item to="/testgantt" active-class="q-item-no-link-highlighting">
          <q-item-section avatar>
            <q-icon name="account_tree"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Gantt</q-item-label>
          </q-item-section>
        </q-item>
        <q-item to="/pageone" active-class="q-item-no-link-highlighting">
          <q-item-section avatar>
            <q-icon name="calendar_month"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Schedule</q-item-label>
          </q-item-section>
        </q-item>
        <q-item to="/pageone" active-class="q-item-no-link-highlighting">
          <q-item-section avatar>
            <q-icon name="dashboard"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Schedule</q-item-label>
          </q-item-section>
        </q-item>

      </q-list>
    </q-drawer>

    <q-page-container class="bg-grey-2">
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import EssentialLink from 'components/EssentialLink.vue'
import Messages from "./Messages";

import { defineComponent, ref } from 'vue'

export default defineComponent({
  name: 'MainLayout',

  components: {
    EssentialLink,
    Messages
  },
  computed: {
    avatar() {

      let str =this.$store.state.auth.user.username ;
      let cleanedStr = str.replace(/"/g, '');
      const seed = cleanedStr;
      const svg = this.$dicebear.generateAvatar(seed);
      console.log(cleanedStr);

      return svg;
    }},

  setup () {
    const leftDrawerOpen = ref(false)

    return {
      leftDrawerOpen,
      toggleLeftDrawer () {
        leftDrawerOpen.value = !leftDrawerOpen.value
      } ,
       tab: ref('mails')
    }
  },
  methods :{
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }
})
</script>
<style>
.logo {
  width : 200px
}
</style>
