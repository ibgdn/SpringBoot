package com.ice;

import com.ice.bean.Book;
import com.ice.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 8.Spring Data Jpa 关键字定义查询方法
 */
@SpringBootTest
public class JPAKeyWordTest {
    @Autowired
    BookDao bookDao;
    @Test
    void findBookById() {
        Book bookById = bookDao.findBookById(3);
        System.out.println(bookById);
    }

    @Test
    void findBookByIds() {
        List<Book> bookByIdGreaterThan = bookDao.findBookByIdGreaterThan(3);
        System.out.println("bookByIdGreaterThan: " + bookByIdGreaterThan);
        List<Book> bookByIdLessThanAndNameContains = bookDao.findBookByIdLessThanAndNameContains(10, "C");
        System.out.println("bookByIdLessThanAndNameContains: " + bookByIdLessThanAndNameContains);
    }
}
