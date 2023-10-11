<template>
  <div class="outside" v-if="zodiac1">
    <div class="grid-container">
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac4.stars" :key="index">
            {{ item.starName }}
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac4.flowYear
                }}</span>
                <br />
                {{ zodiac4.name  }}{{zodiac4.gongStatusName==null?"":zodiac4.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac4.gan }} </span></el-col
            >
          </el-row>
        </div></el-card
      >
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac5.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac5.flowYear
                }}</span>
                <br />
                {{ zodiac5.name }}{{zodiac5.gongStatusName==null?"":zodiac5.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac5.gan }} </span></el-col
            >
          </el-row>
        </div>
      </el-card>
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac6.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac6.flowYear
                }}</span>
                <br />
                {{ zodiac6.name  }}{{zodiac6.gongStatusName==null?"":zodiac6.gongStatusName}}
              </span>
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac6.gan }} </span></el-col
            >
          </el-row>
        </div>
      </el-card>
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac7.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac7.flowYear
                }}</span>
                <br />
                {{ zodiac7.name }}
                {{zodiac7.gongStatusName==null?"":zodiac7.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac7.gan }} </span></el-col
            >
          </el-row>
        </div>
      </el-card>
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac3.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac3.flowYear
                }}</span>
                <br />
                {{ zodiac3.name }}
                {{zodiac3.gongStatusName==null?"":zodiac3.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac3.gan }} </span></el-col
            >
          </el-row>
        </div>
      </el-card>
      <div class="grid-item-blank">
        <el-config-provider :locale="locale">
          <el-date-picker
            value-format="YYYY-MM-DD HH:mm:ss"
            style="margin-right: -30px"
            v-model="birthForm.birth"
            type="datetime"
            :locale="locale"
            placeholder="选择生日"
          />
        </el-config-provider>
      </div>
      <div class="grid-item-blank">
        <el-radio-group style="margin-left: -40px;" v-model="birthForm.gender">
          <el-radio :label="1">男</el-radio>
          <el-radio :label="2">女</el-radio>
        </el-radio-group>
          &nbsp;&nbsp;
        <el-button style="margin-right: -40px;" @click="initStarDivination()">排盘</el-button>
      </div>
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac8.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac8.flowYear
                }}</span>
                <br />
                {{ zodiac8.name  }}{{zodiac8.gongStatusName==null?"":zodiac8.gongStatusName}}
             
              </span>
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac8.gan }} </span></el-col
            >
          </el-row>
        </div>
      </el-card>
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac2.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac2.flowYear
                }}</span>
                <br />
                {{ zodiac2.name  }}
                {{zodiac2.gongStatusName==null?"":zodiac2.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac2.gan }} </span></el-col
            >
          </el-row>
        </div>
      </el-card>
      <div class="grid-item-blank"></div>
      <div class="grid-item-blank"></div>
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac9.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac9.flowYear
                }}</span>
                <br />
                {{ zodiac9.name }}
                {{zodiac9.gongStatusName==null?"":zodiac9.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac9.gan }} </span></el-col
            >
          </el-row>
        </div>
      </el-card>
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac1.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac1.flowYear
                }}</span>
                <br />
                {{ zodiac1.name  }}
                {{zodiac1.gongStatusName==null?"":zodiac1.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac1.gan }} </span></el-col
            >
          </el-row>
        </div>
      </el-card>
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac12.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac12.flowYear
                }}</span>
                <br />
                {{ zodiac12.name  }}
                {{zodiac12.gongStatusName==null?"":zodiac12.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac12.gan }} </span></el-col
            >
          </el-row>
        </div></el-card
      >
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac11.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac11.flowYear
                }}</span>
                <br />
                {{ zodiac11.name  }}{{zodiac11.gongStatusName==null?"":zodiac11.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac11.gan }} </span></el-col
            >
          </el-row>
        </div></el-card
      >
      <el-card class="grid-item">
        <div class="child">
          <el-tag v-for="(item, index) in zodiac10.stars" :key="index">
            {{ item.starName + " " }}
            <span
              style="background-color: red; color: gold; border-radius: 49%"
              >{{ getSiHua(item.qiStatus) }}</span
            >
          </el-tag>
        </div>
        <div class="child1">
          <el-row>
            <el-col :span="8"> </el-col>
            <el-col :span="8">
              <span class="bottom_gong">
                <span style="margin-left: 4px; font-size: 14px">{{
                  zodiac10.flowYear
                }}</span>
                <br />
                {{ zodiac10.name }}
                {{zodiac10.gongStatusName==null?"":zodiac10.gongStatusName}}</span
              >
            </el-col>
            <el-col :span="8">
              <span class="bottom_gan"> {{ zodiac10.gan }} </span></el-col
            >
          </el-row>
        </div></el-card
      >
    </div>
  </div>
