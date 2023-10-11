import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'
const app =  createApp(App)
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

// 全局注册axios
app.config.globalProperties.$axios = axios
// 启用element-plus
app.use(ElementPlus)
app.mount('#app')