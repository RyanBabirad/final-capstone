import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Landlord from '../components/Landlord.vue'
import Staff from '../components/Staff.vue'
import Tenant from '../components/Tenant.vue'
import UserProfile from '../components/UserProfile.vue'
import CardView from '../views/CardView.vue'
import AddCard from '../views/AddCard.vue'
import EditCard from '../views/EditCard.vue'

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
        requiresAuth: false
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
      path: "/user",
      name: "user",
      component: UserProfile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/landlord",
      name: "landlord",
      component: Landlord,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/staff",
      name: "staff",
      component: Staff,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/tenant",
      name: "tenant",
      component: Tenant,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/board/:boardID/card/:cardID',
      name: 'cardView',
      component: CardView
    },
    {
      path: '/board/:boardID/card/create',
      name: 'addCard',
      component: AddCard
    },
    {
      path: '/board/:boardID/card/:cardID/edit',
      name: 'editCard',
      component: EditCard
    }
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
