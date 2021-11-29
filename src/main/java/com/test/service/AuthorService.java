package com.test.service;

import com.test.dto.AuthorDto;
import com.test.entity.Author;
import com.test.in.AuthorIn;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();
    Author create(AuthorIn authorIn);
    Author update( Integer id,AuthorIn authorIn);
    void delete(Integer id,AuthorIn authorIn);

}
