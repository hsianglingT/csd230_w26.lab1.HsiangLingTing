package csd230.lab1.entities;


import csd230.lab1.repositories.EbookEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)


public class EbookEntityTest {
    @Autowired
    private EbookEntityRepository ebookEntityRepository;

    @Test
    void saveEbookEntity() {
        EbookEntity newEbook = new EbookEntity(
                9.99,
                "http://example.com/ebook.pdf",
                "This is an Ebook test",
                "Jane Doe",
                250
        );
        ebookEntityRepository.save(newEbook);

        EbookEntity savedEbook = ebookEntityRepository.findById(newEbook.getId()).orElse(null);
        assertNotNull(savedEbook);
        assertEquals("This is an Ebook test", savedEbook.getTitle());
    }

    @Test
    void deleteEbookEntity() {
        EbookEntity newEbook = new EbookEntity(
                7.99,
                "http://example.com/ebook2.pdf",
                "Another Ebook test",
                "Mike Johnson",
                300
        );
        ebookEntityRepository.save(newEbook);

        Long id = newEbook.getId();
        EbookEntity savedEbook = ebookEntityRepository.findById(newEbook.getId()).orElse(null);
        assertNotNull(savedEbook);

        ebookEntityRepository.deleteById(id);
        EbookEntity deletedEbook = ebookEntityRepository.findById(id).orElse(null);
        assertNull(deletedEbook);
    }

    @Test
    void editEbookEntity() {
        EbookEntity newEbook = new EbookEntity(
                11.99,
                "http://example.com/ebook3.pdf",
                "Ebook to be edited",
                "Sarah Lee",
                150
        );
        ebookEntityRepository.save(newEbook);

        Long id = newEbook.getId();
        EbookEntity savedEbook = ebookEntityRepository.findById(newEbook.getId()).orElse(null);
        assertNotNull(savedEbook);
        savedEbook.setPrice(13.99);

        ebookEntityRepository.save(savedEbook);
        EbookEntity editedEbook = ebookEntityRepository.findById(id).orElse(null);
        assertNotNull(editedEbook);
        assertEquals(13.99, editedEbook.getPrice());
    }
}
