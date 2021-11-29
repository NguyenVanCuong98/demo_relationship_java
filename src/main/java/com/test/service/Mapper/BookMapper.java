package com.test.service.Mapper;

import com.test.dto.AuthorDto;
import com.test.dto.BookDto;
import com.test.entity.Author;
import com.test.entity.Book;
import com.test.in.BookIn;

public class BookMapper {
    public static BookDto map(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setContent(book.getContent());
        bookDto.setAuthor(book.getAuthor());
        return bookDto;
    }
    public static Book map(BookIn bookIn){
        Book book = new Book();
        if (bookIn.getId() != null){
            book.setId(bookIn.getId());
        }
        book.setTitle(bookIn.getTitle());
        book.setContent(bookIn.getContent());
        if (bookIn.getAuthor() != null){
            book.setAuthor(bookIn.getAuthor());
        }
        return book;
    }
}
