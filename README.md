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

在 `src\main\resources\banner.txt` 文件中修改字符，即可配置自定义 banner。

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

加载 XML 配置文件单元测试方法：`com.ice.SpringBootWebApplicationTests#contextLoads`

注册拦截器访问地址：`ip:port/getGlobalData`

整合 Web 基础组件（Servlet、Filter、Listener）访问地址：`ip:port/customServlet`

路径映射访问地址：`ip:port/pathMapping` 和`ip:port/pathMapping1`

类型转换访问地址：`ip:port/parameterConverter?birth=2020-2-3`

AOP 访问地址：`ip:port/aopGet`



- ## SpringBootWeb

JdbcTemplate 

单一数据源测试类：`SpringBootDatabase/src/test/java/com/ice/JdbcTemplateOneDataSource.java`

多数据源测试类：`SpringBootDatabase/src/test/java/com/ice/JdbcTemplateMoreDataSource.java`



- ## SpringBootMybatis

mybatis

单一数据源测试类：`SpringBootDatabase/src/test/java/com/ice/SpringBootDatabaseApplicationTests.java`

多数据源测试类：`SpringBootMybatis/src/test/java/com/ice/MybatisMoreDataSource.java`



- ## SpringBootJPA

JPA

单一数据源测试类：`SpringBootJPA/src/test/java/com/ice/JPABookDaoTests.java`、`JPAKeyWordTest.java `、`JPACustomTest.java`、`JPACustomTest.java`

多数据源测试类：`SpringBootMybatis/src/test/java/com/ice/MybatisMoreDataSource.java`



- ## SpringBootRedis

Redis

访问地址：`ip:port/setRedis`、`ip:port/getRedis`

Nginx

访问地址：`ip:port/setSession`、`ip:port/getSession`

MongoDB

测试类：`MongoDBRepositoryTests.java`、`MongoDBTemplateTests.java`

