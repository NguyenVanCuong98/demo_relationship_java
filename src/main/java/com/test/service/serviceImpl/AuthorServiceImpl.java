package com.test.service.serviceImpl;

import com.test.dto.AuthorDto;
import com.test.entity.Author;
import com.test.entity.Book;
import com.test.in.AuthorIn;
import com.test.repository.AuthorRepository;
import com.test.repository.BookRepository;
import com.test.service.AuthorService;
import com.test.service.Mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private BookRepository bookRepository;

    private AuthorMapper authorMapper;
    @Override
    public List<AuthorDto> getAll() {
        List<Author> list = authorRepository.findAll();
        List<AuthorDto> dtoList = list.stream().map(it -> authorMapper.map(it)).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public Author create(AuthorIn authorIn) {

        Author author = AuthorMapper.map(authorIn);
        return authorRepository.save(author);
    }

    @Override
    public Author update(Integer id,AuthorIn authorIn) {
            Author author = authorRepository.findById(id).orElse(null);
        authorIn.setId(id);
        if (authorIn.getBooks() == null){
            List<Book> books = author.getBooks();
            authorIn.setBooks(books);

        }else {
            List<Book> books =  authorIn.getBooks();

            for (int i = 0; i < books.size();i++){
                if (books.get(i).getContent() == null){
                    Book book = bookRepository.findById(books.get(i).getId()).orElse(null);
                    books.set(i,book);
                }
            }
            authorIn.setBooks(books);
        }
        author = AuthorMapper.map(authorIn);
        return authorRepository.save(author);
    }

    @Override
    public void delete(Integer id,AuthorIn authorIn) {
        if (authorIn.getCheckDelete() == false){
            List<Book> bookList = bookRepository.findAllAuthor(id);
            for (int i =0; i < bookList.size();i++){
                bookList.get(i).setAuthor(null);
                bookRepository.save(bookList.get(i));
            }
        }
        authorRepository.deleteById(id);
    }
}
