package csd230.lab1.repositories;

import csd230.lab1.entities.AudioBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AudioBookEntityRepository extends JpaRepository<AudioBookEntity, Long> {
}