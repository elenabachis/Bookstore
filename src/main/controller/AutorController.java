package main.controller;

import main.model.Autor;
import main.repository.AutorRepo;

public class AutorController {
    private final AutorRepo autorRepo;

    public AutorController(AutorRepo autorRepo) {
        this.autorRepo = autorRepo;
    }

    public void addAutorRequest(String idAutor, String name, String vorname) {
        Autor newAutor = new Autor(idAutor, name, vorname);

        // Call the repository to add the new Autor to the database
        autorRepo.add(newAutor);

    }
}

