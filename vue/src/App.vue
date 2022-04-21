<template>


<div id="webpage_background">
  <div class="home">
  <div id="app">
    <div id="nav">
      <router-link tag='button' v-bind:to="{ name: 'home' }" id="hme">Home</router-link>&nbsp;|&nbsp;
      <router-link tag='button' v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" id="can">Logout</router-link>
    </div>
    <router-view />
  </div>
  
  </div>
  </div>
  
</template>


<script>
import Login from '@/views/Login'
import Logout from '@/views/Logout'
import Home from '@/views/Home'


export default {
  
  views: {
    Login,
    Logout,
    Home
  }
};
</script>


<style scoped>
#webpage_background {
  background: #6304df;
  background-size: cover;
  height: 100vh;
  border: 10px solid black;

}

#nav {
  padding-top: 20px;
  display: flex;
  justify-content: flex-end;
  
}

#hme {
  background: linear-gradient(to right, #b1ff20, #05ffff);
  cursor: pointer;
  height: 30px;
  width: 5%;
  padding: 5px;
  display: block;
  border-radius: 20px;
  outline: none;
  font-family: 'Nunito Sans';
  font-size: 20px;
}
 #can{
   background: linear-gradient(to right, #b1ff20, #05ffff);
   cursor: pointer;
  height: 30px;
  width: 5%;
  padding: 5px;
  display: block;
  border-radius: 20px;
  outline: none;
  font-family: 'Nunito Sans';
  font-size: 20px;
 }

h1{
  display: flex;
  justify-content: center;
  color: rgb(228, 228, 228);
  
  font-size: 50px;
}

</style>