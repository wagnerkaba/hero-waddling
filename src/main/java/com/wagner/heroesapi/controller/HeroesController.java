package com.wagner.heroesapi.controller;

import com.wagner.heroesapi.repository.HeroesRepository;
import com.wagner.heroesapi.service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class HeroesController {
    HeroesService heroesService;
    HeroesRepository heroesRepository;


//    private static final org.slf4j.Logger log =
//            org.slf4j.LoggerFactory.getLogger(HeroesController.class);



}
