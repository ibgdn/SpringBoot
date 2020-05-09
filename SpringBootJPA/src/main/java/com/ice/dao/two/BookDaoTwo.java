package com.ice.dao.two;

import com.ice.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 11.Spring Boot 整合 Jpa 多数据源
 */
public interface BookDaoTwo extends JpaRepository<Book, Integer> {
}
