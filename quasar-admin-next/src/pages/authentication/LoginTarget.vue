<template>
  <div>
   <nav>
    <input type="checkbox" id="check">
     <label for="check" class="checkbtn">
       &#8801;
     </label>
    <label class="logo"> TARGET</label>
   <ul>
      <li><a  href="#">Home</a></li>
      <li><a class="active" href="#">Sign In</a></li>
      <li><a href="#">Sign Up</a></li>
  </ul>
  </nav>
  </div>

    <div class="col-md-12">
      <div class="card card-container">
        <div class="text-h4 text-center text-bold q-pt-xl"> Login to continue</div>
        <q-form class="column" @submit.prevent="handleLogin">
        <q-input v-model="user.username" filled name="username" label="Username" type="text" >
        </q-input>
              <br/>

        <q-input v-model="user.password"  filled name="password" label="password" type="password">
        </q-input>
        <br/>
        <q-btn label="Sign In" type="submit" color="blue">
         <q-spinner
         v-show="loading"
         color="white"
          size="1em"
        />
        </q-btn>

        </q-form>
        <div>

        </div>
      </div>
      <center>
        <img src="../../../src/assets/teamb.png"  style ="height:300px" alt="Italian Trulli">
      </center>

    </div>
  </template>

<script>
//import InputText from 'primevue/inputtext';

import User from '../../models/user';



export default {
  name: 'Login',

  data() {
    return {
      user: new User('', ''),
      loading: false,
      message: ''
    };
  },

  computed: {

    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  created() {
    if (this.loggedIn) {
      this.$router.push('/testgantt');
    }
  },
  methods : {
    handleLogin() {
      console.log("auth test running")
      this.loading = true;

      if(this.user.username && this.user.password) {
          this.$store.dispatch('auth/login', this.user).then(
            () => {
              this.$router.push('/testgantt');
            },
            error => {
              this.loading = false;
              this.message = "BAD CREDENTIALS"

            }
          );
        }

    } ,
  }



  }
;
</script>

<style>
body{
    background-image: url("../../assets/webbg.jpg");
    background-size: cover;
    background-position: center;
    background-attachment: fixed;
    background-repeat: no-repeat;
}



.card-container.card {
  max-width: 400px !important;
  padding: 40px 40px;
}

.card {
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 10px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

*{
  padding:0;
  margin:0;
  text-decoration:none;
  list-style:none;
  box-sizing:border-box;
}


nav{
  background:#0082e6;
  height:80px;
  width:100%;
}

label.logo{
  color:white;
  font-size:35px;
  line-height:80px;
  padding:0 100px;
  font-weight: bold;
}

nav ul {
  float:right;
  margin-right:20px;
}
nav ul li{
  display:inline-block;
  line-height:80px;
  margin:0 5px;
}

nav ul li a {
  coor:white;
  font-size:17px;
  padding: 7px 13px;
  border-radius:3px;
  text-transform:uppercase;
}
a.active,a:hover{
  background:#1b9bff;
  transition:.5s;
}
.checkbtn{
  font-size:30px;
  color:white;
  float:right;
  line-height:80px;
  margin-right:40px;
  cursor:pointer;
   display:none;

}
#check{
  display:none;
}

@media (max-width:952px){
  label.logo{
    font-size:30px;
    padding-left:50px;
  }
  nav ul li a{
    font-size:16px;
  }
}

@media (max-width:858px){
  .checkbtn{
    display:block;
  }
  ul{
    position:fixed;
    width:100%;
    height:100vh;
    background:#2c3e50;
    top:80px;
    left:-100%;
    text-align:center;
    transition: all .5s;
  }
  nav ul li {
    display:block;
    margin: 50px 0;
    line-height:30px;
  }
  nav ul li a{
    font-size:20px;
  }
  a:hover,a.active{
    background:none;
    color:white;
  }

  #check:checked ~ ul{
    left:0;
  }
}
</style>
