<template> 
  <div class="container">
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
        
        <div
          class="alert alert-danger"
          role="alert"
          v-if="invalidCredentials"
        >Invalid username and password!
        </div>
        
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >Thank you for registering, please sign in.
        </div>
        
        <label for="username" class="sr-only">Username</label>
        
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        
        <label for="password" class="sr-only">Password</label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        
        <router-link :to="{ name: 'register' }" id="needAccountButton">Need an account?</router-link>
        <button type="submit" class="btn">Sign in</button>
      </form>
    </div>
   </div> 
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

.h3 {
  text-align: center;
  color: black;
  
}

#webpage_background {
  background-color: #06507a;
  height: 100vh;
}

.whole_background {
  color: rgb(15, 155, 26);
  display: block;
  margin: 8px;
}

.container {
    width: 500px;
    height: 500px;
    position: relative;
    margin: 10% auto;
    background: #fff;
    padding: 5px; 
    border-radius: 10px;  
}

.form-control {
  width: 100%;
  padding: 10px 0;
  margin: 5px 0;
  border-left: 0;
  border-top: 0;
  border-right: 0;
  border-bottom: 1px solid #999;
  outline: none;
  background: transparent;
  
}




.sr-only {
  color: white;
  
}

.btn {
  cursor: pointer;
    height: 35px;
    margin: 50px;
    width: 75%;
    padding: 5px;
    display: block;
    margin: auto;
    border-radius: 20px;
    outline: none;
    background: linear-gradient(to right, #b1ff20, #ff9f05);
    font-size: 17px;
}

#needAccountButton {
  display: flex;
  justify-content: center;
  margin: 45px auto;
}

#login {
  margin: 10%
}


</style>


