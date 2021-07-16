package com.test.test.backend.repository;

import java.util.List;

import com.test.test.backend.model.filmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface filmRepository extends JpaRepository<filmEntity, Integer> {

}
