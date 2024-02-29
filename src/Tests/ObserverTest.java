//package Tests;
//
//import main.BuchFactory.MathematikBuchFactory;
//import main.BuchFactory.RomanceBuchFactory;
//import main.model.Buch;
//import main.model.Kunde;
//import main.model.Werbeveranstaltung;
//import org.junit.Test;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ObserverTest {
//
//    @Test
//    public void testEventNotification() {
//        Werbeveranstaltung werbeveranstaltung = new Werbeveranstaltung();
//        Kunde kunde = new Kunde(werbeveranstaltung);
//
//        werbeveranstaltung.createEvent("1W", LocalDateTime.of(2023, 11, 05, 15,30), "Reduceri de sezon!");
//
//        assertNotNull(werbeveranstaltung);
//    }
//
//    @Test
//    public void testBuchFactory(){
//        RomanceBuchFactory romanceBuchFactory = new RomanceBuchFactory();
//        MathematikBuchFactory mathematikBuchFactory = new MathematikBuchFactory();
//        Buch b1 = romanceBuchFactory.createBuch("1b", "Jane Eyre", "Charlotte Bronte", 320, 1920, 34);
//        Buch b2 = mathematikBuchFactory.createBuch("2b", "Essential Calculus Skills Practice Workbook", "Chris McMullen", 150, 2022, 19);
//
//        assertNotEquals("Romance", b2.getGenre());
//        assertEquals("Romance", b1.getGenre());
//        assertEquals("Mathematik", b2.getGenre());
//    }
//}