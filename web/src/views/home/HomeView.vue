<template>
  <div class="home">
    <div class="side-bar"><NavBar></NavBar></div>
    <div class="home-body">
      <div class="table">
        <section class="header">
          <p class="text">歌曲列表</p>
          <div class="input-group">
            <input
              type="search"
              placeholder="Search Data..."
              v-model="filter"
              @keyup.enter="refresh_list"
            />
            <img src="@/assets/image/search.png" />
          </div>
        </section>
        <section class="shell">
          <table>
            <tbody>
              <tr v-for="song in songlist" :key="song.id">
                <td class="info">
                  <img :src="song.photo" />
                  <p class="name">{{ song.songName }}</p>
                </td>
                <td></td>
                <td>
                  <p class="button" @click="playsong(song.id)">播放</p>
                </td>
              </tr>
            </tbody>
          </table>
        </section>
      </div>
      <div class="playbar">
        <PlayBar ref="playbar"></PlayBar>
      </div>
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
.table {
  margin-left: 2vw;
  margin-top: 5vh;
  width: 70vw;
  height: 57vh;
  background-color: var(--bg-color);
  box-shadow: 0 8px 16px #0005;
  border-radius: 16px;
  overflow: hidden;
}
.header {
  width: 66vw;
  height: 12%;
  background-color: lightslategray;
  padding: 0 40px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.text {
  font-size: 20px;
  font-family: "BasketBall";
  color: var(--theme-info-text-color);
}
.header .input-group {
  width: 35%;
  height: 60%;
  background-color: #fff5;
  padding: 0 20px;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: 0.2s;
}

.header .input-group:hover {
  width: 45%;
  background-color: #fff8;
  box-shadow: 0 5px 40px #0002;
}

.header .input-group img {
  width: 20px;
  height: 20px;
}

.header .input-group input {
  width: 100%;
  background-color: transparent;
  border: none;
  outline: none;
}

.shell {
  width: 95%;
  max-height: calc(90% - 25px);
  background-color: #fffb;
  margin: 8px auto;
  border-radius: 10px;
  overflow: auto;
  overflow: overlay;
}

.shell::-webkit-scrollbar {
  width: 10px;
  height: 10px;
}

table {
  width: 100%;
}

td img {
  /* vertical-align: middle; */
  margin-top: 1vh;
  margin-left: 5vw;
  width: 50px;
  height: 50px;
  margin-right: 10px;
  border-radius: 50%;
}
.info {
  display: flex;
}
.name {
  width: fit-content;
  font-size: 20px;
  margin-left: 2vw;
}

table,
td {
  border-collapse: collapse;
  padding: 5px;
  text-align: left;
  /* display: flex; */
}

/* 偶数行背景色 */
tbody tr:nth-child(even) {
  background-color: #0000000b;
}
tbody tr {
  border-top: 2px solid rgb(229, 233, 236);
}

tbody tr:hover {
  background-color: var(--theme-hover-menu-color);
}

.button {
  width: 5vw;
  padding: 5px 0;
  border-radius: 40px;
  text-align: center;
  background-color: lightslategray;
}
.button:hover {
  color: white;
}

.playbar {
  margin-top: 5vh;
}
</style>

<script>
import NavBar from "@/components/NavBar.vue";
import PlayBar from "@/components/PlayBar.vue";
import { useStore } from "vuex";
import $ from "jquery";

export default {
  components: {
    NavBar,
    PlayBar,
  },
  data() {
    return {
      store: useStore(),
      theme: false,
      songlist: [],
      filter: "",
    };
  },
  mounted() {
    document.body.setAttribute("theme-color", "light");
    this.getlist();
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
    getlist() {
      $.ajax({
        url: "http://localhost:8080/get/songlist/",
        type: "get",
        headers: {
          Authorization: "Bearer " + this.store.state.user.token,
        },
        success: (resp) => {
          this.songlist = resp;
        },
      });
    },
    playsong(index) {
      this.store.commit("updateSong", index);
      this.$refs.playbar.playSong();
    },
    refresh_list() {
      $.ajax({
        url: "http://localhost:8080/search/songlist/",
        type: "get",
        headers: {
          Authorization: "Bearer " + this.store.state.user.token,
        },
        data: {
          filter: this.filter,
        },
        success: (resp) => {
          this.songlist = resp;
        },
      });
    },
  },
};
</script>