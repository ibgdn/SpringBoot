package com.ice.dao;

import com.ice.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 7.Spring Boot 整合 Spring Data Jpa
 */
public interface BookDao extends JpaRepository<Book, Integer> {
    // 通过 id 查询
    Book findBookById(Integer id);

    // 查询 id 大于某值的记录
    List<Book> findBookByIdGreaterThan(Integer id);

    // 查询 id 小于某值并包含关键字的记录
    List<Book> findBookByIdLessThanAndNameContains(Integer id, String name);

    // 查询 id 最大的记录
    @Query(value = "select * from table_book where id = (select max(id) from table_book)", nativeQuery = true)
    Book findBookByIdMax();
}
