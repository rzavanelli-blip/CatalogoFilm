package com.example.catalogofilms.controller;

import com.example.catalogofilms.model.Film;
import com.example.catalogofilms.service.CatalogoFilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")
public class CatalogoFilmController {

@Autowired
private CatalogoFilmService service;

@PostMapping
public String aggiungiFilm(@ResponseBody Film film) {
    service.aggiungiFilm(film);
    return "Film aggiunto con successo!";
}
@GetMapping
public List<Fil> getTuttiIFilm(){
    return service.getTuttiIFilm();
}

    
}
 