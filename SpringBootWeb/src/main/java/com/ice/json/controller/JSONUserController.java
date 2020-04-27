package com.ice.json.controller;

import com.ice.json.bean.JSONUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1.Spring Boot默认的 JSON 解析方案控制层
 */
@RestController
public class JSONUserController {
    @GetMapping("/JSONUser")
    public List<JSONUser> getJSONUser() {
        List<JSONUser> users = new ArrayList<>();
        JSONUser user;
        for (int i = 0; i < 5; i++) {
            user = new JSONUser();
            user.setId(i);
            user.setUserName("JSONUserName " + i);
            user.setAddress("JSONUserAddress " + i);
            user.setBirthday(new Date());
            users.add(user);
        }
        return users;
    }

}
