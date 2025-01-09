package com.helbexam.library.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helbexam.library.dto.AuthorDTO;
import com.helbexam.library.dto.AuthorDetailedDTO;
import com.helbexam.library.service.AuthorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/authors")
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        try {
            List<AuthorDTO> authors = authorService.getAllAuthors();
            return authors.isEmpty() ? ResponseEntity.noContent().build()
                                   : ResponseEntity.ok(authors);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDetailedDTO> getAuthor(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(authorService.getAuthorDetailedById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        try {
            AuthorDTO created = authorService.createAuthor(authorDTO);
            return ResponseEntity
                .created(URI.create("/api/authors/" + created.getId()))
                .body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
