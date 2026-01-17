package csd230.lab1.entities;

import csd230.lab1.repositories.CartEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)


public class CartEntityTest {
    @Autowired
    private CartEntityRepository cartEntityRepository;

    @Test
    void addProductToCart() {
        CartEntity cart = new CartEntity();

        ProductEntity ebook = new EbookEntity(
                9.99,
                "https://example.com/download/great-ebook",
                "This is an Ebook",
                "Alice Apple",
                250
        );

        cart.addProduct(ebook);
        cartEntityRepository.save(cart);

        List<CartEntity> allCarts = cartEntityRepository.findAll();
        assertEquals(1, allCarts.size());


    }

    @Test
    void removeProductFromCart() {
        CartEntity cart = new CartEntity();

        // make sure there is one product in the cart
        List<CartEntity> allCarts = cartEntityRepository.findAll();
        assertEquals(1, allCarts.size());

        cartEntityRepository.deleteAll();

        List<CartEntity> allCartsAfterDeletion = cartEntityRepository.findAll();
        assertEquals(0, allCartsAfterDeletion.size());
    }
}
