package com.ice;

import com.ice.mongodb.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * 8.Spring Boot 整合 MongoDB
 */
@SpringBootTest
public class MongoDBTemplateTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void insert() {
        Book book = new Book();
        book.setId(2);
        book.setName("Java 核心思想");
        book.setAuthor("C");
        mongoTemplate.insert(book);
    }

    @Test
    void select() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }
}
