package com.helbexam.library.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.helbexam.library.dao.AuthorDAO;
import com.helbexam.library.dto.AuthorDTO;
import com.helbexam.library.dto.AuthorDetailedDTO;
import com.helbexam.library.dto.BookDTO;
import com.helbexam.library.model.Author;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
    @Autowired
    private final AuthorDAO authorDAO;

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        if (authorDAO.existsByFirstnameAndLastname(authorDTO.getFirstname(), authorDTO.getLastname())) {
            throw new IllegalArgumentException("firstname, lastname combination already exists in the database");
        }

        Author author = new Author();
        BeanUtils.copyProperties(authorDTO, author, "id");
        author = authorDAO.save(author);
        BeanUtils.copyProperties(author, authorDTO);
        return authorDTO;
    }

    public AuthorDetailedDTO getAuthorDetailedById(Long id) {
        Author author = authorDAO.findAuthorById(id);    
        AuthorDetailedDTO authorDTO = new AuthorDetailedDTO();
        BeanUtils.copyProperties(author, authorDTO);
        authorDTO.setBooks(author.getBooks().stream().map((book) -> {
            BookDTO bookDTO = new BookDTO();
            BeanUtils.copyProperties(book, bookDTO);
            return bookDTO;
        }).toList());


        return authorDTO;
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorDAO.findAll().stream()
            .map((author) -> {
                AuthorDTO authorDTO = new AuthorDTO();
                BeanUtils.copyProperties(author, authorDTO);
                return authorDTO;
            })
            .collect(Collectors.toList());
    }
}


