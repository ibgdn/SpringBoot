package com.ice.swagger2.controller;

import com.ice.swagger2.bean.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 10.Spring Boot 整合 Swagger2
 */
@RestController
// 添加 controller 接口描述
@Api(tags = "用户数据接口, controller 描述")
public class UserController {

    @ApiOperation(value = "查询用户, method 描述", notes = "根据用户 id 查询用户，详细描述")
    // required = true， Swagger2 参数必填
    @ApiImplicitParam(name = "id", value = "用户 id，请求参数描述", required = true, defaultValue = "1")
    // 不展示当前接口
//    @ApiIgnore
    @GetMapping("/user")
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @ApiOperation(value = "删除用户，method 描述", notes = "根据用户 id 删除用户，详细描述")
    @ApiImplicitParam(name = "id", value = "用户 id，请求参数描述", required = true, defaultValue = "2")
    // 添加自定义返回码及信息
    @ApiResponses({
            @ApiResponse(code = 700, message = "自定义状态码700"),
            @ApiResponse(code = 800, message = "自定义状态码800")
    })
    @DeleteMapping("/user/{id}")
    public void deleteUserById(Integer id) {
        System.out.println("deleteUserById() " + id);
    }

    @ApiOperation(value = "更新用户信息，method 描述", notes = "根据用户 id 更新用户姓名，详细描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户 id，请求参数描述", required = true, defaultValue = "3"),
            @ApiImplicitParam(name = "username", value = "用户姓名，请求参数描述", required = true, defaultValue = "username")
    })
    @PutMapping("/user")
    public User updateUsernameById(Integer id, String username) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    @ApiOperation(value = "添加用户信息，method 描述", notes = "Post 请求添加用户信息，详细描述")
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return user;
    }
}
