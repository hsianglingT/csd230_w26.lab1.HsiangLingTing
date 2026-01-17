package csd230.lab1.pojos;

/**
 * DTO for {@link csd230.lab1.entities.EbookEntity}
 */
public class Ebook extends DigitalProduct {
    private int pages;

    public Ebook() {
        super();
    }

    public Ebook(double price, String downloadUrl, String title, String author, int pages) {
        super(price, downloadUrl, title, author);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public void sellItem() {
        System.out.println("Ebook sold: " + getTitle());
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Edit Pages [" + this.pages + "]:");
        this.pages = getInput(this.pages);
    }

    @Override
    public void initialize() {
        super.initialize();
        System.out.println("Enter Pages:");
        this.pages = getInput(0);
    }

}

