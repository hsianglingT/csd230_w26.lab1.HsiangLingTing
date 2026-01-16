package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("EBOOK")
public class EbookEntity extends DigitalProductEntity {

    @Column(name = "pages")
    private int pages;

    public EbookEntity(double price, String downloadUrl, String title, String author, int pages) {
        super(price, downloadUrl, title, author);
        this.pages = pages;
    }

    public EbookEntity(int pages) {
        this.pages = pages;
    }

    public EbookEntity() {

    }


    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "EbookEntity{" +
                "price=" + super.getPrice() +'\'' +
                ", downloadUrl='" + super.getDownloadUrl() + '\'' +
                ", title='" + super.getTitle() + '\'' +
                ", author='" + super.getAuthor() + '\'' +
                "pages=" + pages +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EbookEntity that)) return false;
        if (!super.equals(o)) return false;
        return pages == that.pages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pages);
    }
}