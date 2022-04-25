package mk.ukim.finki.lab2_emt.web;

import mk.ukim.finki.lab2_emt.model.Book;
import mk.ukim.finki.lab2_emt.model.dto.BookDto;
import mk.ukim.finki.lab2_emt.model.Category;
import mk.ukim.finki.lab2_emt.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @GetMapping("/categories")
    public List<Category> findAllCategories() {
        return Arrays.stream(Category.values())
        .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/markTaken/{id}")
    public ResponseEntity MarkAsTaken(@PathVariable Long id) {
        if (this.bookService.markAsTaken(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
