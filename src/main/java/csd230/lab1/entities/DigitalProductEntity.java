package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("DIGITAL")
public abstract class DigitalProductEntity extends ProductEntity {

    @Column(name = "digital_price")
    private double price;

    @Column(name = "download_url")
    private String downloadUrl;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    public DigitalProductEntity(double price, String downloadUrl, String title, String author) {
        this.price = price;
        this.downloadUrl = downloadUrl;
        this.title = title;
        this.author = author;
    }

    public DigitalProductEntity() {

    }

    @Override
    public void sellItem() {
        System.out.println("Sold digital product '" + title + "'. Download URL: " + downloadUrl);
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "DigitalProductEntity{" +
                "price=" + price +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DigitalProductEntity that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(price, that.price) == 0 && Objects.equals(downloadUrl, that.downloadUrl) && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, downloadUrl, title, author);
    }

}
