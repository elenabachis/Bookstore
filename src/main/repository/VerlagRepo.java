package main.repository;

import main.model.Verlag;

import java.util.List;
import java.util.Objects;

public class VerlagRepo {
    private static VerlagRepo instance; // The single instance of VerlagRepo

    private List<Verlag> verlagList;

    private VerlagRepo(List<Verlag> verlagList) {
        this.verlagList = verlagList;
    }

    // Use a synchronized method to ensure thread safety during initialization
    public static synchronized VerlagRepo getInstance(List<Verlag> verlagList) {
        if (instance == null) {
            instance = new VerlagRepo(verlagList);
        }
        return instance;
    }

    public void add(Verlag b) {
        verlagList.add(b);
    }

    public Verlag getById(String email) {
        for (Verlag verlag : verlagList) {
            if (Objects.equals(verlag.getEmail(), email)) {
                return verlag;
            }
        }
        return null;
    }

    public void delete(String email) {
        verlagList.removeIf(verlag -> Objects.equals(verlag.getEmail(), email));
    }

    public Verlag update(String email, Verlag newVerlag) {
        for (int i = 0; i < verlagList.size(); i++) {
            Verlag verlag = verlagList.get(i);
            if (Objects.equals(verlag.getEmail(), email)) {
                verlagList.set(i, newVerlag);
                return newVerlag;
            }
        }
        return null;
    }

    public List<Verlag> getAll() {
        return verlagList;
    }
}
