package com.helbexam.library.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.helbexam.library.model.Author;

public interface AuthorRepository extends ListCrudRepository<Author, Long> {

    /** 
     * ListCrudRepository already implements:
     *  - findById
     *  - existsById
     *  - ...
     */ 

    boolean existsByFirstnameAndLastname(String firtsname, String lastname);
}