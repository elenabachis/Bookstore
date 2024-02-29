package main.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Konto {


    private String idKonto;
    private String username;
    private String password;
    private LocalDateTime joinDatum;
    private String typ;// kunde oder Angestellte

    public Konto(String idKonto,String username, String password, LocalDateTime joinDatum, String typ) {
        this.username = username;
        this.password = password;
        this.joinDatum = joinDatum;
        this.typ = typ;
        this.idKonto=idKonto;
    }

    public String getIdKonto() {
        return idKonto;
    }

    public void setIdKonto(String idKonto) {
        this.idKonto = idKonto;
    }
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public LocalDateTime getJoinDatum() {
        return joinDatum;
    }

    public void setJoinDatum(LocalDateTime joinDatum) {
        this.joinDatum = joinDatum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
