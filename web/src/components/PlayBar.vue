<template>
  <div class="music">
    <img :src="$store.state.songPlay.music_photo" alt="" class="music-image" />
    <div class="title">{{ $store.state.songPlay.music_name }}</div>
    <div class="player">
      <audio ref="audioPlayer" :src="$store.state.songPlay.music_src"></audio>
      <div class="btns">
        <div class="prev">
          <span class="material-icons" @click="prevSong"> skip_previous </span>
        </div>
        <div class="playPause">
          <span class="material-icons" @click="LetPlaySong">
            {{ $store.state.songPlay.play_icon }}
          </span>
        </div>
        <div class="next">
          <span class="material-icons" @click="nextSong"> skip_next </span>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import url(../assets/themecss/theme.scss);

.music {
  border-top: 1px solid rgb(229, 233, 236);
  display: flex;
  /* flex-direction: column;
  justify-content: center;
  align-items: center; */
  align-items: center;
  width: 74vw;
}
.music-image {
  width: 100px;
  height: 100px;
  margin-top: 3px;
  margin-left: 8vw;
  border-radius: 50%;
  border: 3px solid rgb(229, 233, 236);
}
.title {
  margin-left: 20px;
  width: 250px;
  height: 100px;
  display: flex;
  align-items: center; /* 文本垂直居中 */
  justify-content: center; /* 文本水平居中 */
  font-size: 20px;
  color: var(--theme-info-text-color);
}
.player {
  position: relative;
  width: 220px;
  min-height: 50px;
  /* background: #fbfbfb; */
  background-color: var(--bg-color);
  border: 2px solid #fff;
  border-radius: 80px;
  padding: 20px 30px;
  box-shadow: 10px 10px 15px rgba(0, 0, 0, 0.1),
    inset 5px 5px 15px rgba(0, 0, 0, 0.1);
}

.btns {
  /* position: relative; */
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  /* background: red; */
}
.btns div {
  position: relative;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  /* background: #fff; */
  background-color: var(--bg-color);
  display: flex;
  justify-content: center;
  align-items: center;
  color: #777;
  cursor: pointer;
  box-shadow: var(--btn-shodow);
}
.btns div:hover,
.btns div.hover {
  color: var(--theme-hover-color);
  box-shadow: inset 0 -2px 5px rgba(0, 0, 0, 0.15),
    inset 0 2px 5px rgba(0, 0, 0, 0.15);
}

.btns .playPause {
  height: 50px;
  width: 50px;
}
.btns .material-icons {
  font-size: 2em;
}
.btns .playPause span {
  font-size: 3em;
}
</style>

<script>
import { useStore } from "vuex";

export default {
  data() {
    return {
      store: useStore(),
    };
  },
  mounted() {
    this.store.dispatch("getlist");
  },
  methods: {
    playSong() {
      this.store.state.songPlay.songPlaying = true;
      this.store.state.songPlay.play_icon = "pause";
      this.$refs.audioPlayer.play();
    },
    pauseSong() {
      this.store.state.songPlay.songPlaying = false;
      this.store.state.songPlay.play_icon = "play_arrow";
      this.$refs.audioPlayer.pause();
    },
    //play/pause song
    LetPlaySong() {
      if (!this.store.state.songPlay.songPlaying) {
        this.playSong();
      } else {
        this.pauseSong();
      }
    },
    nextSong() {
      this.pauseSong();
      this.store.dispatch("nextSong");
    },
    prevSong() {
      this.pauseSong();
      this.store.dispatch("preSong");
    },
  },
};
</script>
