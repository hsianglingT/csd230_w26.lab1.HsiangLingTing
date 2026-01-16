package csd230.lab1.entities;


import csd230.lab1.repositories.MagazineEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // use application db (mysql) not default h2 embedded db
@Transactional(propagation = Propagation.NOT_SUPPORTED)// dont rollback so you can see data in the db


public class MagazineEntityTest {
    @Autowired
    private MagazineEntityRepository MagazineEntityRepository;

    @Test
    void saveMagazineEntity() {
        MagazineEntity newMagazine = new MagazineEntity("ABCD", 5.99, 20, 100, java.time.LocalDateTime.now());
        MagazineEntityRepository.save(newMagazine);

        assertNotNull(newMagazine.getId());

        // Fetch "newMagazine" from the repository
        MagazineEntity magazine = MagazineEntityRepository.findById(newMagazine.getId()).orElse(null);
        assertNotNull(magazine);
        assertEquals("ABCD", magazine.getTitle());
    }

    @Test
    void deleteMagazineEntity(){

        MagazineEntity newMagazine = new MagazineEntity("BCDERT", 5.99, 20, 100, java.time.LocalDateTime.now());
        MagazineEntityRepository.save(newMagazine);

        MagazineEntity magazine = MagazineEntityRepository.findById(newMagazine.getId()).orElse(null);
        assertNotNull(magazine);

        MagazineEntityRepository.delete(magazine);
        MagazineEntity deletedMagazine = MagazineEntityRepository.findById(newMagazine.getId()).orElse(null);
        assertNull(deletedMagazine);

    }

    @Test
    void editMagazineEntity(){

        MagazineEntity newMagazine = new MagazineEntity("BCDERTTT", 5.99, 20, 100, java.time.LocalDateTime.now());
        MagazineEntityRepository.save(newMagazine);

        Long magazineId = newMagazine.getId();
        MagazineEntity magazine = MagazineEntityRepository.findById(magazineId).orElse(null);
        assertNotNull(magazine);

        magazine.setTitle("BCDCCCCCC");
        MagazineEntityRepository.save(magazine);

        MagazineEntity updatedMagazine = MagazineEntityRepository.findById(magazineId).orElse(null);
        assertNotNull(updatedMagazine);
        assertEquals("BCDCCCCCC", updatedMagazine.getTitle());

    }
}
