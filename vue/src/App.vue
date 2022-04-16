<template>


<div id="webpage_background">
  <div class="home">
    
  <div id="app">
    <div id="nav">
      <router-link tag='button' v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link tag='button' v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
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


<style>


</style>