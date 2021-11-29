package com.test.service;


import com.test.dto.BookDto;
import com.test.entity.Book;
import com.test.in.BookIn;

import java.util.List;

public interface BookService {
    List<BookDto> getAll();
    Book create(BookIn bookIn);
    Book update(Integer id,BookIn bookIn);
    void delete(Integer id);
}
