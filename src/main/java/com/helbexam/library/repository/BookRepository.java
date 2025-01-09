package com.helbexam.library.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.helbexam.library.model.Book;

public interface BookRepository extends ListCrudRepository<Book, Long> {

    /** 
     * ListCrudRepository already implements:
     *  - findById
     *  - existsById
     *  - ...
     */ 
}