# 公式识别

## 项目介绍

使用Simpletex接口，支持上传图片与粘贴图片对图片进行公式识别。

本项目在线体验：[Duu公式识别](http://114.115.168.139/)

> [SimpleTex主页](https://simpletex.cn/)

## 快速开始

将application.yml中`appId`和`appSercet`设置替换为自己账号申请的应用

```yml
simpletex:
  appId : 
  appSecret: 
  token: 
```

## 界面说明

可使用resource中的公式图片进行测试，将LaTeX格式的识别结果直接复制到MathType或其他编辑器中即可渲染。

![image-20240123195021913](https://cdn.jsdelivr.net/gh/0oHo0/Picture@main/img/202401231950959.png)

## 项目结构

该项目纯前端即可实现，本人不太会前端，如有需要自行修改、扩展

- Duu-formula_recognition  后端 用来加密请求接口
- Duu-formula-front  前端 vite+vue3