package main.repository;

import main.model.Wishlist;

import java.util.List;

public class WishlistRepo implements InMemoryRepo<Wishlist> {

    List<Wishlist> wishList;

    public WishlistRepo(List<Wishlist> wishlist) {

        this.wishList = wishlist;
    }

    public void add(Wishlist k){
        wishList.add(k);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Wishlist update(String id, Wishlist new_entity) {
        return null;
    }

    public boolean getById(String id) {
        for (Wishlist wishlist : wishList) {
            if (wishlist.getIdWishlist() == id) {
                return true;
            }
        }
        return false;
    }

    public List<Wishlist> getAll() {
        return wishList;
    }
}
