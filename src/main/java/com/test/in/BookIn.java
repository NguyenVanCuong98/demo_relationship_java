package com.test.in;


import com.test.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookIn {
    private Integer id;
    private String title;
    private Integer idAuthor;
    private String content;
    private Author author;
}
