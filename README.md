# SpringBoot





- ## xmlssm

采用 *.xml 文件配置的 maven web 项目。

启动项目查看效果访问地址： `ip:port/hello` 。



- ## annotationssm

采用注解配置的 maven web 项目。

启动项目查看效果访问地址： `ip:port/hello` 

查看静态页面资源效果访问地址：`ip:port/static/hello.html`

拦截器访问同上地址，即可在控制台看到输出：

```
preHandle
postHandle
afterCompletion
```

测试 json 数据访问地址：`ip:port/jsonData`

输出如下内容

```
// 20200423221047
// http://localhost:8080/jsonData`

[
  "for i >>> 0",
  "for i >>> 1",
  "for i >>> 2",
  "for i >>> 3",
  "for i >>> 4"
]
```



- ## SpringBootDemo

SpringBoot 示例项目 版本2.2.6。

整合 freemarker、thymeleaf、jsp 的示例项目。

启动项目查看效果访问地址： `ip:port/hello` 

在 src\main\resources\banner.txt 文件中修改字符，即可配置自定义 banner。

整合 freemarker 视图访问地址：`ip:port/dev/user`



- ## SpringBootWeb

SpringBoot 示例项目 版本2.2.6。

整合 web 开发技术的示例项目。

JSON 时间格式，关键配置文件 `JSONWebConfig.java`访问地址：`ip:port/JSONUser`

GSON 时间格式，关键配置文件 `GSONWebConfig.java`访问地址：`ip:port/JSONUser`

FastJSON 时间格式，关键配置文件 `FastJSONWebConfig.java`访问地址：`ip:port/JSONUser`

静态资源访问地址：`ip:port/static.js`

文件上传访问地址：`ip:port/upload.html`

Ajax 文件上传访问地址：`ip:port/upload_ajax.html`

多文件上传访问地址：`ip:port/upload_mult.html`

ControllerAdvice 定制全局异常（添加上传文件大小限制）：`ip:port/upload.html`

CORS 访问地址：`ip:port/CORS.html`