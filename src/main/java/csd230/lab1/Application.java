package csd230.lab1;


import com.github.javafaker.Faker;
import csd230.lab1.entities.*;
import csd230.lab1.entities.AudioBookEntity;
import csd230.lab1.entities.BookEntity;
import csd230.lab1.entities.CartEntity;
import csd230.lab1.entities.ProductEntity;
import csd230.lab1.repositories.CartEntityRepository;
import csd230.lab1.repositories.ProductEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class Application  implements CommandLineRunner {
    private final ProductEntityRepository productRepository;
    private final CartEntityRepository cartRepository;

    public Application(ProductEntityRepository productRepository,
                       CartEntityRepository cartRepository
    ) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        com.github.javafaker.Number number = faker.number();
        com.github.javafaker.Book fakeBook = faker.book();
        String priceString = faker.commerce().price();

        BookEntity book = new BookEntity(
                fakeBook.title(),
                Double.parseDouble(priceString),
                10,
                fakeBook.author(),
                faker.code().isbn10());
        ;

        BookEntity book2 = new BookEntity(
                fakeBook.title(),
                Double.parseDouble(priceString),
                10,
                fakeBook.author(),
                faker.code().isbn10());
        ;

        csd230.lab1.entities.MagazineEntity magazine = new csd230.lab1.entities.MagazineEntity(
                faker.lorem().word() + " Magazine",
                12.99,
                20,
                50,
                java.time.LocalDateTime.now()
        );

        productRepository.save(book);
        productRepository.save(book2);
        productRepository.save(magazine);

        CartEntity cart=new CartEntity();
        cartRepository.save(cart);

        // create a book
        // add book to the cart
//        cart.addProduct(book);
//
//        cartRepository.save(cart);
//
//        cart.addProduct(magazine);
//
//        cartRepository.save(cart);

        // create an audiobook price, downloadUrl, title, author, narrator
        AudioBookEntity audiobook = new AudioBookEntity(
                19.99,
                "http://example.com/download/great-audiobook",
                "This is an Audiobook",
                "John Doe",
                "Jane Smith"

        );
        productRepository.save(audiobook);
//        cart.addProduct(audiobook);
//        cartRepository.save(cart);

        // Create Ebook
        EbookEntity ebook = new EbookEntity(
                15.99,
                "http://example.com/download/great-ebook",
                "This is an Ebook",
                "Alice Johnson",
                250
        );
        productRepository.save(ebook);
//        cart.addProduct(ebook);
//        cartRepository.save(cart);

        // Create Ticket
        TicketEntity ticket = new TicketEntity(
                "Concert Ticket",
                75.00
        );
        productRepository.save(ticket);
//        cart.addProduct(ticket);
//        cartRepository.save(cart);

        // Create DiscMagazine
        DiscMagEntity discMag = new DiscMagEntity(
                "Tech Monthly Disc Magazine",
                9.99,
                15,
                100,
                java.time.LocalDateTime.now(),
                true
        );
        productRepository.save(discMag);
//        cart.addProduct(discMag);
//        cartRepository.save(cart);


        List<ProductEntity> allProducts = productRepository.findAll();

        System.out.println("----Print product details---");
        for(ProductEntity p : allProducts) {
            // Print product details

            System.out.println(p.toString());

        }
        System.out.println("--------------------");


        List<CartEntity> allCarts = cartRepository.findAll();
        for(CartEntity c : allCarts) {
            System.out.println("--Print cart details---");
            System.out.println(c.toString());
            for(ProductEntity p : c.getProducts()) {
                System.out.println(p.toString());
            }
        }

        // edit some products
        book.setPrice(8.99);
        productRepository.save(book);

        ticket.setPrice(70.00);
        productRepository.save(ticket);

        discMag.setPrice(19.99);
        productRepository.save(discMag);

        magazine.setPrice(40.99);
        productRepository.save(magazine);

        audiobook.setPrice(20.00);
        productRepository.save(audiobook);

        ebook.setPages(260);
        productRepository.save(ebook);

        // print updated products
        System.out.println("----Print updated product details---");
        allProducts = productRepository.findAll();
        for(ProductEntity p : allProducts) {
            System.out.println(p.toString());
        }
        System.out.println("--------------------");

        // cart and product have a many-to-many relationship
        // when deleting products, make sure to remove them from carts as well, otherwise the deletion in product table will fail
        // delete carts
//        cartRepository.deleteAll();
//        System.out.println("Carts deleted successfully.");


        // delete some products
//        productRepository.delete(book);
//        productRepository.delete(ticket);
//        productRepository.delete(discMag);
//        productRepository.delete(magazine);
//        productRepository.delete(audiobook);
//        productRepository.delete(ebook);
//        System.out.println("----Print product details after deletion---");
//        allProducts = productRepository.findAll();
//        if (allProducts.isEmpty()) {
//            System.out.println("All products deleted successfully.");
//        } else {
//            for(ProductEntity p : allProducts) {
//                System.out.println(p.toString());
//            }
//        }
//        System.out.println("--------------------");
    }

}
