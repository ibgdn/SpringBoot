package com.ice;

import com.ice.dynamic.bean.Menu;
import com.ice.dynamic.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class SpringBootSecurityDynamicApplicationTests {

    @Autowired
    MenuService menuService;

    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 10; i++) {
            System.out.println(bCryptPasswordEncoder.encode("123"));
        }
    }

    @Test
    void menuServiceTest() {
        List<Menu> allMenus = menuService.getAllMenus();
        System.out.println(allMenus);
    }

}
