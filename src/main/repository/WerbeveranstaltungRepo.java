package main.repository;

import main.model.Werbeveranstaltung;

import java.time.LocalDateTime;
import java.util.List;

public class WerbeveranstaltungRepo {
    List<Werbeveranstaltung> wbsList;

    public WerbeveranstaltungRepo(List<Werbeveranstaltung> wbsList) {

        this.wbsList = wbsList;
    }

//    @Override
    public void add(Werbeveranstaltung b){
        wbsList.add(b);
    }

    //    @Override
    public Werbeveranstaltung getById(LocalDateTime date) {
        for (Werbeveranstaltung Werbeveranstaltung : wbsList) {
            if (Werbeveranstaltung.getDateWerbe() == date) {
                return Werbeveranstaltung;
            }
        }
        return null;
    }

    public void delete(LocalDateTime date) {
        for (Werbeveranstaltung Werbeveranstaltung : wbsList) {
            if (Werbeveranstaltung.getDateWerbe() == date) {
                wbsList.remove(Werbeveranstaltung);
            }
        }

    }

    public Werbeveranstaltung update(LocalDateTime date, Werbeveranstaltung newWerbeveranstaltung) {
        for (int i = 0; i < wbsList.size(); i++) {
            Werbeveranstaltung Werbeveranstaltung = wbsList.get(i);
            if (Werbeveranstaltung.getDateWerbe().equals(date)) {
                wbsList.set(i, newWerbeveranstaltung);
                return newWerbeveranstaltung;
            }
        }
        return null;
    }

    public List<Werbeveranstaltung> getAll() {
        return wbsList;
    }
}
