package com.test.controller;

import com.test.dto.AuthorDto;
import com.test.dto.BookDto;
import com.test.dto.CardDto;
import com.test.entity.Book;
import com.test.entity.Card;
import com.test.in.BookIn;
import com.test.in.CardIn;
import com.test.service.AuthorService;
import com.test.service.BookService;
import com.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<BookDto>> getAll () {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }
//
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Book create(@RequestBody BookIn bookIn){
        return bookService.create(bookIn);
    }
//
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Book update(@PathVariable Integer id,@RequestBody BookIn bookIn) {
        return bookService.update(id,bookIn);
    }
//
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id){
        bookService.delete(id);
    }
}
