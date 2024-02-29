package main.model;

import main.observer.Display;
import main.observer.Observer;

import java.time.LocalDateTime;
import java.util.Date;

public class Kunde implements Observer, Display {
    private String name;
    private String vorname;
    private String email;
    private Date geburtsDatum;
    private String idKunde;
    private Werbeveranstaltung werbeveranstaltung;

    public Kunde(Werbeveranstaltung werbeveranstaltung) {
        this.werbeveranstaltung = werbeveranstaltung;
        this.werbeveranstaltung.registerObserver(this);
    }

    @Override
    public void update(LocalDateTime dateWerbe, String titelWerbe) {
        this.display(dateWerbe, titelWerbe);
    }

    @Override
    public void display(LocalDateTime dateWerbe, String titelWerbe) {
        System.out.println("There is a new Event: " + titelWerbe);
        System.out.println("The date is: " + dateWerbe);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public String getIdKunde() {
        return idKunde;
    }

    public void setIdKunde(String idKunde) {
        this.idKunde = idKunde;
    }

}
