package main.controller;

import main.model.Buch;
import main.repository.BuchRepo;

import java.util.List;

public class BuchController {

    private final BuchRepo buchRepo;

    public BuchController(BuchRepo buchRepo) {
        this.buchRepo = buchRepo;
    }

    public boolean delete(String idBuch) {

        for (Buch buch : buchRepo.getAll()) {
            if (buch.getIdBuch().equals(idBuch)) {
                buchRepo.delete(idBuch);
                return true;
            }
        }
        return false;
    }

    public boolean add(String idBuch, String title, String autor, String genre, int anzahlSeiten,
                       int erstellungsjahr, float preis) {

        Buch newBuch = new Buch(idBuch, title, autor, genre, anzahlSeiten, erstellungsjahr, preis);
        for (Buch buch : buchRepo.getAll()) {
            if (buch.getIdBuch().equals(idBuch)) {
                return false;
            }
        }
        buchRepo.add(newBuch);
        return true;
    }

    public boolean update(String idBuch, String title, String autor, String genre, int anzahlSeiten,
                       int erstellungsjahr, float preis) {

        for (Buch buch : buchRepo.getAll()) {
            if (buch.getIdBuch().equals(idBuch)) {
                Buch newBuch = new Buch(idBuch, title, autor, genre, anzahlSeiten, erstellungsjahr, preis);

                buchRepo.update(buch.getIdBuch(), newBuch);
                return true;
            }
        }

        return false;
    }


    public Buch getByID(String id){
        for(Buch b: buchRepo.getAll()){
            if(b.getIdBuch().equals(id))
                return b;
        }
        return null;
    }

    public List<Buch> getAll(){
        return buchRepo.getAll();
    }


}