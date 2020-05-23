package com.ice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringBootSecurityDynamicApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 10; i++) {
            System.out.println(bCryptPasswordEncoder.encode("123"));
            ;
        }
    }

}
