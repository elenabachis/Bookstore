package main.repository;

import main.model.Kunde;

import java.util.List;

public class KundeRepo implements InMemoryRepo<Kunde> {
    List<Kunde> kundeList;

    public KundeRepo(List<Kunde> kundeList) {

        this.kundeList = kundeList;
    }

    public void add(Kunde b){
        kundeList.add(b);
    }

    public boolean getById(String id) {
        for (Kunde Kunde : kundeList) {
            if (Kunde.getIdKunde() == id) {
                return true;
            }
        }
        return false;
    }

    public void delete(String id) {
        for (Kunde Kunde : kundeList) {
            if (Kunde.getIdKunde() == id) {
                kundeList.remove(Kunde);
            }
        }

    }

    public Kunde update(String id, Kunde newKunde) {
        for (int i = 0; i < kundeList.size(); i++) {
            Kunde Kunde = kundeList.get(i);
            if (Kunde.getIdKunde().equals(id)) {
                kundeList.set(i, newKunde);
                return newKunde;
            }
        }
        return null;
    }

    public List<Kunde> getAll() {
        return kundeList;
    }

}
