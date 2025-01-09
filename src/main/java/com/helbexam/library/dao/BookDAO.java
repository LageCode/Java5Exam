package com.helbexam.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helbexam.library.model.Book;
import com.helbexam.library.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookDAO {
    @Autowired 
    private final BookRepository bookRepository;

    public Book findBookById(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Book id does not exist in the database."));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public boolean existsById(Long ig) {
        return bookRepository.existsById(ig);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
