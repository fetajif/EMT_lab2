package mk.ukim.finki.lab2_emt.repository;

import mk.ukim.finki.lab2_emt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
    void deleteByName(String name);
}
