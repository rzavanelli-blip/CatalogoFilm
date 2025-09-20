package com.example.CatalogoFilm;

import com.example.CatalogoFilm.film;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class CercaFilm {
    // questo è il nostro DB fittizio, è una arraylist
    private final List<film> Lista = new ArrayList<>();

    // definiamo il contatore id autoincrementale
    private final AtomicLong sequenza = new AtomicLong(0);

    // metodo per restituire tutti i dati della collezione (o DB); 
    // "funzione cerca senza criteri" 
    public List<Film> findAll() {
        return new ArrayList<>(Lista);
    }

    // ricerca per ID
    public Optional<Film> findById(Long id) {
        return Lista.stream()
                         .filter(oggetto -> Objects.equals(oggetto.getId(),id))
                         .findFirst(); 
    }

    // metodo per creare un nuovo film assegnando un nuovo ID
    public Film create(Film nuovoFilm) {
        long id = sequenza.incrementAndGet(); // continua la sequenza già esistente 
        nuovoFilm.setId(id);
        Lista.add(nuovoFilm);
        return nuovoFilm;
    }

    // metodo per aggiornare l'oggetto film
    public Film update(Long id, Film filmAggiornato) {
        return findById(id).map(elementoDaAggiornare -> {
            elementoDaAggiornare.settitolo(filmAggiornato.gettitolo());
            elementoDaAggiornare.setregista(filmAggiornato.getregista());
            elementoDaAggiornare.setanno(filmAggiornato.getanno());
            elementoDaAggiornare.setgenere(filmAggiornato.getgenere());
            return elementoDaAggiornare; // verifico in questo modo se è avvenuta la modifica ad opera dei valori definiti in filmAggiornato
        }).orElseThrow(() -> new NoSuchElementException("Aggiornamento non effettuato"));
    }

    // metodo per eliminare sulla base di uno specifico id
    public void deleteById(Long idDaEliminare) {
        boolean rimozioneEffettuata = Lista.removeIf(oggettoRimosso -> oggettoRimosso.getId().equals(idDaEliminare));

        if(!rimozioneEffettuata) {
            throw new NoSuchElementException("Eliminazione non effettuata!");
        }
    }
}
