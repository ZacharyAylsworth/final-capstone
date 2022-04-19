import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import AddFlashCard from '../views/AddFlashCard.vue'
import Deck from '../views/Deck.vue'
import EditCard from '../views/EditCard.vue'
import Card from '../views/Card.vue'
import ListCards from '../views/ListCards.vue'
import Study from '../views/Study.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true  // should be true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: '/decks',
      name: "Deck",
      component: Deck,
      meta: {
        requiresAuth: true //true
      }
    },

    {
      path: '/decks/:deckID/cards/:cardID',
      name: 'Card',
      component: Card,
      meta: {
        requiresAuth: true //true
      }
    },

    {
      path: '/decks/:deckID/cards/create',
      name: 'AddFlashCard',
      component: AddFlashCard,
      meta: {
        requiresAuth: true //true
      }
    },

    {
      path: '/decks/:deckID/study',
      name: 'Study',
      component: Study,
      meta: {
        requiresAuth: true //true
      }
    },

    {
      path: '/decks/:deckID/cards/:cardID/edit',
      name: 'EditCard',
      component: EditCard,
      meta: {
        requiresAuth: true //true
      }
    },
//added stuff
    {
      path: '/decks/:deckID/cards/',
      name: 'ListCards',
      component: ListCards,
      meta: {
        requiresAuth: true
      }

    }
//added stuff
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
