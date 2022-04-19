<template>
  <div class="container">
    <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="register">
        <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <label for="username" class="sr-only"></label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password" class="sr-only"></label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
        <router-link :to="{ name: 'login' }" id="haveAccount">Have an account?</router-link>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
          Create Account
        </button>
      </form>
    </div>
   </div> 
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>




<style scoped>

.container{
  border: 1px solid;
  width: 500px;
  height: 500px;
  position: relative;
  margin: 10% auto;
  background: #fff;
  padding: 5px; 
  border-radius: 10px;
}

#haveAccount {
  display: flex;
  justify-content: center;
  margin: 35px auto;
}


#register {
  text-align: center;
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

.sr-only{
  color: white;
}


.btn{
  cursor: pointer;
  height: 35px;
  margin: 50px;
  width: 75%;
  padding: 5px;
  display: block;
  margin: auto;
  border-radius: 20px;
  outline: none;
  background: linear-gradient(to right, #abff10, #ffad06);
  font-size: 16px;
}


#register {
  margin: 13%
}

</style>
