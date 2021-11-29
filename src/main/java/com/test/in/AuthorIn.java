package com.test.in;

import com.test.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorIn {
    private Integer id;

    private Boolean checkDelete;
    private String name;

    private Integer age;
    private List<Book> books;
}
