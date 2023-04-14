import { createApp } from "vue";
import router from "./router";
import "./base-style.css";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import * as ElementPlusIconsVue from "@element-plus/icons-vue";
import store from "./store";
import App from "./App.vue";
import "./api/mock";

const app = createApp(App);

app.use(ElementPlus);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}
app.use(router).use(store);
app.mount("#app");

// 调节亮度信息的功能
// 展示区域亮度信息的功能
