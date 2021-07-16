package com.test.test.backend.controller;

import java.util.List;

import com.test.test.backend.model.filmEntity;
import com.test.test.backend.repository.filmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actorApi")
public class filmController {
    @Autowired
    private filmRepository filmRepo;

    @GetMapping("/allFilms")
    public List<filmEntity> getAllFilms() {

        return filmRepo.findAll();
    }

}
