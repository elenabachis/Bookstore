package main.model;

import main.repository.Repository;

//@Entity
//@Table(name = "buch")
public class Buch implements Identifiable{

    private String idBuch;
    private String title;
    private String autor;
    private String genre;
    private int anzahlSeiten;
    private int erstellungsjahr;
    private float preis;

    public Buch(String idBuch, String title, String autor, String genre, int anzahlSeiten, int erstellungsjahr, float preis) {
        this.idBuch = idBuch;
        this.title = title;
        this.autor = autor;
        this.genre = genre;
        this.anzahlSeiten = anzahlSeiten;
        this.erstellungsjahr = erstellungsjahr;
        this.preis = preis;
    }

    @Override
    public String toString() {
        return "Buch{" +
                "idProdukt=" + idBuch +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", genre='" + genre + '\'' +
                ", anzahlSeiten=" + anzahlSeiten +
                ", erstellungsjahr=" + erstellungsjahr +
                ", preis=" + preis +
                '}';
    }

//
    public String getIdBuch() {
        return idBuch;
    }

//    @Override
//    public Object getId() {
//        return idBuch;
//    }

    public void setIdBuch(String idBuch) {
        this.idBuch = idBuch;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public int getAnzahlSeiten() {
        return anzahlSeiten;
    }

    public void setAnzahlSeiten(int anzahlSeiten) {
        this.anzahlSeiten = anzahlSeiten;
    }

    public int getErstellungsjahr() {
        return erstellungsjahr;
    }

    public void setErstellungsjahr(int erstellungsjahr) {
        this.erstellungsjahr = erstellungsjahr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getId() {
        return idBuch;
    }
}
