<template>
  <div class="menu-wrapper">
    <div class="menu-title">
      <span class="iconfont icon-moonbyueliang"></span>
      <span class="title-text">Music</span>
    </div>
    <div class="content">
      <div class="person-info">
        <img :src="$store.state.user.avatar" alt="" />
        <div class="person-name">
          <div class="name">{{ $store.state.user.username }}</div>
          <!-- <span class="detail">前端小白</span> -->
        </div>
      </div>
      <div class="menu-content">
        <div class="menu-list">
          <div class="menu-list-item">
            <div class="block"></div>
            <span class="iconfont icon-caidan"></span>
            <div class="item-name">Home</div>
          </div>
          <!-- <div class="menu-list-item">
            <div class="block"></div>
            <span class="iconfont icon-gouwu"></span>
            <div class="item-name">Like</div>
          </div> -->
          <div class="menu-list-item">
            <div class="block"></div>
            <span class="iconfont icon-shezhi"></span>
            <div class="item-name">Settings</div>
          </div>
          <div class="menu-list-item bottom-item">
            <div class="block"></div>
            <span class="iconfont icon-jinru"></span>
            <div class="item-name">
              <a href="#" @click="logout" class="logout-a">Logout</a>
            </div>
          </div>

          <div class="menu-list-item">
            <div class="block"></div>
            <span class="iconfont icon-yueliang"></span>
            <div class="item-name">Dark Mode</div>
            <div class="btn">
              <input class="check-ipt" type="checkbox" id="checks" />
              <label
                class="check-lable"
                for="checks"
                @click="changeDark"
              ></label>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
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

<style lang="scss" scoped>
@import url(../assets/iconfont/iconfont.css);
@import url(../assets/themecss/theme.scss);
.iconfont {
  font-family: "iconfont" !important;
  font-style: normal;
  font-size: 25px;
  color: var(--theme-text-color);
  vertical-align: middle;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.menu-wrapper {
  border-right: 1px solid rgb(229, 233, 236);
  width: 220px;
  height: 80vh;
  //   border-radius: 20px;
  border-top-left-radius: 20px;
  border-bottom-left-radius: 20px;
  background-color: var(--bg-color);
  padding: 20px;
  box-sizing: border-box;
  transition: 0.6s;
  overflow: hidden;
  .menu-title {
    padding-bottom: 20px;
    box-sizing: border-box;
    border-bottom: 1px solid rgb(229, 233, 236);
    margin-bottom: 20px;
    .title-text {
      margin-left: 10px;
      font-family: "BasketBall";
      font-size: 30px;
      vertical-align: middle;
      opacity: 1;
      transition: 0.6s;
      color: var(--theme-info-text-color);
    }
    .icon-moonbyueliang {
      font-size: 30px;
      padding-left: 10px;
      color: rgb(103, 56, 223);
    }
  }
  .content {
    // text-align: center;
    .person-info {
      margin-top: 20px;
      white-space: nowrap;
      img {
        width: 50px;
        height: 50px;
        border-radius: 50%;
        border: 2px solid #fff;
        box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
        vertical-align: middle;
      }
      .person-name {
        margin-left: 15px;
        vertical-align: middle;
        opacity: 1;
        transition: 0.6s;
        overflow: hidden;
        color: var(--theme-info-text-color);
        display: inline-block;
        .name {
          font-size: 20px;
          font-weight: 600;
        }
        .detail {
          font-size: 12px;
        }
      }
    }
    .menu-content {
      margin-top: 20px;
      .menu-list {
        .menu-list-item {
          cursor: pointer;
          width: 100%;
          height: 50px;
          font-size: 18px;
          position: relative;
          border-radius: 10px;
          padding-left: 10px;
          white-space: nowrap;
          .block {
            width: 6px;
            height: 25px;
            background: rgb(101, 57, 225);
            position: absolute;
            right: -10px;
            top: 13px;
            transition: 0.5s;
            border-top-left-radius: 4px;
            border-bottom-left-radius: 4px;
            opacity: 0;
          }
          .item-name {
            line-height: 50px;
            display: inline-block;
            margin-left: 10px;
            font-size: 18px;
            color: var(--theme-text-color);
            font-weight: 100;
            transition: 0.6s;
            opacity: 1;
            .logout-a {
              text-decoration: none;
              color: var(--theme-text-color);
            }
          }
          &:hover {
            background-color: var(--theme-hover-menu-color);
            .item-name {
              color: var(--theme-hover-color);
            }
            .iconfont {
              color: var(--theme-hover-color);
            }
            .block {
              opacity: 1;
            }
          }
          .btn {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            display: inline-block;
            opacity: 1;
            margin-left: 10px;
            .check-ipt {
              display: none;
            }
            .check-lable {
              display: inline-block;
              width: 40px;
              height: 20px;
              border-radius: 20px;
              background: rgb(101, 58, 223);
              /* border: 1px solid #eee; */
              cursor: pointer;
              position: relative;
              overflow: hidden;
            }
            .check-lable::before {
              display: inline-block;
              content: "";
              width: 15px;
              height: 15px;
              border-radius: 50%;
              background: white;
              position: absolute;
              left: 3px;
              top: 50%;
              transform: translateY(-50%);
              transition: all 0.3s;
            }

            .check-ipt:checked + .check-lable::before {
              left: 20px;
              background: rgb(32, 30, 43);
            }
            .check-ipt:checked + .check-lable::after {
              width: 100%;
            }
          }
        }
        .bottom-item {
          margin-top: 30vh;
        }
      }
    }
  }
}
</style>