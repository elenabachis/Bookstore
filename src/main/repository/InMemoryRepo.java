package main.repository;
import main.model.Identifiable;
import java.util.List;

public interface InMemoryRepo<E>  { //extends Identifiable

    void add(E entity);
    void delete(String id);
    E update(String id, E new_entity);
    public List<E> getAll();
    public boolean getById(String index) ;
}
