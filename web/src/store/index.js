import { createStore } from 'vuex'
import ModuleUser from './user'
import ModuleSongPlay from './songPlay'

export default createStore({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user: ModuleUser,
    songPlay: ModuleSongPlay,
  }
})
