package csd230.lab1.repositories;

import csd230.lab1.entities.EbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EbookEntityRepository extends JpaRepository<EbookEntity, Long> {
}