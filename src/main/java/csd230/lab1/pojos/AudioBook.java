package csd230.lab1.pojos;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.entities.AudioBookEntity}
 */
public class AudioBook extends DigitalProduct {
    private String narrator;

    public AudioBook() {
        super();
    }

    public AudioBook(double price, String downloadUrl, String title, String author, String narrator) {
        super(price, downloadUrl, title, author);
        this.narrator = narrator;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Edit Narrator [" + this.narrator + "]:");
        this.narrator = getInput(this.narrator);


    }

    @Override
    public void initialize() {
        super.initialize();
        System.out.println("Enter Narrator:");
        this.narrator = getInput("Unknown Narrator");
    }

    @Override
    public String toString() {
        return "AudioBook{" +
                "narrator='" + narrator + '\'' +
                ", base=" + super.toString() +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AudioBook audioBook)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(narrator, audioBook.narrator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), narrator);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling audio book: " + getTitle() + " narrated by " + getNarrator());
    }
}

