<template>
  <div class="home">
    <NavBar></NavBar>
    <div class="home-body">
      <PlayBar></PlayBar>
    </div>
  </div>
</template>

<style scoped>
@import url(@/assets/themecss/theme.scss);
.home {
  height: 80vh;
  width: 90vw;
  margin-left: 5vw;
  margin-top: 10vh;
  background-color: var(--bg-color);
  transition: 0.6s;
  display: flex;
  border-radius: 20px;
}
.home-body {
  margin-top: 68vh;
}
</style>

<script>
import NavBar from "@/components/NavBar.vue";
import PlayBar from "@/components/PlayBar.vue";

export default {
  components: {
    NavBar,
    PlayBar,
  },
  data() {
    return {
      theme: false,
    };
  },
  mounted() {
    document.body.setAttribute("theme-color", "light");
  },
  methods: {
    changeDark() {
      if (!this.theme) {
        document.body.setAttribute("theme-color", "dark");
        this.theme = !this.theme;
      } else {
        document.body.setAttribute("theme-color", "light");
        this.theme = !this.theme;
      }
    },
  },
};
</script>