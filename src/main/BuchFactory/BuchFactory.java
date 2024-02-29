package main.BuchFactory;

import main.model.Buch;

public interface BuchFactory {

    Buch createBuch(String idBuch, String title, String autor, int anzahlSeiten, int erstellungsjahr, float preis);

}

