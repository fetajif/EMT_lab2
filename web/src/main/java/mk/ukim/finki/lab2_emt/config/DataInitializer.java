//package mk.ukim.finki.lab2_emt.config;
//
//import mk.ukim.finki.lab2_emt.model.Category;
//import mk.ukim.finki.lab2_emt.service.AuthorService;
//import mk.ukim.finki.lab2_emt.service.BookService;
//import mk.ukim.finki.lab2_emt.service.CountryService;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
//public class DataInitializer {
//
//    private final BookService bookService;
//    private final AuthorService authorService;
//    private final CountryService countryService;
//
//    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
//        this.bookService = bookService;
//        this.authorService = authorService;
//        this.countryService = countryService;
//    }
//
//    @PostConstruct
//    public void initData() {
//        countryService.save("England", "Europe");
//        countryService.save("USA", "North America");
//        countryService.save("France", "Europe");
//        countryService.save("Spain", "Europe");
//
//        authorService.save("William", "Shakespeare", 1L);
//        authorService.save("Agatha", "Christie", 1L);
//        authorService.save("J.K", "Rowling", 1L);
//        authorService.save("Stephen", "King", 2L);
//        authorService.save("F. Scott", "Fitzgerald", 2L);
//
//        bookService.save("The Great Gatsby", Category.CLASSICS, 5L, 25);
//        bookService.save("Romeo and Juliett", Category.CLASSICS, 1L, 30);
//        bookService.save("Murder on the Orient Express", Category.THRILLER, 2L, 15);
//        bookService.save("Harry Potter & the Sorcerer's Stone", Category.FANTASY, 3L, 30);
//        bookService.save("IT", Category.THRILLER, 4L, 15);
//    }
//
//
//}
