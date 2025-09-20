package com.example.CatalogoFilm;
public class Film {
    private int id;
    private String titolo;
    private String regista;
    private int anno;
    private String genere;

    // Costruttore
    public Film() {}

    // Costruttore con parametri
    public Film(int id, String titolo, String regista, int anno, String genere) {
        this.id = id;
        this.titolo = titolo;
        this.regista = regista;
        this.anno = anno;
        this.genere = genere;
    }

    // Metodi getter e setter
    public int getId() { return id; }
    public String getTitolo() { return titolo; }
    public String getRegista() { return regista; }
    public int getAnno() { return anno; }
    public String getGenere() { return genere; }

    public void setId(int id) { this.id = id; }
    public void setTitolo(String titolo) { this.titolo = titolo; }
    public void setRegista(String regista) { this.regista = regista; }
    public void setAnno(int anno) { this.anno = anno; }
}