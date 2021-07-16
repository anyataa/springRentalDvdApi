package com.test.test.backend.repository;

import java.util.List;

import com.test.test.backend.model.filmActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface filmActorRepository extends JpaRepository<filmActorEntity, Integer> {

    @Query(value = "SELECT c.first_name, f.actor_id, f.film_id, m.title, f.film_actor_id, f.last_update FROM actor c LEFT  JOIN film_actor f ON c.actor_id = f.actor_id LEFT  JOIN film m ON m.film_id = f.film_id GROUP BY  f.film_id, f.actor_id, c.first_name, m.title, f.film_actor_id, f.last_update  HAVING f.actor_id = 1", nativeQuery = true)

    public List<filmActorEntity> getActorAndFilm();

}
