package com.helbexam.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helbexam.library.model.Author;
import com.helbexam.library.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorDAO {
    @Autowired
    private final AuthorRepository authorRepository;

    public Author findAuthorById(Long id) {
        return authorRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Author id does not exist in the database."));
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public boolean existsByFirstnameAndLastname(String firstname, String lastname) {
        return authorRepository.existsByFirstnameAndLastname(firstname, lastname);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
