package com.ice.springbootdemo.thymeleaf.controller;

import com.ice.springbootdemo.thymeleaf.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * thymeleaf 控制层
 */
@Controller
public class BookController {
    @GetMapping("/thymeleaf")
    public String book(Model model) {
        ArrayList<Book> books = new ArrayList<>();
        Book book;
        for (int i = 0; i < 4; i++) {
            book = new Book();
            book.setId(i);
            book.setName("bookName " + i);
            book.setName("bookAuthor " + i);
            book.setPrice(Double.valueOf(i / 3));
            books.add(book);
        }
        model.addAttribute("books", books);
        return "book";
    }
}
