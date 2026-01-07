package online.book.store;

import java.math.BigDecimal;
import online.book.store.model.Book;
import online.book.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return cmlr -> {
            Book firstBook = new Book();
            firstBook.setTitle("1984");
            firstBook.setAuthor("George Orwell");
            firstBook.setIsbn("978-3-654-1180");
            firstBook.setPrice(new BigDecimal("19.84"));
            firstBook.setDescription("Dystopian novel");
            firstBook.setCoverImage("1984.jpg");
            Book firstSavedBook = bookService.save(firstBook);
            System.out.println("First saved book: " + firstSavedBook);

            Book secondBook = new Book();
            secondBook.setTitle("Kobzar");
            secondBook.setAuthor("Taras Shevchenko");
            secondBook.setIsbn("978-5-93286-159-3");
            secondBook.setPrice(new BigDecimal("15.00"));
            secondBook.setDescription("Collection of poems");
            secondBook.setCoverImage("kobzar.jpg");
            Book secondSavedBook = bookService.save(secondBook);
            System.out.println("Second saved book: " + secondSavedBook);

            System.out.println("Books in store: " + bookService.findAll());
        };
    }

}
