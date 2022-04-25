package mk.ukim.finki.lab2_emt.service;

import mk.ukim.finki.lab2_emt.model.Book;
import mk.ukim.finki.lab2_emt.model.dto.BookDto;
import mk.ukim.finki.lab2_emt.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> save(String name, Category category, Long author, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, String name, Category category, Long author, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    boolean markAsTaken(Long id);

}
