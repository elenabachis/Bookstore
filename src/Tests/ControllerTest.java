//package Tests;
//
//import main.controller.BestellungController;
//import main.model.Bestellung;
//import main.model.Buch;
//import main.model.Konto;
//import main.repository.BestellungRepo;
//import main.repository.BuchRepo;
//import main.repository.KontoRepo;
//import org.junit.Test;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class ControllerTest {
//
//    @Test
//    public void testBestellungController() throws Exception {
//        Buch b1 = new Buch("1b", "Pride and Prejudice", "Jane Austen", "Classic", 320, 1920, 34);
//        Buch b2 = new Buch("2b", "Pride and Prejudice", "Jane Austen", "Classic", 320, 1920, 34);
//
//        Konto konto1 = new Konto("1K","us1", "1234", LocalDateTime.now(), "Kunde");
//        Konto konto2 = new Konto("2K", "us2", "1234", LocalDateTime.now(), "Kunde");
//        List<Konto> kontoList = new ArrayList<>();
//        kontoList.add(konto1);
//        kontoList.add(konto2);
//
//        List<Buch> chosenBooks = new ArrayList<>();
//        List<Buch> buchList = new ArrayList<>();
//        buchList.add(b1);
//        buchList.add(b2);
//        chosenBooks.add(b1);
//        Bestellung bestellung1 = new Bestellung("1", LocalDateTime.now(), 179, "Unirii", chosenBooks);
//        List<Bestellung> bestellungList = new ArrayList<>();
//        bestellungList.add(bestellung1);
//
//        BuchRepo buchRepo = BuchRepo.getInstance(buchList);
//        KontoRepo kontoRepo = new KontoRepo(kontoList);
//        BestellungRepo bestellungRepo = new BestellungRepo(bestellungList);
//
//        BestellungController bestellungController = new BestellungController(bestellungRepo, kontoRepo, buchRepo);
//        bestellungController.addBestellung(konto1, LocalDateTime.now(), "2", 379, "idhgowuev", chosenBooks);
//
//        assertNotNull(bestellungRepo);
//        assertEquals(2, bestellungRepo.getAll().size());
//    }
//}
