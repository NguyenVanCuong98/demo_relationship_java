package com.test.controller;

import com.test.dto.AuthorDto;
import com.test.dto.CardDto;
import com.test.entity.Author;
import com.test.in.AuthorIn;
import com.test.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<AuthorDto>> getAll () {
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Author create (@RequestBody AuthorIn authorIn) {
        return authorService.create(authorIn);
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id,@RequestBody AuthorIn authorIn){
        authorService.delete(id,authorIn);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Author update(@PathVariable Integer id,@RequestBody AuthorIn authorIn){
        return authorService.update(id,authorIn);
    }
}
