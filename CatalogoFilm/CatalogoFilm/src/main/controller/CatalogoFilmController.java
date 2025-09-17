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

@GetMapping("/titolo")
    public List<Film> cercaPerTitolo(@RequestParam String titolo) {
        return service.cercaPerTitolo(titolo);
    }

    @GetMapping("/genere")
    public List<Film> cercaPerGenere(@RequestParam String genere) {
        return service.cercaPerGenere(genere);
    }

    @PutMapping("/{id}")
    public String modificaFilm(@PathVariable int id, @RequestBody Film film) {
        boolean modificato = service.modificaFilm(id, film);
        return modificato ? "Film modificato con successo!" : "Film non trovato.";
    }

    @DeleteMapping("/{id}")
    public String eliminaFilm(@PathVariable int id) {
        boolean eliminato = service.eliminaFilm(id);
        return eliminato ? "Film eliminato con successo!" : "Film non trovato.";
    }
}
    

 