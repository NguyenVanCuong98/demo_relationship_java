package com.test.repository;

import com.test.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from books where id_author = ?1",nativeQuery = true)
    List<Book> findAllAuthor(Integer id);
   
}
