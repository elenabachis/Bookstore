package main.model;

import main.observer.Observable;
import main.observer.Observer;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Werbeveranstaltung implements Observable {
    private String idWerbe;
    private LocalDateTime dateWerbe;
    private String titelWerbe;
    private ArrayList<Observer> observerKunden;

    public Werbeveranstaltung() {
        observerKunden = new ArrayList<>();
    }

    public void createEvent(String idWerbe, LocalDateTime dateWerbe, String titelWerbe) {
        this.setIdWerbe(idWerbe);
        this.setDateWerbe(dateWerbe);
        this.setTitelWerbe(titelWerbe);
        this.notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerKunden.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observerKunden.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerKunden) {
            observer.update(this.dateWerbe, this.titelWerbe);
        }
    }

    public String getTitelWerbe() {
        return titelWerbe;
    }

    public void setTitelWerbe(String titelWerbe) {
        this.titelWerbe = titelWerbe;
    }

    public LocalDateTime getDateWerbe() {
        return dateWerbe;
    }

    public void setDateWerbe(LocalDateTime dateWerbe) {
        this.dateWerbe = dateWerbe;
    }

    public String getIdWerbe() {
        return idWerbe;
    }

    public void setIdWerbe(String idWerbe) {
        this.idWerbe = idWerbe;
    }
}
