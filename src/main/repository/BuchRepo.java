package main.repository;

import main.model.Buch;

import java.util.List;

public class BuchRepo extends Repository<Buch> {

    private List<Buch> buchList;
    private static BuchRepo instance;

    private BuchRepo(List<Buch> buchList) {
        this.buchList = buchList;
    }

    public static  BuchRepo getInstance(List<Buch> buchList) {
        if (instance == null) {
            instance = new BuchRepo(buchList);
        }
        return instance;
    }

    public List<Buch> getBuchList() {
        return buchList;
    }

    public void setBuchList(List<Buch> buchList) {
        this.buchList = buchList;
    }

    public void add(Buch b) {
        buchList.add(b);
    }

    public void delete(String id) {
        for (Buch buch : buchList) {
            if (buch.getIdBuch() == id) {
                buchList.remove(buch);
            }
        }

    }

    public Buch update(String id, Buch newBuch) {
        for (int i = 0; i < buchList.size(); i++) {
            Buch buch = buchList.get(i);
            if (buch.getIdBuch().equals(id)) {
                buchList.set(i, newBuch);
                return newBuch;
            }
        }
        return null;
    }

    public List<Buch> getAll() {
        return buchList;
    }

    public Buch getByTitel(String titel) {
        for (Buch buch : buchList) {
            if (buch.getTitle() == titel) {
                return buch;
            }
        }
        return null;
    }

//    @Override
//    public Buch getId() {
//        for (Buch buch : buchList) {
//            if (buch.getId() == id) {
//                return buch;
//            }
//        }
//        return null;
//    }
    public boolean getById(String id) {
        for (Buch buch : buchList) {
            if (buch.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
