package com.sujit.bookinfoservice.resources;

import com.sujit.bookinfoservice.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookInfoResource {

    @GetMapping("/{bookId}")
    public List<Book> getBookInfo(@PathVariable("bookId") String bookId) {
       List<Book> books = new ArrayList<>();
       books.add(new Book("java", "Java World"));
       return books;
    }
}
