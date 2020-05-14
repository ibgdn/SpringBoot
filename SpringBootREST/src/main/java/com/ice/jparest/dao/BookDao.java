package com.ice.jparest.dao;

import com.ice.jparest.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 2.搭建 Jpa 环境
 */
public interface BookDao extends JpaRepository<Book, Integer> {
}
