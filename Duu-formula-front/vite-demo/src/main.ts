import { createApp } from 'vue'
import './style.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'


// 使用路由
const app = createApp(App)
app.use(ElementPlus)
app.mount('#app')