<template>

      <q-page>


        <div class="row">
          <div class="col-md-4 col-lg-4 col-xs-12 col-sm-12">
            <q-card   class="q-pa-lg flex flex-center text-center box-shadow" style="margin: 40px;">


              <q-card-section>
                <q-icon size="110px" name="ballot" style="color:blue;"/>
                <div class="text-h6">Project management</div>

              </q-card-section>


            </q-card>
          </div>
          <div class="col-md-4 col-lg-4 col-xs-12 col-sm-12">
            <q-card class="q-pa-lg flex flex-center text-center box-shadow" style="margin: 40px;">


              <q-card-section>
                <q-icon size="110px" name="view_comfy" style="color:blue;"/>
                <div class="text-h6">Timeline Management</div>

              </q-card-section>


            </q-card>
          </div>
          <div class="col-md-4 col-lg-4 col-xs-12 col-sm-12">
            <q-card class="q-pa-lg flex flex-center text-center box-shadow" style="margin: 40px;">


              <q-card-section>
                <q-icon size="110px" name="people" style="color:blue;"/>
                <div class="text-h6">Team Management</div>

              </q-card-section>

            </q-card>
          </div>
        </div>
        <hr>


      </q-page>

</template>
<script>
    export default {
        name: "Homepage",
        data() {
            return {}
        }
    }
</script>
<style scoped>
  .box-shadow:hover {
    box-shadow: 0 10px 13px -6px rgba(0, 0, 0, 0.2), 0 20px 31px 3px rgba(0, 0, 0, 0.14), 0 8px 38px 7px rgba(0, 0, 0, 0.12) !important;
  }
</style>
