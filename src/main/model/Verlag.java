package main.model;

public class Verlag {
    

    private String idVerlag;
    private String name;
    private String adresse;
    private String telefonNummer;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdVerlag() {
        return idVerlag;
    }

    public void setIdVerlag(String idVerlag) {
        this.idVerlag = idVerlag;
    }
}
