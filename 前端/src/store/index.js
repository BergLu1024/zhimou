//数据传输配置使用vuex 状态管理

import { createStore } from "vuex";

export default createStore({
  state: {
    isCollapse: true,
  },
  mutations: {
    updateIsCollapse(state, payload) {
      state.isCollapse = !state.isCollapse;
    },
  },
});
