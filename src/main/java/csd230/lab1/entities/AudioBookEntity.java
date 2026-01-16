package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("AUDIOBOOK")
public class AudioBookEntity extends DigitalProductEntity {

    @Column(name = "narrator")
    private String narrator;


    public AudioBookEntity(double price, String downloadUrl, String title, String author, String narrator) {
        super(price, downloadUrl, title, author);
        this.narrator = narrator;
    }

    public AudioBookEntity(String narrator) {
        this.narrator = narrator;
    }

    public AudioBookEntity() {

    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return "AudioBookEntity{" +
                "price=" + super.getPrice() +'\'' +
                ", downloadUrl='" + super.getDownloadUrl() + '\'' +
                ", title='" + super.getTitle() + '\'' +
                ", author='" + super.getAuthor() + '\'' +
                "narrator='" + narrator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AudioBookEntity that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(narrator, that.narrator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), narrator);
    }
}