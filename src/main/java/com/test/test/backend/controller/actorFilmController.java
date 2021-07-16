package com.test.test.backend.controller;

import java.util.List;

import com.test.test.backend.model.filmActorEntity;
import com.test.test.backend.model.filmEntity;
import com.test.test.backend.repository.filmActorRepository;
import com.test.test.backend.repository.filmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actorApi")
public class actorFilmController {
    @Autowired
    private filmActorRepository filmActorRepo;

    @GetMapping("/getActorFilm")
    public List<filmActorEntity> getActorFilm() {
        return filmActorRepo.findAll();

    }

    @GetMapping("/actorFilm")
    public List<filmActorEntity> getActorFilmListQuery() {
        return filmActorRepo.getActorAndFilm();
    }

    @GetMapping("/actorFilmByFirstName")
    public List<filmActorEntity> getActorAndFilmByFirstName(@RequestParam("first_name") String first_name) {
        return filmActorRepo.getActorAndFilmBasedOnFirstName(first_name);
    }

}
