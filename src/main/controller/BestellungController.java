package main.controller;

import main.model.Bestellung;
import main.model.Buch;
import main.model.Konto;
import main.repository.BestellungRepo;
import main.repository.BuchRepo;
import main.repository.KontoRepo;

import java.time.LocalDateTime;
import java.util.List;

public class BestellungController {

    private final BestellungRepo bestellungRepo;
    private final KontoRepo kontoRepo;
    private final BuchRepo buchRepo;

    public BestellungController(BestellungRepo bestellungRepo, KontoRepo kontoRepo, BuchRepo buchRepo) {
        this.buchRepo = buchRepo;
        this.kontoRepo = kontoRepo;
        this.bestellungRepo = bestellungRepo;
    }


    public void deleteBestellung(String id) {
        bestellungRepo.delete(id);
    }

    public void addBestellung(Konto konto, LocalDateTime datum, String idBestellung, float gesamtPreis, String adresse, List<Buch> chosenBooks) throws Exception {

        if (kontoRepo.getById(konto.getUsername())) {

            for (Buch buch : chosenBooks) {
                if (buchRepo.getById(buch.getIdBuch())) {
                    Bestellung bestellung = new Bestellung(idBestellung, datum, gesamtPreis, adresse, chosenBooks);
                    bestellungRepo.add(bestellung);
                } else {
                    throw new Exception("Error");
                }
            }
        }
    }

    public void updateBestellung(String id, Bestellung newBestellung) {
        bestellungRepo.update(id, newBestellung);
        // Optionally, handle the result or perform additional actions after the update
    }

    public Bestellung getByID(String id) {
        for (Bestellung b : bestellungRepo.getAll()) {
            if (b.getIdBestellung().equals(id))
                return b;
        }
        return null;
    }

    public List<Bestellung> getAlleBestellungen() {
        return bestellungRepo.getAll();
    }

    public float calculateTotalPrice(List<Buch> chosenBooks) {
        float totalPrice = 0;

        for (Buch book : chosenBooks) {
            totalPrice += book.getPreis();
        }

        return totalPrice;
    }

}
