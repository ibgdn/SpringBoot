package com.ice;

import com.ice.xml.XmlBeanController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootWebApplicationTests {
    @Autowired
    XmlBeanController xmlBeanController;

    @Test
    void contextLoads() {
        System.out.println(xmlBeanController.xmlBean());
    }
}
