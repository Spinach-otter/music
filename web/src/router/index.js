import { createRouter, createWebHistory } from 'vue-router'
import store from '@/store/index'
import LogIn from '@/views/account/LoginView.vue'
import Register from '@/views/account/RegisterView.vue'
import Home from '@/views/home/HomeView.vue'

const routes = [
  {
    path: "/login/",
    name: "login",
    component: LogIn,
    meta: {
      requestAuth: false,
      hideComponent: true,
    }
  },
  {
    path: "/register/",
    name: "register",
    component: Register,
    meta: {
      requestAuth: false,
      hideComponent: true,
    }
  },
  {
    path: "/",
    name: "home",
    component: Home,
    meta: {
      requestAuth: true,
      hideComponent: false,
    }
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.requestAuth && !store.state.user.is_login) {
    next({ name: "login" });
  } else {
    next();
  }
})
export default router
