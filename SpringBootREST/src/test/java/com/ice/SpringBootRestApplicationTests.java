package com.ice;

import com.ice.jparest.bean.Book;
import com.ice.jparest.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootRestApplicationTests {
	@Autowired
	BookDao bookDao;

	@Test
	void contextLoads() {
		List<Book> all = bookDao.findAll();
		System.out.println(all);
	}

}
