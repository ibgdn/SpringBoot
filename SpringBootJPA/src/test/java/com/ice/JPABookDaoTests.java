package com.ice;

import com.ice.bean.Book;
import com.ice.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * 7.Spring Boot 整合 Spring Data Jpa
 */
@SpringBootTest
public class JPABookDaoTests {
    @Autowired
    BookDao bookDao;

    @Test
    void save() {
        Book book = new Book();
        book.setName("鸟哥的私房菜");
        book.setAuthor("鸟哥");
        bookDao.save(book);
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(1);
        book.setName("niao");
        book.setAuthor("sifang");
        bookDao.saveAndFlush(book);
    }

    @Test
    void delete() {
        bookDao.deleteById(1);
    }

    @Test
    void findById() {
        Optional<Book> bookDaoById = bookDao.findById(2);
        System.out.println("Optional<Book>: " + bookDaoById);
        System.out.println("Optional<Book> get(): " + bookDaoById.get());
        List<Book> bookDaoAll = bookDao.findAll();
        System.out.println("List<Book>: " + bookDaoAll);
    }

    @Test
    void findBySort() {
/*
        // 排序查询出错，暂时没有解决办法
        List<Book> bookDaoAll = bookDao.findAll(new Sort(Sort.Direction.DESC, "id"));
        System.out.println("List<Book>: " + bookDaoAll);
*/
    }

    @Test
    void findByPage() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Book> bookPage = bookDao.findAll(pageable);
        System.out.println("总记录数：" + bookPage.getTotalElements());
        System.out.println("当前页记录数： " + bookPage.getNumberOfElements());
        System.out.println("每页记录数： " + bookPage.getSize());
        System.out.println("分页总页数： " + bookPage.getTotalPages());
        System.out.println("获取查询结果： " + bookPage.getContent());
        System.out.println("当前页数（从0开始）： " + bookPage.getNumber());
        System.out.println("是否为首页： " + bookPage.isFirst());
        System.out.println("是否为尾页： " + bookPage.isLast());
    }
}