</template>

<script setup lang="ts">
import zhCn from "element-plus/lib/locale/lang/zh-cn";
import { starDivination } from "@/api/ziwei/index";
import { zodiac } from "@/api/ziwei/type";
import type { jsonResult } from "@/api/common/type";
import { reactive, onMounted, nextTick } from "vue";
//import { defineComponent } from 'vue';

let locale = reactive<any>(zhCn);
let birthForm = reactive({ birth: "", gender: 1 });
let zodiac1 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac2 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac3 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac4 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac5 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac6 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac7 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac8 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac9 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac10 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac11 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});
let zodiac12 = reactive<zodiac>({
  id: 0,
  name: "",
  stars: [],
  flowYear: "",
  gan: "",
  gongStatusName: "",
});

// 排盘
const initStarDivination = async () => {
  const result: jsonResult | any = await starDivination(birthForm);
  if (result.status === "20000") {
    let template1 = result.data.find((item) => item.id === 1);
    let template2 = result.data.find((item) => item.id === 2);
    let template3 = result.data.find((item) => item.id === 3);
    let template4 = result.data.find((item) => item.id === 4);
    let template5 = result.data.find((item) => item.id === 5);
    let template6 = result.data.find((item) => item.id === 6);
    let template7 = result.data.find((item) => item.id === 7);
    let template8 = result.data.find((item) => item.id === 8);
    let template9 = result.data.find((item) => item.id === 9);
    let template10 = result.data.find((item) => item.id === 10);
    let template11 = result.data.find((item) => item.id === 11);
    let template12 = result.data.find((item) => item.id === 12);

    zodiac1.gan = template1.gan;
    //zodiac1.stars.splice(0, zodiac1.stars.length);
    zodiac1.stars = template1.stars;
    zodiac1.name = template1.name;
    zodiac1.flowYear = template1.flowYear;
    zodiac1.gongStatusName = template1.gongStatusName;

    zodiac2.gan = template2.gan;
    zodiac2.stars = template2.stars;
    zodiac2.name = template2.name;
    zodiac2.flowYear = template2.flowYear;
    zodiac2.gongStatusName = template2.gongStatusName;

    zodiac3.gan = template3.gan;
    zodiac3.stars = template3.stars;
    zodiac3.name = template3.name;
    zodiac3.flowYear = template3.flowYear;
    zodiac3.gongStatusName = template3.gongStatusName;

    zodiac4.gan = template4.gan;
    zodiac4.stars = template4.stars;
    zodiac4.name = template4.name;
    zodiac4.flowYear = template4.flowYear;
    zodiac4.gongStatusName = template4.gongStatusName;

    zodiac5.gan = template5.gan;
    zodiac5.stars = template5.stars;
    zodiac5.name = template5.name;
    zodiac5.flowYear = template5.flowYear;
    zodiac5.gongStatusName = template5.gongStatusName;

    zodiac6.gan = template6.gan;
    zodiac6.stars = template6.stars;
    zodiac6.name = template6.name;
    zodiac6.flowYear = template6.flowYear;
    zodiac6.gongStatusName = template6.gongStatusName;

    zodiac7.gan = template7.gan;
    zodiac7.stars = template7.stars;
    zodiac7.name = template7.name;
    zodiac7.flowYear = template7.flowYear;
    zodiac7.gongStatusName = template7.gongStatusName;

    zodiac8.gan = template8.gan;
    zodiac8.stars = template8.stars;
    zodiac8.name = template8.name;
    zodiac8.flowYear = template8.flowYear;
    zodiac8.gongStatusName = template8.gongStatusName;

    zodiac9.gan = template9.gan;
    zodiac9.stars = template9.stars;
    zodiac9.name = template9.name;
    zodiac9.flowYear = template9.flowYear;
    zodiac9.gongStatusName = template9.gongStatusName;

    zodiac10.gan = template10.gan;
    zodiac10.stars = template10.stars;
    zodiac10.name = template10.name;
    zodiac10.flowYear = template10.flowYear;
    zodiac10.gongStatusName = template10.gongStatusName;

    zodiac11.gan = template11.gan;
    zodiac11.stars = template11.stars;
    zodiac11.name = template11.name;
    zodiac11.flowYear = template11.flowYear;
    zodiac11.gongStatusName = template11.gongStatusName;

    zodiac12.gan = template12.gan;
    zodiac12.stars = template12.stars;
    zodiac12.name = template12.name;
    zodiac12.flowYear = template12.flowYear;
    zodiac12.gongStatusName = template12.gongStatusName;
  }
};

