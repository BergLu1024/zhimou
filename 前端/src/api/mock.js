import mockjs, { mock } from "mockjs";
import homeApi from "./mockData/controller";
//拦截请求
mockjs.mock("/home/getData", homeApi.getHomeData);
