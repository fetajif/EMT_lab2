package mk.ukim.finki.lab2_emt.service.impl;


import mk.ukim.finki.lab2_emt.model.Author;
import mk.ukim.finki.lab2_emt.model.Book;
import mk.ukim.finki.lab2_emt.model.dto.BookDto;
import mk.ukim.finki.lab2_emt.model.Category;
import mk.ukim.finki.lab2_emt.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.lab2_emt.model.exceptions.BookNotFoundException;
import mk.ukim.finki.lab2_emt.repository.AuthorRepository;
import mk.ukim.finki.lab2_emt.repository.BookRepository;
import mk.ukim.finki.lab2_emt.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, Category category, Long author, Integer availableCopies) {
        Author author1 = this.authorRepository.findById(author)
                .orElseThrow(() -> new AuthorNotFoundException(author));

        this.bookRepository.deleteByName(name);
        Book book = new Book(name, category, author1, availableCopies);
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author1 = this.authorRepository.findById(bookDto.getAuthor().getId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor().getId()));
        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author1, bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long author, Integer availableCopies) {

        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        Author author1 = this.authorRepository.findById(author)
                .orElseThrow(() -> new AuthorNotFoundException(author));

        book.setName(name);
        book.setAuthor(author1);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        Author author1 = this.authorRepository.findById(bookDto.getAuthor().getId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor().getId()));

        book.setName(bookDto.getName());
        book.setAuthor(author1);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public boolean markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        if(book.getAvailableCopies()>0) {
            book.setAvailableCopies(book.getAvailableCopies()-1);
            this.bookRepository.save(book);
            return true;
        }
        return false;
    }


}
