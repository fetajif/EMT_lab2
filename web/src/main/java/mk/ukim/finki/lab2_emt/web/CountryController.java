package mk.ukim.finki.lab2_emt.web;

import mk.ukim.finki.lab2_emt.model.Author;
import mk.ukim.finki.lab2_emt.model.Country;
import mk.ukim.finki.lab2_emt.model.dto.AuthorDto;
import mk.ukim.finki.lab2_emt.model.dto.CountryDto;
import mk.ukim.finki.lab2_emt.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll() {
        return this.countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return this.countryService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody CountryDto countryDto) {
        return this.countryService.save(countryDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> save(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return this.countryService.edit(id, countryDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.countryService.deleteById(id);
        if(this.countryService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
