package csd230.lab1.entities;


import csd230.lab1.repositories.DiscMagEntityRepository;
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


public class DiscMagEntityTest {

    @Autowired
    private DiscMagEntityRepository DiscMagEntityRepository;

    @Test
    void saveDiscMagEntity() {
        DiscMagEntity newDiscMag = new DiscMagEntity(
                "ABCD",
                5.99,
                20,
                100,
                java.time.LocalDateTime.now(),
                true
        );

        DiscMagEntityRepository.save(newDiscMag);

        assertNotNull(newDiscMag.getId());

        // Fetch "newDiscMag" from the repository
        MagazineEntity magazine = DiscMagEntityRepository.findById(newDiscMag.getId()).orElse(null);
        assertNotNull(magazine);
        assertEquals("ABCD", magazine.getTitle());
    }

    @Test
    void deleteDiscMagEntity(){

        DiscMagEntity newDiscMag = new DiscMagEntity(
                "BCDERT",
                5.99,
                20,
                100,
                java.time.LocalDateTime.now(),
                true
        );
        DiscMagEntityRepository.save(newDiscMag);

        DiscMagEntity discMag = DiscMagEntityRepository.findById(newDiscMag.getId()).orElse(null);
        assertNotNull(discMag);

        DiscMagEntityRepository.delete(discMag);
        DiscMagEntity deletedDiscMag = DiscMagEntityRepository.findById(newDiscMag.getId()).orElse(null);
        assertNull(deletedDiscMag);

    }

    @Test
    void editDiscMagEntity(){

        DiscMagEntity newDiscMag = new DiscMagEntity(
                "BCDERTTT",
                5.99,
                20,
                100,
                java.time.LocalDateTime.now(),
                true
        );
        DiscMagEntityRepository.save(newDiscMag);

        Long discMagId = newDiscMag.getId();
        DiscMagEntity discMag = DiscMagEntityRepository.findById(discMagId).orElse(null);
        assertNotNull(discMag);

        discMag.setTitle("BCDCCCCCC");
        DiscMagEntityRepository.save(discMag);

        DiscMagEntity updatedDiscMag = DiscMagEntityRepository.findById(discMagId).orElse(null);
        assertNotNull(updatedDiscMag);
        assertEquals("BCDCCCCCC", updatedDiscMag.getTitle());
    }

}
