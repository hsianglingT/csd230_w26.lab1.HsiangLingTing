package csd230.lab1.entities;

import csd230.lab1.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // use application db (mysql) not default h2 embedded db
@Transactional(propagation = Propagation.NOT_SUPPORTED)// dont rollback so you can see data in the db

class BookEntityTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void saveBookEntity() {
        BookEntity newBook = new BookEntity("The Great Gatsby", 10.99, 5, "F. Scott Fitzgerald", "9780743273565");
        bookRepository.save(newBook);

        BookEntity book = bookRepository.findByAuthor("F. Scott Fitzgerald");
        assertNotNull(book);
        assertEquals("The Great Gatsby", book.getTitle());
    }

    @Test
    void deleteBookEntity() {
        BookEntity newBook = new BookEntity("1984", 8.99, 10, "George Orwell", "9780451524935");
        bookRepository.save(newBook);

        BookEntity book = bookRepository.findByAuthor("George Orwell");
        assertNotNull(book);

        bookRepository.delete(book);
        BookEntity deletedBook = bookRepository.findByAuthor("George Orwell");
        assertNull(deletedBook);
    }

    @Test
    void editBookEntity() {
        BookEntity newBook = new BookEntity("ABCDddddog", 12.99, 7, "ABC Porter", "9780061120084");
        bookRepository.save(newBook);

        Long bookId = newBook.getId();
        BookEntity book = bookRepository.findById(bookId).orElse(null);

        assertNotNull(book);
        assertEquals("ABCDddddog", book.getTitle());

        // Edit the book's title
        book.setTitle("ABCcccat");
        bookRepository.save(book);
        BookEntity updatedBook = bookRepository.findById(bookId).orElse(null);
        assertNotNull(updatedBook);
        assertEquals("ABCcccat", updatedBook.getTitle());

    }

}