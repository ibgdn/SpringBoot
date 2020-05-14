package com.ice.jparest.dao;

import com.ice.jparest.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * 2.搭建 Jpa 环境
 */
@RepositoryRestResource(path = "fbs", collectionResourceRel = "bs", itemResourceRel = "b")
public interface BookDao extends JpaRepository<Book, Integer> {
    @RestResource(path = "byName", rel = "findByName")
    List<Book> findBookByNameContaining(@Param("name") String name);
}
