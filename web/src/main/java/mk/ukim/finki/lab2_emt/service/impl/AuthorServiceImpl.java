package mk.ukim.finki.lab2_emt.service.impl;

import mk.ukim.finki.lab2_emt.model.Author;
import mk.ukim.finki.lab2_emt.model.Country;
import mk.ukim.finki.lab2_emt.model.dto.AuthorDto;
import mk.ukim.finki.lab2_emt.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.lab2_emt.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.lab2_emt.repository.AuthorRepository;
import mk.ukim.finki.lab2_emt.repository.CountryRepository;
import mk.ukim.finki.lab2_emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> findByNameAndSurname(String name, String surname) {
        return this.authorRepository.findByNameAndSurname(name, surname);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long country) {

        Country country1 = this.countryRepository.findById(country)
                .orElseThrow(() -> new CountryNotFoundException(country));

        this.authorRepository.deleteByNameAndSurname(name, surname);

        Author author = new Author(name, surname, country1);
        this.authorRepository.save(author);

        return Optional.of(author);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country1 = this.countryRepository.findById(authorDto.getCountry().getId())
                .orElseThrow(() -> new CountryNotFoundException(authorDto.getCountry().getId()));

        this.authorRepository.deleteByNameAndSurname(authorDto.getName(), authorDto.getSurname());

        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country1);
        this.authorRepository.save(author);

        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long country) {

        Author author = this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        Country country1 = this.countryRepository.findById(country).orElseThrow(() -> new CountryNotFoundException(country));

        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country1);

        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        Country country1 = this.countryRepository.findById(authorDto.getCountry().getId())
                .orElseThrow(() -> new CountryNotFoundException(authorDto.getCountry().getId()));

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(country1);

        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
