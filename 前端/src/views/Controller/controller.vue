<script>
import { ref, onMounted } from "vue";
import axios from "axios";
export default {
  setup() {
    const getImgSrc = (img) => {
      return new URL(`../../assets/images/${img}.jpg`, import.meta.url).href;
    };

    let tableData = ref([]);

    const tableLabel = {
      name: "区域名",
      totaBr: "总光",
      ledBr: "灯光",
      outBr: "室外光",
      desirBr: "期望光强",
    };

    const deviceLabel = {
      name: "设备名",
      label: "标号",
      location: "坐标",
      usedTime: "使用时间",
    };

    const deviceData = [
      {
        name: "led01",
        label: "#0001",
        location: [7, 9],
        usedTime: 120,
      },
      {
        name: "led02",
        label: "#0003",
        location: [3, 4],
        usedTime: 120,
      },
      {
        name: "led03",
        label: "#0003",
        location: [20, 240],
        usedTime: 120,
      },
      {
        name: "led04",
        label: "#0004",
        location: [10, 120],
        usedTime: 120,
      },
      {
        name: "led04",
        label: "#0004",
        location: [10, 120],
        usedTime: 120,
      },
      {
        name: "led04",
        label: "#0004",
        location: [10, 120],
        usedTime: 120,
      },
      {
        name: "led04",
        label: "#0004",
        location: [10, 120],
        usedTime: 120,
      },
    ];
    let LocaData = ref({
      name: "无区域",
      totaBr: 0,
      ledBr: 0,
      outBr: 0,
      desirBr: 0,
    });

    const hanldeselct = (index) => {
      // console.log(index);
      LocaData.value = tableData.value[index];
      // console.log(LocaData);
    };

    const getTableList = async () => {
      await axios.get("/home/getData").then((res) => {
        // console.log(res.data.data);
        tableData.value = res.data.data.tableData;
        LocaData.value = tableData.value[0];
      });
    };

    onMounted(() => {
      getTableList();
    });

    return {
      tableData,
      tableLabel,
      LocaData,
      deviceData,
      deviceLabel,
      getImgSrc,
      hanldeselct,
    };
  },
};
</script>

<template>
  <el-scrollbar>
    <el-row :gutter="20">
      <el-col :span="15">
        <el-card class="locaImg">
          <div class="cardHeader">
            <span>区域划分</span>
            <el-button class="button" text>按钮</el-button>
          </div>
          <img :src="getImgSrc('show')" class="image" />
        </el-card>
      </el-col>
      <el-col :span="9">
        <el-card shadow="hover" class="locaInfo">
          <div class="cardHeader">
            <span>详细信息</span>
            <el-button class="button" text>按钮</el-button>
          </div>
          <el-row>
            <el-text size="large">区域:</el-text>
            <el-text class="location" size="large" type="primary" tag="b">
              {{ LocaData.name }}
            </el-text>
          </el-row>
          <el-divider />
          <el-row>
            <el-text>该区域总亮度：</el-text>
            <el-text class="totalBright">
              {{ LocaData.totaBr }}
            </el-text>
          </el-row>
          <el-row>
            <el-text>该区域LED灯亮度：</el-text>
            <el-text class="ledBright">
              {{ LocaData.ledBr }}
            </el-text>
          </el-row>
          <el-row>
            <el-text>当前室外光照亮度：</el-text>
            <el-text class="outBright">
              {{ LocaData.outBr }}
            </el-text>
          </el-row>
          <el-divider />
          <el-row>
            <el-text>
              该区域期望亮度:
              {{ LocaData.desirBr }}
            </el-text>
          </el-row>
          <el-row>
            <el-slider v-model="LocaData.desirBr" />
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="14">
        <el-card shadow="hover" style="margin-top: 20px" height="450px">
          <div class="cardHeader">
            <span>区域选择</span>
            <el-button class="button" text>按钮</el-button>
          </div>
          <el-table :data="tableData" style="width: 100%">
            <el-table-column
              v-for="(val, key) in tableLabel"
              :key="key"
              :prop="key"
              :label="val"
            >
            </el-table-column>
            <el-table-column align="right" label="选择">
              <template #default="scope">
                <el-button
                  size="small"
                  @click="hanldeselct(scope.$index, LocaData)"
                >
                  选择
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
      <el-col :span="10">
        <el-card style="margin-top: 20px" height="450px">
          <div class="cardHeader">
            <span>设备信息</span>
            <el-button class="button" text>按钮</el-button>
          </div>
          <el-table :data="deviceData" style="width: 100%">
            <el-table-column
              v-for="(val, key) in deviceLabel"
              :key="key"
              :prop="key"
              :label="val"
            >
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>
  </el-scrollbar>
</template>

<style scoped>
.el-row {
  width: 100%;
}
.cardHeader {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-bottom: 10px;
}

.locaImg {
  height: 560px;
}
.locaInfo {
  height: 560px;
}

.car .image {
  width: 100%;
  display: block;
}

.el-text {
  padding: 10px;
}
</style>
