package mk.ukim.finki.lab2_emt.service;

import mk.ukim.finki.lab2_emt.model.Author;
import mk.ukim.finki.lab2_emt.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> findByNameAndSurname(String name, String surname);

    Optional<Author> save(String name, String surname, Long country);

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> edit(Long id, String name, String surname, Long country);

    Optional<Author> edit(Long id, AuthorDto authorDto);

    void deleteById(Long id);
}
