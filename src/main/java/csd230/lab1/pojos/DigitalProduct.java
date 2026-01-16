package csd230.lab1.pojos;

/**
 * DTO for {@link csd230.lab1.entities.DigitalProductEntity}
 */
/**
 * DTO for {@link csd230.lab1.entities.DigitalProductEntity}
 */
public abstract class DigitalProduct extends Product {
    private double price = 0.0;
    private String downloadUrl = "";
    private long fileSizeKb = 0;
    private String drmFormat = "";

    public DigitalProduct() { }

    public DigitalProduct(double price, String downloadUrl, long fileSizeKb, String drmFormat) {
        this.price = price;
        this.downloadUrl = downloadUrl;
        this.fileSizeKb = fileSizeKb;
        this.drmFormat = drmFormat;
    }

    @Override
    public void initialize() {
        // Initialize Price
        System.out.println("Enter Price:");
        this.price = getInput(0.0);

        // Initialize URL
        System.out.println("Enter Download URL:");
        this.downloadUrl = getInput("http://example.com/file");

        // Initialize File Size
        System.out.println("Enter File Size (KB):");
        this.fileSizeKb = (long) getInput(0L);

        // Initialize DRM Format
        System.out.println("Enter DRM Format:");
        this.drmFormat = getInput("NONE");
    }

    @Override
    public void edit() {
        System.out.println("Edit Price [" + this.price + "]:");
        this.price = getInput(this.price);

        System.out.println("Edit Download URL [" + this.downloadUrl + "]:");
        this.downloadUrl = getInput(this.downloadUrl);

        System.out.println("Edit File Size KB [" + this.fileSizeKb + "]:");
        this.fileSizeKb = (long) getInput(this.fileSizeKb);

        System.out.println("Edit DRM Format [" + this.drmFormat + "]:");
        this.drmFormat = getInput(this.drmFormat);
    }

    @Override
    public double getPrice() {
        return price;
    }

    // Getters & Setters
    public void setPrice(double price) { this.price = price; }
    public String getDownloadUrl() { return downloadUrl; }
    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }
    public long getFileSizeKb() { return fileSizeKb; }
    public void setFileSizeKb(long fileSizeKb) { this.fileSizeKb = fileSizeKb; }
    public String getDrmFormat() { return drmFormat; }
    public void setDrmFormat(String drmFormat) { this.drmFormat = drmFormat; }

    @Override
    public String toString() {
        return "DigitalProduct{price=" + price +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", fileSizeKb=" + fileSizeKb +
                ", drmFormat='" + drmFormat + '\'' +
                '}';
    }
}

