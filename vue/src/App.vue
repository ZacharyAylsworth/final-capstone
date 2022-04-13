<template>
<div id="webpage_background">
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
  </div>
</template>

<script>
import Login from '@/views/Login'
import Logout from '@/views/Logout'

export default {
  views: {
    Login,
    Logout
  }
};
</script>

<style>

</style>