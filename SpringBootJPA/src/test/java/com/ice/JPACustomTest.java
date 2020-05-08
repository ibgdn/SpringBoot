package com.ice;

import com.ice.bean.Book;
import com.ice.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 8.Spring Data Jpa 关键字定义查询方法
 */
@SpringBootTest
public class JPACustomTest {
    @Autowired
    BookDao bookDao;

    @Test
    void findBookByIdMax() {
        Book bookByIdMax = bookDao.findBookByIdMax();
        System.out.println(bookByIdMax);
    }
}
