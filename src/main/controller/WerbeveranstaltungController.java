package main.controller;

import main.model.KundeObserver;
import main.repository.KontoRepo;

public class WerbeveranstaltungController {

    private final KontoRepo kontoRepo;

    public WerbeveranstaltungController(KontoRepo kontoRepo) {
        this.kontoRepo = kontoRepo;
    }

//    public void notifyAllClients(String message) {
//        for (KundeObserver client :) {
//            client.getUpdate(message);
//        }
//    }
//
//    @Override
//    public void subscribe(KundeObserver client) {
//        clients.add(client);
//    }
//
//    @Override
//    public void unsubscribe(KundeObserver client) {
//        clients.remove(client);
//
//    }
}