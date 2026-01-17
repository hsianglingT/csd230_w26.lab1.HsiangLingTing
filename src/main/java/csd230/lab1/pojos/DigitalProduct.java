package csd230.lab1.pojos;


import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.entities.DigitalProductEntity}
 */
public abstract class DigitalProduct extends Product {

    private double price;
    private String downloadUrl;
    private String title;
    private String author;

    public DigitalProduct() {
    }

    public DigitalProduct(double price, String downloadUrl, String title, String author) {
        this.price = price;
        this.downloadUrl = downloadUrl;
        this.title = title;
        this.author = author;
    }

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
        return "DigitalProduct{" +
                "price=" + price +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }



    @Override
    public void initialize() {
        System.out.println("Enter Title:");
        this.title = getInput("");

        System.out.println("Enter Author:");
        this.author = getInput("");

        System.out.println("Enter Download URL:");
        this.downloadUrl = getInput("");

        System.out.println("Enter Price:");
        this.price = getInput(0.0);
    }

    @Override
    public void edit(){
        System.out.println("Edit Title [" + this.title + "]:");
        this.title = getInput(this.title);

        System.out.println("Edit Author [" + this.author + "]:");
        this.author = getInput(this.author);

        System.out.println("Edit Download URL [" + this.downloadUrl + "]:");
        this.downloadUrl = getInput(this.downloadUrl);

        System.out.println("Edit Price [" + this.price + "]:");
        this.price = getInput(this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DigitalProduct that)) return false;
        return Double.compare(price, that.price) == 0 && Objects.equals(downloadUrl, that.downloadUrl) && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, downloadUrl, title, author);
    }
}

