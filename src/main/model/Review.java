package main.model;

public class Review {

    public String getIdReview() {
        return idReview;
    }

    public void setIdReview(String idReview) {
        this.idReview = idReview;
    }

    private String idReview;
    private String text;
    private int anzahlSternchen;

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                '}';
    }

    public int getAnzahlSternchen() {
        return anzahlSternchen;
    }

    public void setAnzahlSternchen(int anzahlSternchen) {
        this.anzahlSternchen = anzahlSternchen;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}