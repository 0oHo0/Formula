<!--<template>-->
<!--  <n-input type="textarea" v-model:value="value" @input="change"/>-->
<!--  <div v-html="markdownToHtml" className="markdown-body"></div>-->
<!--</template>-->
<!--<script lang="ts" setup>-->
<!--import {marked} from 'marked';-->
<!--import {ref, shallowRef} from 'vue';-->
<!--import hljs from 'highlight.js'-->
<!--import 'highlight.js/styles/foundation.css'-->

<!--const render = new marked.Renderer()-->
<!--marked.setOptions({-->
<!--  renderer: render, // 这是必填项gfm: true,	// 启动类似于Github样式的Markdown语法pedantic: false, // 只解析符合Markdwon定义的，不修正Markdown的错误sanitize: false, // 原始输出，忽略HTML标签（关闭后，可直接渲染HTML标签）// 高亮的语法规范highlight: (code, lang) => hljs.highlight(code, { language: lang }).value,-->
<!--})-->
<!--const markdowntext = defineProps(['$C_1$'])-->
<!--const value = ref('**Hello,World**')-->
<!--const markdownToHtml = shallowRef("")-->
<!--markdownToHtml.value = marked(value.value)-->
<!--const change = (value: string) => {-->
<!--  markdownToHtml.value = marked(value)-->
<!--}</script>-->
<!--<style>-->
<!--</style>-->