// 获取四化状态
const getSiHua = (status?: number) => {
  if (status === 1) {
    return "(禄)";
  }
  if (status === 2) {
    return "(权)";
  }
  if (status === 3) {
    return "(科)";
  }
  if (status === 4) {
    return "(忌)";
  }
  return "";
};

// 获取当前时间
const getCurrentFormatTime = ()=>{
  // 获取当前日期和时间
  var now = new Date();

  // 格式化日期和时间
  var year = now.getFullYear(); // 年份
  var month = (now.getMonth() + 1).toString().padStart(2, '0'); // 月份
  var day = now.getDate().toString().padStart(2, '0'); // 日份
  var hour = now.getHours().toString().padStart(2, '0'); // 小时
  var minute = now.getMinutes().toString().padStart(2, '0'); // 分钟
  var second = now.getSeconds().toString().padStart(2, '0'); // 秒数

  // 拼接成字符串
  var formattedDate = year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;

  return formattedDate;
}

//组件挂载完毕钩子---发一次请求,获取第一页、一页三个已有用户数据
onMounted(() => {
  // 初始化当前日期作为基础值填充
  birthForm.birth = getCurrentFormatTime();
  nextTick(() => {
    initStarDivination();
  });
});
</script>

<style>
.outside {
  width: 60%;
  margin: 0 auto;
}

.grid-container {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-template-rows: repeat(3, 1fr);
  gap: 10px;
}

.grid-item {
  display: flex;
  height: 160px;
  width: 220px;
  padding: 0px;
}
.child {
  height: 50%;
  width: 180px;
  flex: 1;
  align-self: stretch;
  position: relative;
}
.child1 {
  height: 60%;
  width: 180px;

  flex: 1;
  align-self: stretch;
  position: relative;
}
.bottom_text {
  position: absolute;
  left: 50px;
  bottom: -40px;
}
.bottom_gong {
  position: absolute;
  margin-left: 1px;
  bottom: -70px;
}
.bottom_gan {
  position: absolute;
  bottom: -70px;
  right: 0px;
}

.grid-item-blank {
  background-color: white;

  padding-top: 20px;
  text-align: center;
}

.el-tag {
  justify-content: center;
  align-items: center;
  width: 55px;
  margin: 2px;
}
</style>
