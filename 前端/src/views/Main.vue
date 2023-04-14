<script>
import { defineComponent } from "vue";
import CommonHeader from "../components/Header.vue";
import CommonAside from "../components/Asider.vue";
export default defineComponent({
  components: {
    CommonHeader,
    CommonAside,
  },
});
</script>

<template>
  <el-container>
    <CommonAside />

    <div class="r-container">
      <el-header><CommonHeader /></el-header>

      <el-main><RouterView /> </el-main>
    </div>
  </el-container>
</template>

<style scoped>
.el-header {
  display: flex;
  justify-content: space-between;
  background-color: #333;
  align-items: center;
  width: 100%;
}
.el-container {
  height: 100%;
}

.r-container {
  width: 100%;
  height: 100%;
  flex-wrap: wrap;
}

.r-container .el-main {
  height: 90%;
}
</style>
