package com.helbexam.library.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.helbexam.library.dao.BookDAO;
import com.helbexam.library.dto.BookDTO;
import com.helbexam.library.model.Book;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private final BookDAO bookDAO;

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        book = bookDAO.save(book);
        BeanUtils.copyProperties(book, bookDTO);
        return bookDTO;
    }

    public BookDTO getBookById(Long id) {
        Book book = bookDAO.findBookById(id);    
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(book, bookDTO);
        return bookDTO;
    }

    public List<BookDTO> getAllBooks() {
        return bookDAO.findAll().stream()
            .map((book) -> {
                BookDTO bookDTO = new BookDTO();
                BeanUtils.copyProperties(book, bookDTO);
                return bookDTO;
            })
            .collect(Collectors.toList());
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookDAO.findBookById(id);

        BeanUtils.copyProperties(bookDTO, book, "id");
        book = bookDAO.save(book);
        BeanUtils.copyProperties(book, bookDTO);

        return bookDTO;
    }

    public void deleteBook(Long id) {
        if (!bookDAO.existsById(id)) {
            throw new IllegalArgumentException("book not found");
        }

        bookDAO.deleteById(id);
    }
}
