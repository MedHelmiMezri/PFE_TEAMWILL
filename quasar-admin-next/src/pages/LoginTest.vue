<template>
    <q-layout>
    <q-page-container>


      <Form @submit="handleLogin" >
        <div class="form-group">
          <label for="username">Username</label>
          <Field name="username" type="text" class="form-control" />
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <Field name="password" type="password" class="form-control" />
        </div>


          <button class="btn btn-primary btn-block">

            <span>Login</span>
          </button>



      </Form>



    </q-page-container>
  </q-layout>

</template>

<script>


export default {
  name: "Login",

  data() {


    return {
      loading: false,
      message: ""
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    handleLogin(user) {
      this.loading = true;

      this.$store.dispatch("auth/login", user).then(
        () => {
          this.$router.push("/profile");
        },
        (error) => {
          this.loading = false;
          this.message =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();
        }
      );
    },
  },
};
</script>

<style scoped>

</style>
