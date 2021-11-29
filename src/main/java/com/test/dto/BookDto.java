package com.test.dto;

import com.test.entity.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    private Integer id;

    private String title;

    private String content;

    private Author author;
}
