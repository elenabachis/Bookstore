package main.controller;

import java.time.LocalDateTime;
import java.util.List;

import main.model.Konto;
import main.repository.KontoRepo;

public class KontoController {
    private final KontoRepo kontoRepo;

    public KontoController(KontoRepo kontoRepo) {
        this.kontoRepo = kontoRepo;
    }

    public void delete(String idKonto) {

        for (Konto konto : kontoRepo.getAll()) {
            if (konto.getIdKonto().equals(idKonto)) {
                kontoRepo.delete(idKonto);

            }
        }
    }

    public boolean add(String idKonto, String username, String password, LocalDateTime joinDatum, String typ) {

        Konto newKonto = new Konto(idKonto, username, password, joinDatum, typ);
        for (Konto konto : kontoRepo.getAll()) {
            if (!konto.getIdKonto().equals(idKonto)) {
                kontoRepo.add(newKonto);
            }
            return true;
        }
        return false;
    }

    public boolean update(String idKonto, String username, String password, LocalDateTime joinDatum, String typ) {

        for (Konto konto : kontoRepo.getAll()) {
            if (konto.getIdKonto().equals(idKonto)) {
                Konto newKonto = new Konto(idKonto, username, password, joinDatum, typ);

                kontoRepo.update(konto.getIdKonto(), newKonto);
            }
            return true;
        }
        return false;
    }
    public Konto getByID (String idKonto){
        for (Konto b : kontoRepo.getAll()) {
            if (b.getIdKonto().equals(idKonto))
                return b;
        }
        return null;
    }
    public List<Konto> getAll () {
        return kontoRepo.getAll();
    }
}
