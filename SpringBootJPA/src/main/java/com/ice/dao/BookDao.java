package com.ice.dao;

import com.ice.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    // 自定义插入数据1
    @Query(value = "insert into table_book (name, author) value (?1,?2)", nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBook1(String name, String author);

    // 自定义插入数据2
    @Query(value = "insert into table_book (name, author) value (:name, :author)", nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBook2(@Param("author") String author, @Param("name") String name);
}
