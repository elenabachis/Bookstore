package main.repository;
import main.model.Identifiable;

import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T extends Identifiable> implements InMemoryRepo<T> {
    List<T> objects = new ArrayList<>();
    public void add(T entity) {
        objects.add(entity);
    }
    public void update(T entity, T newEntity) {
        entity = newEntity;
    }
    public void delete(String id) {
        objects.removeIf(entity -> entity.getId().equals(id));
    }
    public List<T> getAll() {
        return new ArrayList<>(objects);
    }

}