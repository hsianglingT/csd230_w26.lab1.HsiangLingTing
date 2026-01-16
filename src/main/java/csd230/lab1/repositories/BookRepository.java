package csd230.lab1.repositories;

import csd230.lab1.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByIsbn(String isbn);
    BookEntity findById(long id);
    BookEntity findByAuthor(String author);
    BookEntity findByTitleLike(String title); // this is a "Like" query

    // @Query annotation to create a custom query by your own
    @Query("SELECT book FROM BookEntity book WHERE book.price BETWEEN :minPrice AND :maxPrice")
    List<BookEntity> findBooksByPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
}