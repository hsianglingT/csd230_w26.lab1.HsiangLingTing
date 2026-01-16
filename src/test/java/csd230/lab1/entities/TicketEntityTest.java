package csd230.lab1.entities;


import csd230.lab1.repositories.TicketEntityRepository;
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


public class TicketEntityTest {

    @Autowired
    private TicketEntityRepository TicketEntityRepository;

    @Test
    void saveTicketEntity() {
        TicketEntity newTicket = new TicketEntity("This is a Ticket test", 50.0);
        TicketEntityRepository.save(newTicket);

        TicketEntity savedTicket = TicketEntityRepository.findById(newTicket.getId()).orElse(null);
        assertNotNull(savedTicket);
        assertEquals("This is a Ticket test", savedTicket.getDescription());

    }

    @Test
    void deleteTicketEntity() {
        TicketEntity newTicket = new TicketEntity("This is a Ticket test to delete", 75.0);
        TicketEntityRepository.save(newTicket);

        TicketEntity savedTicket = TicketEntityRepository.findById(newTicket.getId()).orElse(null);
        assertNotNull(savedTicket);

        TicketEntityRepository.delete(newTicket);
        TicketEntity deletedTicket = TicketEntityRepository.findById(newTicket.getId()).orElse(null);
        assertNull(deletedTicket);
    }

    @Test
    void editTicketEntity() {
        TicketEntity newTicket = new TicketEntity("This is a Ticket test to edit", 100.0);
        TicketEntityRepository.save(newTicket);

        newTicket.setDescription("This is an edited Ticket description");
        TicketEntityRepository.save(newTicket);

        TicketEntity editedTicket = TicketEntityRepository.findById(newTicket.getId()).orElse(null);
        assertNotNull(editedTicket);
        assertEquals("This is an edited Ticket description", editedTicket.getDescription());
    }

}
