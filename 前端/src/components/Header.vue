<script>
import { useStore } from "vuex";
export default {
  setup() {
    let store = useStore();
    const getImgSrc = (user) => {
      return new URL(`../assets/images/${user}.png`, import.meta.url).href;
      // 图片实时返回
    };

    let handleCollapse = () => {
      //调用vuex中的mutations
      store.commit("updateIsCollapse");
    };
    return {
      getImgSrc,
      handleCollapse,
    };
  },
};
</script>

<template>
    <div class="l-content">
      <el-button size="small" plain @click="handleCollapse">
        <el-icon :size="20">
          <Menu />
        </el-icon>
      </el-button>
      <h3>首页</h3>
    </div>
    <div class="r-content">
      <el-dropdown>
        <span class="el-dropdown-link">
          <img class="user" :src="getImgSrc('01')" alt="user" />
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人中心</el-dropdown-item>
            <el-dropdown-item>退出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
</template>

<style scoped>

.l-content button {
  margin-right: 20px;
}
.l-content {
  display: flex;
  align-items: center;
}

.l-content h3 {
  color: #fff;
}
.r-content .user {
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
</style>
