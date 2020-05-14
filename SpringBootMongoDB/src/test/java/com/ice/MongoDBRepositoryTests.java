package com.ice;

import com.ice.mongodb.bean.Book;
import com.ice.mongodb.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 8.Spring Boot 整合 MongoDB
 */
@SpringBootTest
public class MongoDBRepositoryTests {

    @Autowired
    BookDao bookDao;

    @Test
    void insert() {
        Book book = new Book();
        book.setId(1);
        book.setName("Java 核心技术");
        book.setAuthor("CSH");
        bookDao.insert(book);
    }

    @Test
    void select() {
        List<Book> all = bookDao.findAll();
        System.out.println(all);

        List<Book> java = bookDao.findBookByNameContaining("Java");
        System.out.println(java);
    }
}
