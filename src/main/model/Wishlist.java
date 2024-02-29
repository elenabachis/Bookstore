package main.model;

import java.util.ArrayList;

public class Wishlist {
    private String idWishlist;
    private ArrayList<Buch> listeBucher;

    public String getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(String idWishlist) {
        this.idWishlist = idWishlist;
    }

    public ArrayList<Buch> getListeBucher() {
        return listeBucher;
    }

    public void setListeBucher(ArrayList<Buch> listeBucher) {
        this.listeBucher = listeBucher;
    }
}
