package com.ice;

import com.ice.bean.Book;
import com.ice.dao.one.BookDaoOne;
import com.ice.dao.two.BookDaoTwo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 11.Spring Boot 整合 Jpa 多数据源
 */
@SpringBootTest
public class JPAMoreDataSourceTests {
    @Autowired
    BookDaoOne bookDaoOne;

    @Autowired
    BookDaoTwo bookDaoTwo;

    @Test
    void contextLoads() {
        List<Book> allOne = bookDaoOne.findAll();
        System.out.println("allOne: " + allOne);
        List<Book> allTwo = bookDaoTwo.findAll();
        System.out.println("allTwo: " + allTwo);
    }
}
