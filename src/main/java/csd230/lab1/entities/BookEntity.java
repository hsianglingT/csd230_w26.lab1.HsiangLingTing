package csd230.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity @DiscriminatorValue("BOOK")
public class BookEntity extends PublicationEntity {
    private String author;
    private String isbn;
    public BookEntity() {}
    public BookEntity(String t, double p, int c, String a) { super(t, p, c); this.author = a; }

    public BookEntity(String t, double p, int c, String author, String isbn) {
        super(t, p, c);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String a) { this.author = a; }
    @Override public String toString() { return "Book{author='" + author + "', " + super.toString() + "}"; }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookEntity that)) return false;
        return Objects.equals(author, that.author) && Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, isbn);
    }
}
