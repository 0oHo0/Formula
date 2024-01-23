import module, { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
})

//
// export default {
//   dev: {
//     assetsSubDirectory: 'static',
//     assetsPublicPath: '/',
//     // proxyTable: {},
//     proxyTable: {
//       '/api': {
//         //以下接口胡编，项目中需要使用自己的
//         target: 'http://local:8108',  //这里配置的是 请求接口的域名
//         // secure: false, // 如果是https接口，需要配置这个参数
//         changeOrigin: true, // 如果接口跨域，需要进行这个参数配置
//         pathRewrite: {
//           '^/api': '' //路径重写，这里理解成用'/api'代替target里面的地址。
//         }
//       },
//     },
//   }
// };