<template>
  <h1>公式识别：</h1>
  <div class="block text-center" @paste="handleImagePaste">
    <el-card >
      <div class="el-upload__text">
        <h3>点击此处直接粘贴图片(Ctrl+V)</h3>
      </div>
    </el-card>
  </div>
<div>
  <el-upload
      multiple
      class="upload-demo"
      :drag=true
      :http-request="ImgUploadSectionFile"
      @paste.prevent="handleImagePaste"
  >
    <el-icon class="el-icon--upload"><upload-filled /></el-icon>
    <div class="el-upload__text">
      拖拽上传<em>或</em>本地文件上传
    </div>
    <template #tip>
      <div class="el-upload__tip">
        jpg/png files with a size less than 500kb
      </div>
    </template>
  </el-upload>
</div>
  <h1>识别结果：</h1>
  <div>
      <el-input
          v-model="textarea1"
          :rows="2"
          type="textarea"
          placeholder="识别后的公式在此，直接粘贴在MathType中"
      />
  </div>
  <h1>识别结果渲染后：</h1>
<div class="answer">
  <mathJax :latex="textarea1"></mathJax>
</div>
<!--    <vue-markdown :source="markdown"></vue-markdown>-->
<!--    <textarea v-model="markdown"></textarea>-->
<!--    <div v-html="markdownToHtml"></div>-->
<!--    <Formula :value="markdown"></Formula>-->
<!--    <n-input type="textarea" v-model:value="value" @input="change"/>-->
<!--    <div v-html="markdownToHtml" className="markdown-body"></div>-->
</template>

<script setup lang="ts">
import {nextTick, onMounted, ref, shallowRef, watchEffect} from 'vue'
import { UploadFilled } from '@element-plus/icons-vue'
import myAxios from "../plugins/myAxios.ts";
import mathJax from "./Formula.vue"
import {marked} from 'marked';


const onError = ()=>{
}
const dialogVisible = ref(false)
const showDialog=()=> {
  dialogVisible.value=true
}

const textarea1 = ref('')

let ImgUploadSectionFile;
ImgUploadSectionFile = async (file) => {
  let formData = new FormData();//formdata格式
  formData.append('file', file.file);
  const res = await myAxios.post('/formula/do', formData,{
    headers: {
      "content-type": "multipart/form-data",
    },
  })
  textarea1.value=res;
}

const handleImagePaste=async (event) => {
  const files = event.clipboardData.files[0];
  if (!files) {
    alert("请复制图片再粘贴！");
    return;
  }
  let timeStamp = new Date().getTime();
  // 通过ref获取el-upload中的列表，往里面push粘贴的图片，uid是时间戳，需要自己获取
  files.uid = timeStamp;
  let formData = new FormData();//formdata格式
  formData.append('file', files);
  const res = await myAxios.post('/formula/do', formData, {
    headers: {
      "content-type": "multipart/form-data",
    },
  })
  textarea1.value = res;
}
// const render = new marked.Renderer()
// marked.setOptions({
//   renderer: render, // 这是必填项
//   // gfm: true,	// 启动类似于Github样式的Markdown语法
//   // pedantic: false, // 只解析符合Markdwon定义的，不修正Markdown的错误
//   // sanitize: false, // 原始输出，忽略HTML标签（关闭后，可直接渲染HTML标签）// 高亮的语法规范
//   // highlight: (code, lang) => hljs.highlight(code, { language: lang }).value,
// })
// const value = ref('$$ c_1 $$')
// const markdownToHtml = shallowRef("")
// markdownToHtml.value = marked(value.value)
// const change = (value: string) => {
//   markdownToHtml.value = marked(value)
// }
// MathJax.MathQueue("math")

</script>
<style>

</style>

