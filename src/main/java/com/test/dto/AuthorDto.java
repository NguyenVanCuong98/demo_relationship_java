package com.test.dto;

import com.test.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto {

    private Integer id;

    private String name;

    private Integer age;

    private List<Book> books;

}
