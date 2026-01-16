package csd230.lab1.repositories;

import csd230.lab1.entities.DigitalProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DigitalProductEntityRepository extends JpaRepository<DigitalProductEntity, Long> {
}