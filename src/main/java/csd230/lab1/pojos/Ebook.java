package csd230.lab1.pojos;

/**
 * DTO for {@link csd230.lab1.entities.EbookEntity}
 */
public class Ebook extends DigitalProduct {
    private String title = "";
    private String author = "";
    private String isbn = "";
    private int pages = 0;

    public Ebook() {
        super();
    }

    public Ebook(String title, String author, String isbn, int pages,
                 double price, String url, long fileSizeKb, String drm) {
        super(price, url, fileSizeKb, drm);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    @Override
    public void initialize() {
        // 1. Initialize Base DigitalProduct fields
        super.initialize();

        // 2. Initialize Ebook fields
        System.out.println("Enter Title:");
        this.title = getInput("Untitled");

        System.out.println("Enter Author:");
        this.author = getInput("Unknown");

        System.out.println("Enter ISBN:");
        this.isbn = getInput("N/A");

        System.out.println("Enter Page Count:");
        this.pages = getInput(0);
    }

    @Override
    public void edit() {
        super.edit();

        System.out.println("Edit Title [" + this.title + "]:");
        this.title = getInput(this.title);

        System.out.println("Edit Author [" + this.author + "]:");
        this.author = getInput(this.author);

        System.out.println("Edit ISBN [" + this.isbn + "]:");
        this.isbn = getInput(this.isbn);

        System.out.println("Edit Pages [" + this.pages + "]:");
        this.pages = getInput(this.pages);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Ebook: " + title + " by " + author);
        System.out.println("Download at: " + getDownloadUrl());
    }

    // Getters / Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    @Override
    public String toString() {
        return "Ebook{title='" + title + "', author='" + author + "', isbn='" + isbn +
                "', pages=" + pages + ", " + super.toString() + "}";
    }
}

