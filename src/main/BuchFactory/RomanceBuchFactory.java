package main.BuchFactory;
import main.model.Buch;

public class RomanceBuchFactory implements  BuchFactory {

    @Override
    public Buch createBuch(String idBuch, String title, String autor, int anzahlSeiten, int erstellungsjahr, float preis) {
        return new Buch(idBuch, title, autor, "Romance", anzahlSeiten, erstellungsjahr, preis);
    }
}
