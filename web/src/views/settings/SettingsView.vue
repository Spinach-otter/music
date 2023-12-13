<template>
  <div class="home">
    <div class="side-bar"><NavBar></NavBar></div>

    <div class="bg">
      <div class="nav-setting">
        <div class="set-normal">
          <router-link :to="{ name: 'settings' }" class="link"
            >信息</router-link
          >
        </div>
        <div class="set-pwd">
          <router-link :to="{ name: 'setting_pwd' }" class="link"
            >密码</router-link
          >
        </div>
      </div>
      <div class="put">
        <div class="container mt-3">
          <div class="mb-3 mt-3">
            <label class="form-label">头像:</label>
            <img :src="$store.state.user.avatar" class="avatar" />
            <input type="file" />
          </div>
          <br />
          <div class="mb-3 mt-3">
            <label for="username" class="form-label">用户名:</label>
            <input
              v-model="userupdate.username"
              type="text"
              class="form-control"
              id="username"
              placeholder="输入用户名"
              name="username"
            />
          </div>
          <br />
          <div class="error_msg">{{ userupdate.error_message }}</div>
          <button
            @click="update_info"
            type="submit"
            class="btn btn-dark form-control"
          >
            Submit
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";
import { reactive } from "vue";
import $ from "jquery";
import { useStore } from "vuex";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap";
import { useRouter } from "vue-router";

export default {
  components: {
    NavBar,
  },
  setup() {
    const router = useRouter();
    const store = useStore();
    // 定义一个userupdate对象
    const userupdate = reactive({
      username: "",
      major: "",
      fullname: "",
      phone: "",
      sex: "",
      error_message: "",
    });

    //定义函数
    const update_info = () => {
      userupdate.error_message = "";
      $.ajax({
        url: "http://localhost:8080/setting/info/",
        type: "post",
        data: {
          username: userupdate.username,
        },
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        },
        success(resp) {
          if (resp.error_message === "success") {
            (userupdate.username = ""), alert("修改成功");
            router.go(0);
          } else {
            userupdate.error_message = resp.error_message;
          }
        },
      });
    };

    return {
      userupdate,
      update_info,
    };
  },
};
</script>

<style scoped>
@import url(@/assets/themecss/theme.scss);
.right {
  width: 1130px;
  height: 688px;
  float: right;
  margin-top: 5%;
  margin-right: 5%;
  border-radius: 10px;
  background-color: rgba(248, 249, 250, 0.8);
  /* background-color: #f8f9fa; */
  /* opacity: 0.8; */
}
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
.bg {
  width: 60%;
  height: 80%;
  margin-top: 5%;
  margin-left: 10%;
  background-color: var(--bg-color);
  box-shadow: 0 8px 16px #0005;
  border-radius: 16px;
}
.nav-setting {
  display: flex;
  margin-left: 38%;
  margin-top: 5%;
  width: 30%;
  height: 8%;
  background-color: rgb(87, 96, 105);
  border-radius: 10px;
}
.nav-setting .set-normal {
  display: flex;
  justify-content: center;
  align-items: center; /* 垂直居中 */
  width: 50%;
  height: 100%;
  background-color: rgb(173, 195, 192);
  border-radius: 10px;
}
.nav-setting .set-pwd {
  display: flex;
  justify-content: center;
  align-items: center; /* 垂直居中 */
  width: 50%;
  height: 100%;
  /* float: right; */
}
.link {
  color: black;
  font-size: 18px;
  text-decoration: none;
}
label {
  transition: 0.6s;
  color: var(--theme-info-text-color);
}
.put {
  margin-top: 5%;
}

.avatar {
  margin-left: 1vw;
  margin-right: 3vw;
  width: 100px;
  height: 100px;
}

.form-check {
  display: inline-block;
  margin-right: 10px; /* 可以根据需要调整间距 */
}

.error_msg {
  color: red;
}
</style>