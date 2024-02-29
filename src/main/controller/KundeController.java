package main.controller;

import main.repository.KontoRepo;
import main.repository.KundeRepo;

public class KundeController {

    private final KundeRepo kundeRepo;

    public KundeController(KundeRepo kundeRepo) {
        this.kundeRepo = kundeRepo;
    }

}
