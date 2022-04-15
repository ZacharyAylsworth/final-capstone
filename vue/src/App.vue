<template>
<div>
<decks-list />
<div id="webpage_background">
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
  </div>
  </div>
</template>

<script>
import DecksList from '@/components/DecksList'
import Login from '@/views/Login'
import Logout from '@/views/Logout'
import Home from '@/views/Home'


export default {
  components: { DecksList },
  views: {
    Login,
    Logout,
    Home
  }
};
</script>

<style>

</style>