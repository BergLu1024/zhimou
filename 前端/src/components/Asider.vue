<script>
import {useRouter} from 'vue-router'
export default {
  setup() {
    const list = [
      {
        label: "控制台",
        name: "controller",
        path: "/controller",
        icon: "Monitor",
      },
      {
        label: "用户管理",
        path: "/user",
        name: "user",
        icon: "user",
        url: "userManage/userManage",
      },
      {
        label: "其他",
        icon: "location",
        path: "/other",
        children: [
          {
            path: "/page1",
            name: "page1",
            label: "页面1",
            icon: "setting",
            url: "Other/pageOne",
          },
          {
            path: "page2",
            name: "page2",
            label: "页面2",
            icon: "setting",
            url: "Other/PageTwo",
          },
        ],
      },
    ];

    const router = useRouter()

    const noChildren = () => {
      return list.filter((item) => !item.children);
    };

    const hasChildren = () => {
      return list.filter((item) => item.children);
    };

    const clickMenu = (item) => {
      router.push({
        name: item.name,
      });
    };

    return {
      noChildren,
      hasChildren,
      clickMenu,
    };
  },
};
</script>

<template>
  <el-aside :width="$store.state.isCollapse ? '180px' : '64px'">
    <el-menu
      class="el-menu-vertical-demo"
      background-color="#545c64"
      text-color="#fff"
      :collapse="!$store.state.isCollapse"
      :collapse-transition="false"
    >
      <h3 v-show="$store.state.isCollapse">智眸管理系统</h3>
      <h3 v-show="!$store.state.isCollapse">智眸</h3>

      <el-menu-item
        :index="item.path"
        v-for="item in noChildren()"
        :key="item.path"
        @click="clickMenu(item)"
      >
        <el-icon><component class="icons" :is="item.icon"></component></el-icon>
        <span>{{ item.label }}</span>
      </el-menu-item>
      <el-sub-menu
        :index="item.label"
        v-for="item in hasChildren()"
        :key="item.path"
      >
        <template #title>
          <el-icon>
            <component class="icons" :is="item.icon"> </component>
          </el-icon>
          <span>{{ item.label }}</span>
        </template>
        <el-menu-item-group>
          <el-menu-item
            :index="subItem.path"
            v-for="(subItem, subIndex) in item.children"
            :key="subIndex"
            @click="clickMenu(subItem)"
            ><el-icon>
              <component class="icons" :is="subItem.icon"> </component>
            </el-icon>
            <span>{{ subItem.label }}</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-sub-menu>
    </el-menu>
  </el-aside>
</template>

<style scoped>
.icon {
  width: 18px;
  height: 18px;
}

.el-menu {
  border-right: none;
}

.el-aside {
  height: 100%;
  background-color: #545c64;
}

.el-menu h3 {
  line-height: 48px;
  color: #fff;
  text-align: center;
}
</style>
