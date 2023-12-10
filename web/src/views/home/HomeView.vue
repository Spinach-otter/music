<template>
  <h1>home</h1>
  <a href="#" @click="logout">logout</a>
</template>

<script>
import { useRoute } from "vue-router";
import { computed } from "vue";
import { useStore } from "vuex";

export default {
  setup() {
    const store = useStore();
    const route = useRoute();
    let route_name = computed(() => route.name);

    const logout = () => {
      store.dispatch("logout");
    };

    return {
      route_name,
      logout,
    };
  },
};
</script>