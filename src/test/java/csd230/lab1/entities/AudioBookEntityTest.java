package csd230.lab1.entities;


import csd230.lab1.repositories.AudioBookEntityRepository;
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


public class AudioBookEntityTest {
    @Autowired
    private AudioBookEntityRepository audioBookEntityRepository;

    @Test
    void saveAudioBookEntity() {
        AudioBookEntity newAudioBook = new AudioBookEntity(
                15.99,
                "http://example.com/audiobook.mp3",
                "This is an AudioBook test",
                "John Smith",
                "John Doe"

        );
        audioBookEntityRepository.save(newAudioBook);

        AudioBookEntity savedAudioBook = audioBookEntityRepository.findById(newAudioBook.getId()).orElse(null);
        assertNotNull(savedAudioBook);
        assertEquals("This is an AudioBook test", savedAudioBook.getTitle());
    }

    @Test
    void deleteAudioBookEntity() {
        AudioBookEntity newAudioBook = new AudioBookEntity(
                12.99,
                "http://example.com/audiobook2.mp3",
                "Another AudioBook test",
                "Alice Johnson",
                "Bob Brown"
        );
        audioBookEntityRepository.save(newAudioBook);
        Long id = newAudioBook.getId();
        AudioBookEntity savedAudioBook = audioBookEntityRepository.findById(newAudioBook.getId()).orElse(null);
        assertNotNull(savedAudioBook);


        audioBookEntityRepository.deleteById(id);
        AudioBookEntity deletedAudioBook = audioBookEntityRepository.findById(id).orElse(null);
        assertNull(deletedAudioBook);
    }

    @Test
    void editAudioBookEntity() {
        AudioBookEntity newAudioBook = new AudioBookEntity(
                9.99,
                "http://example.com/audiobook3.mp3",
                "Editable AudioBook",
                "Charlie Davis",
                "Diana Evans"
        );
        audioBookEntityRepository.save(newAudioBook);

        AudioBookEntity savedAudioBook = audioBookEntityRepository.findById(newAudioBook.getId()).orElse(null);
        assertNotNull(savedAudioBook);

        savedAudioBook.setPrice(14.99);
        audioBookEntityRepository.save(savedAudioBook);

        AudioBookEntity editedAudioBook = audioBookEntityRepository.findById(newAudioBook.getId()).orElse(null);
        assertNotNull(editedAudioBook);
        assertEquals(14.99, editedAudioBook.getPrice());
    }
}
