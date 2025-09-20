package com.example.CatalogoFilm.web;

import com.example.studenti.model.Studente;
import com.example.studenti.service.StudenteService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.net.URI;

// il controller "traduce" le richieste HTTP
// in richieste per il Service

@RestController
@RequestMapping("/Film")
public class FilmController {
    private final StudenteService service;

    public FilmController(StudenteService service) {
        this.service = service;
    }

    // GET lista completa
    // GET /Film
    @GetMapping
    public List<Film> getAll() {
        return service.findAll();
    }

    // GET id specifico
    @GetMapping("/{id}")
    public ResponseEntity<Film> getById(@PathVariable Long id) {
        return service.findById(id)
                      .map(ResponseEntity::ok) // valore 200 + body del mio post
                      // equivalente a .map(ResponseEntity.ok().body())
                      .orElse(ResponseEntity.notFound().build()); // restituisce 404 not found
    }   

    // POST
    @PostMapping
        public ResponseEntity<Film> create(@RequestBody Film body) {
            Film FilmCreato = service.create(body); // nuovo elemento nel DB
            
            return ResponseEntity.created(URI.create("/Film"+FilmCreato.getId()))
                                 .body(FilmCreato);
    } 

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Film> update(@PathVariable Long id, @RequestBody Film body) {
        Film FilmAggiornato = service.update(id, body);
        return ResponseEntity.ok().body(FilmAggiornato); // 200 + il valore aggiornato
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
