//路由的配置文件

import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("../views/Main.vue"),
    children: [
      {
        path: "/",
        name: "controller",
        component: () => import("../views/Controller/controller.vue"),
      },
      {
        path: "/user",
        name: "user",
        component: () => import("../views/User/user.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
