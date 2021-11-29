package com.test.service.Mapper;

import com.test.dto.AuthorDto;
import com.test.dto.CustomerDto;
import com.test.entity.Author;
import com.test.entity.Book;
import com.test.entity.Customer;
import com.test.in.AuthorIn;
import com.test.in.BookIn;

public class AuthorMapper {
    public static AuthorDto map(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setAge(author.getAge());
        authorDto.setBooks(author.getBooks());
        return authorDto;
    }

    public static Author map(AuthorIn authorDto){
        Author author = new Author();
        if (authorDto.getId() != null){
            author.setId(authorDto.getId());
        }
        author.setAge(authorDto.getAge());
        author.setName(authorDto.getName());
        if (authorDto.getBooks() != null){
            author.setBooks(authorDto.getBooks());
        }
            return author;
    }


}
