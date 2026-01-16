package csd230.lab1.pojos;

/**
 * DTO for {@link csd230.lab1.entities.AudioBookEntity}
 */
public class AudioBook extends DigitalProduct {
    private String title = "";
    private String author = "";
    private String narrator = "";
    private int lengthMinutes = 0;

    public AudioBook() {
        super();
    }

    public AudioBook(String title, String author, String narrator, int lengthMinutes,
                     double price, String url, long fileSizeKb, String drm) {
        super(price, url, fileSizeKb, drm);
        this.title = title;
        this.author = author;
        this.narrator = narrator;
        this.lengthMinutes = lengthMinutes;
    }

    @Override
    public void initialize() {
        super.initialize();

        System.out.println("Enter Title:");
        this.title = getInput("Untitled");

        System.out.println("Enter Author:");
        this.author = getInput("Unknown");

        System.out.println("Enter Narrator:");
        this.narrator = getInput("Unknown");

        System.out.println("Enter Length (Minutes):");
        this.lengthMinutes = getInput(0);
    }

    @Override
    public void edit() {
        super.edit();

        System.out.println("Edit Title [" + this.title + "]:");
        this.title = getInput(this.title);

        System.out.println("Edit Author [" + this.author + "]:");
        this.author = getInput(this.author);

        System.out.println("Edit Narrator [" + this.narrator + "]:");
        this.narrator = getInput(this.narrator);

        System.out.println("Edit Length Minutes [" + this.lengthMinutes + "]:");
        this.lengthMinutes = getInput(this.lengthMinutes);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling AudioBook: " + title + " by " + author +
                " narrated by " + narrator);
        System.out.println("Download at: " + getDownloadUrl());
    }

    // Getters / Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getNarrator() { return narrator; }
    public void setNarrator(String narrator) { this.narrator = narrator; }
    public int getLengthMinutes() { return lengthMinutes; }
    public void setLengthMinutes(int lengthMinutes) { this.lengthMinutes = lengthMinutes; }

    @Override
    public String toString() {
        return "AudioBook{title='" + title + "', author='" + author +
                "', narrator='" + narrator + "', lengthMinutes=" + lengthMinutes +
                ", " + super.toString() + "}";
    }
}

