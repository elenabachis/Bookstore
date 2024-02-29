package main.model;

import java.util.Date;

public class Angestellte {

    private String name;
    private String vorname;
    private String email;
    private Date geburtsDatum;
    private String idAngestellte;
    private String rolle;
    private int gehalt;

    @Override
    public String toString() {
        return "Angestellte{" +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", email='" + email + '\'' +
                ", geburtsDatum=" + geburtsDatum +
                ", idAngestellte='" + idAngestellte + '\'' +
                ", rolle='" + rolle + '\'' +
                ", gehalt=" + gehalt +
                '}';
    }

    public String getIdAngestellte() {
        return idAngestellte;
    }

    public void setIdAngestellte(String idAngestellte) {
        this.idAngestellte = idAngestellte;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public int getGehalt() {
        return gehalt;
    }

    public void setGehalt(int gehalt) {
        this.gehalt = gehalt;
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
}
