import { createRouter, createWebHistory } from 'vue-router'
import store from '@/store/index'
import LogIn from '@/views/account/LoginView.vue'
import Register from '@/views/account/RegisterView.vue'
import Home from '@/views/home/HomeView.vue'
import Settings from '@/views/settings/SettingsView.vue'
import SettingPwd from '@/views/settings/SettingPwdView.vue'

const routes = [
  {
    path: "/login/",
    name: "login",
    component: LogIn,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/register/",
    name: "register",
    component: Register,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/",
    name: "home",
    component: Home,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/settings/",
    name: "settings",
    component: Settings,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/settings/pwd/",
    name: "setting_pwd",
    component: SettingPwd,
    meta: {
      requestAuth: true,
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
