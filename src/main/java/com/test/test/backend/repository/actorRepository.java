package com.test.test.backend.repository;

import java.sql.Date;
import java.util.List;

import com.test.test.backend.model.actorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface actorRepository extends JpaRepository<actorEntity, Integer> {

    // get all last name from actor
    @Query(value = "select last_name from actor", nativeQuery = true)
    public List<String> getActorLastName();

    @Query(value = "select * from actor where last_name = ?1 ", nativeQuery = true)
    public List<actorEntity> getActorLastNameBasedOnParam(@Param("wanted_name") String wanted_name);
    // public List<actorEntity> getActorLastNameBasedOnParam(String wanted_name);

    // get old actor before last 2013
    @Query(value = "select * from actor where last_update < '2013-10-01'  ", nativeQuery = true)
    public List<actorEntity> getOldActor(String last_update);

}
