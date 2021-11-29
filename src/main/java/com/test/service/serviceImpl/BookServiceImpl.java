package com.test.service.serviceImpl;

import com.test.dto.AuthorDto;
import com.test.dto.BookDto;
import com.test.entity.Author;
import com.test.entity.Book;
import com.test.in.BookIn;
import com.test.repository.AuthorRepository;
import com.test.repository.BookRepository;
import com.test.service.BookService;
import com.test.service.Mapper.AuthorMapper;
import com.test.service.Mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    private BookMapper bookMapper;

    @Override
    public List<BookDto> getAll() {
        List<Book> list = bookRepository.findAll();
        List<BookDto> dtoList = list.stream().map(it -> bookMapper.map(it)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public Book create(BookIn bookIn) {
        Book book = BookMapper.map(bookIn);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Integer id,BookIn bookIn) {
        Book book = bookRepository.getById(id);
        bookIn.setId(id);
        Author author = book.getAuthor();

        if (bookIn.getIdAuthor() != null){
            author = authorRepository.findAuthorById(bookIn.getIdAuthor());
        }
        if (bookIn.getAuthor() != null){
            author = bookIn.getAuthor();
        }
        book = BookMapper.map(bookIn);
        book.setAuthor(author);
        Book book1 = book;
        return bookRepository.save(book1);
    }

    @Override
    public void delete(Integer id) {
        Book book = bookRepository.getById(id);
        book.setAuthor(null);
        bookRepository.save(book);
        bookRepository.deleteById(id);
    }
}
