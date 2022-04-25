package mk.ukim.finki.lab2_emt.repository;

import mk.ukim.finki.lab2_emt.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameAndSurname(String name, String surname);
    void deleteByNameAndSurname(String name, String surname);
}
