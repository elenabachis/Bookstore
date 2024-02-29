package main.repository;

import main.model.Angestellte;

import java.util.List;

public class AngestellteRepo implements InMemoryRepo<Angestellte> {
    List<Angestellte> angestellteList;

    public AngestellteRepo(List<Angestellte> angestellteList) {

        this.angestellteList = angestellteList;
    }
    
//    @Override
    public void add(Angestellte b){
        angestellteList.add(b);
    }

    //    @Override
    public boolean getById(String id) {
        for (Angestellte Angestellte : angestellteList) {
            if (Angestellte.getIdAngestellte() == id) {
                return true;
            }
        }
        return false;
    }

    public void delete(String id) {
        for (Angestellte Angestellte : angestellteList) {
            if (Angestellte.getIdAngestellte() == id) {
                angestellteList.remove(Angestellte);
            }
        }

    }

    public Angestellte update(String id, Angestellte newAngestellte) {
        for (int i = 0; i < angestellteList.size(); i++) {
            Angestellte Angestellte = angestellteList.get(i);
            if (Angestellte.getIdAngestellte().equals(id)) {
                angestellteList.set(i, newAngestellte);
                return newAngestellte;
            }
        }
        return null;
    }

    public List<Angestellte> getAll() {
        return angestellteList;
    }
}
