package com.ice.dao;

import com.ice.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 7.Spring Boot 整合 Spring Data Jpa
 */
public interface BookDao extends JpaRepository<Book, Integer> {
}
