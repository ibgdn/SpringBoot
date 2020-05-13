package com.ice.mongodb.dao;

import com.ice.mongodb.bean.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 8.Spring Boot 整合 MongoDB
 */
public interface BookDao extends MongoRepository<Book, Integer> {
    List<Book> findBookByNameContaining(String name);
}
