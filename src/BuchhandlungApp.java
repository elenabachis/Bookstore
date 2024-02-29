import main.controller.BestellungController;
import main.controller.BuchController;
import main.controller.KontoController;
import main.discount.DiscountStrategy;
import main.discount.NoDiscount;
import main.discount.PercentageDiscount;
import main.model.*;
import main.BuchFactory.*;
import main.repository.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BuchhandlungApp {
    public static void main(String[] args) throws SQLException {


        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            String jbdcURL = "jdbc:mysql://localhost:3306/bookstore";
            String usernameDB = "root";
            String passwordDB = "Cata22";
            Connection connection = DriverManager.getConnection(jbdcURL, usernameDB, passwordDB);


            RomanceBuchFactory romanceBuchFactory = new RomanceBuchFactory();
            ActionBuchFactory actionBuchFactory = new ActionBuchFactory();
            BiologieBuchFactory biologieBuchFactory = new BiologieBuchFactory();
            MysteryBuchFactory mysteryBuchFactory = new MysteryBuchFactory();
            ThrillerBuchFactory thrillerBuchFactory = new ThrillerBuchFactory();
            YABuchFactory yaBuchFactory = new YABuchFactory();
            ChemieBuchFactory chemieBuchFactory = new ChemieBuchFactory();
            MathematikBuchFactory mathematikBuchFactory = new MathematikBuchFactory();
            PhysikBuchFactory physikBuchFactory = new PhysikBuchFactory();
            PsychologieBuchFactory psychologieBuchFactory = new PsychologieBuchFactory();

            Buch b1 = romanceBuchFactory.createBuch("1b", "Pride and Prejudice", "Jane Austen", 212, 1889, 49);
            Buch b2 = romanceBuchFactory.createBuch("2b", "Jane Eyre", "Charlotte Bronte", 320, 1920, 34);
            Buch b3 = actionBuchFactory.createBuch("3b", "Jocurile foamei", "Suzanne Collins", 320, 2008, 25);
            Buch b4 = actionBuchFactory.createBuch("4b", "Acolo unde canta racii", "Delia Owens", 320, 2016, 39);
            Buch b5 = mysteryBuchFactory.createBuch("5b", "Istoria secreta", "Donna Tartt", 490, 1991, 55);
            Buch b6 = physikBuchFactory.createBuch("6b", "Mehr als nur Atome", "Sabine Hossenfelder", 250, 2023, 35);
            Buch b7 = yaBuchFactory.createBuch("7b", "Gallant", "V.E.Schwab", 345, 2017, 350);

//            Konto konto1 = new Konto("1", "us1", "1234", LocalDateTime.now(), "Kunde");
//            Konto konto2 = new Konto("2", "us2", "1234", LocalDateTime.now(), "Kunde");
//            Konto konto3 = new Konto("3", "us3", "1389", LocalDateTime.now(), "Angestellte");
//            Konto konto4 = new Konto("4", "us4", "1234", LocalDateTime.now(), "Angestellte");
//            Konto konto5 = new Konto("5", "us5", "1234", LocalDateTime.now(), "Kunde");
//            Konto konto6 = new Konto("6", "us6", "1234", LocalDateTime.now(), "Kunde");

            List<Konto> kontoList = new ArrayList<>();
            List<Konto> kontosToNotify = new ArrayList<>();

            List<Buch> buchList = new ArrayList<>();
            buchList.add(b1);
            buchList.add(b2);
            buchList.add(b3);
            buchList.add(b4);
            buchList.add(b5);
            buchList.add(b6);
            buchList.add(b7);

//            kontoList.add(konto1);
//            kontoList.add(konto2);
//            kontoList.add(konto3);

//            List<Buch> chosenBooks = chooseRandomBooks(buchList);

            DiscountStrategy percentageDiscount = new PercentageDiscount(0.1f); // 10% discount
            DiscountStrategy noDiscount = new NoDiscount();
            DiscountStrategy discountStrategy = new NoDiscount();
            Bestellung bestellung6 = new Bestellung("6", LocalDateTime.now(), 40, "Unirii", buchList);
            Bestellung bestellung5 = new Bestellung("5", LocalDateTime.now(), 889, "Piata Cipariu", buchList);
            Bestellung bestellung4 = new Bestellung("4", LocalDateTime.now(), 58, "Principala", buchList);
            Bestellung bestellung3 = new Bestellung("3", LocalDateTime.now(), 290, "Macinului", buchList);
            Bestellung bestellung2 = new Bestellung("2", LocalDateTime.now(), 999, "Unirii", buchList);
            Bestellung bestellung1 = new Bestellung("1", LocalDateTime.now(), 179, "Unirii", buchList);
            List<Bestellung> bestellungList = new ArrayList<>();

            bestellungList.add(bestellung1);
            bestellungList.add(bestellung2);
            bestellungList.add(bestellung3);
            bestellungList.add(bestellung4);
            bestellungList.add(bestellung5);
            bestellungList.add(bestellung6);

            BuchRepo buchRepo = BuchRepo.getInstance(buchList);// Annahme: BuchRepo ist bereits implementiert
            KontoRepo kontoRepo = new KontoRepo(kontoList, connection); // Annahme: KontoRepo ist bereits implementiert
            BestellungRepo bestellungRepo = new BestellungRepo(bestellungList, connection); // Annahme: BestellungRepo ist bereits implementiert

            BuchController buchController = new BuchController(buchRepo);
            KontoController kontoController = new KontoController(kontoRepo);
            BestellungController bestellungController = new BestellungController(bestellungRepo, kontoRepo, buchRepo);

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Menu:");
                System.out.println("1. Alle Bücher anzeigen: ");
                System.out.println("2. Wollen einzuloggen?");
                System.out.println("3. Alle Kontos anschauen:");
                System.out.println("4. Eine Bestellung aufgeben:");
                System.out.println("5. Willst du an Veranstaltungen teilnehmen?");
                System.out.println("6. Create new event");
                System.out.println("0. Beenden");
                System.out.print("Wähle eine Option: ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        for (Buch book : buchRepo.getAll()) {
                            System.out.println(book.toString());
                        }
                        break;
                    case 2:
                        System.out.println("Enter idKonto:");
                        String idKonto = scanner.next();

                        Konto loggedInAccount = kontoController.getByID(idKonto);

                        if (loggedInAccount != null) {
                            System.out.println("Login successful!");

                            // Display options for updating account information
                            System.out.println("Settings:");
                            System.out.println("1. Update username");
                            System.out.println("2. Update password");
                            System.out.println("3. Delete account");
                            System.out.println("0. Return to main menu");
                            System.out.print("Choose an option: ");

                            int updateOption = scanner.nextInt();

                            switch (updateOption) {
                                case 1:
                                    System.out.println("Enter new username:");
                                    String newUsername = scanner.next();
                                    loggedInAccount.setUsername(newUsername);
                                    break;
                                case 2:
                                    System.out.println("Enter new password:");
                                    String newPassword = scanner.next();
                                    loggedInAccount.setPassword(newPassword);
                                    break;

                                case 3:
                                    kontoController.delete(idKonto);
                                    System.out.println("account deleted successfully!");
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Invalid option. Please try again.");
                                    break;
                            }

                            // Update the account
                            boolean updateSuccessful = kontoController.update(loggedInAccount.getIdKonto(), loggedInAccount.getUsername(), loggedInAccount.getPassword(), loggedInAccount.getJoinDatum(), loggedInAccount.getTyp());
                            if (updateSuccessful) {
                                System.out.println("Account updated successfully.");
                            } else {
                                System.out.println("Failed to update account.");
                            }
                        } else {
                            System.out.println("Invalid username or password. Please try again or sign up!");

                            System.out.println("Enter username:");
                            String newUsername = scanner.next();
                            System.out.println("Enter password:");
                            String password = scanner.next();
                            System.out.println("Enter account type:");
                            String accountType = scanner.next();
                            String newIdKonto = generateRandomID(2);
                            boolean accountAdded = kontoController.add(newIdKonto, newUsername, password, LocalDateTime.now(), accountType);

                            if (accountAdded) {
                                System.out.println("Account added successfully.");
                            } else {
                                System.out.println("Failed to add account. Username already exists.");
                            }
                            break;

                        }
                        break;
                    case 3:
                        for (Konto konto : kontoController.getAll()) {
                            System.out.println(konto.getUsername());
                        }
                        break;
                    case 4:










//                        System.out.println("Enter your username:");
//                        String userBestellung = scanner.next();
//
//                        Konto loggedInBestellung = kontoController.getByID(userBestellung);
//
//                        if (loggedInBestellung != null) {
//                            String orderId = generateRandomString(4);
//
//                            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//                            System.out.println("Enter delivery address:");
//                            String deliveryAddress = "";
//
//                            try {
//                                deliveryAddress = reader.readLine();
//                            } catch (IOException e) {
//                                System.out.println("Error reading input: " + e.getMessage());
//                            }
//
//                            float totalPrice = bestellungController.calculateTotalPrice(chosenBooks);
//                            if (totalPrice > 200) {
//                                //float newPrice = percentageDiscount.applyDiscount(totalPrice);
//                                discountStrategy = percentageDiscount;
//                                System.out.println("Initial price: " + totalPrice);
//                            } else {
//                                System.out.println("Total price:" + totalPrice);
//                            }
//
//                            try {
//                                float bestellungPreis = discountStrategy.applyDiscount(totalPrice);
//                                bestellungController.addBestellung(loggedInBestellung, LocalDateTime.now(), orderId, totalPrice, deliveryAddress, chosenBooks);
//                                System.out.println("Order placed successfully.");
//                            } catch (Exception e) {
//                                System.out.println("Error placing order: " + e.getMessage());
//                            }
//                        } else {
//                            System.out.println("Invalid username. Please try again.");
//                        }
//                        break;
                    case 5:
                        System.out.println("Enter your Account id:");
                        String idAccount = scanner.next();

                        Konto loggedIn = kontoController.getByID(idAccount);
                        if (loggedIn.getTyp() == "Kunde") {
                            System.out.println("Wollen Sie notified werden? Ja/Nein");
                            String answer = scanner.next();
                            if (answer.equals("Ja")) {
                                kontosToNotify.add(loggedIn);
                                System.out.println("You'll receive an email for the next event!");
                            }
                            Werbeveranstaltung werbeveranstaltung = new Werbeveranstaltung();
                            Kunde kunde1 = new Kunde(werbeveranstaltung);
//                        werbeveranstaltung.createEvent(LocalDateTime.of(2023, 11, 02, 12, 0, 0), "Reduceri de sezon!");
                        } else {
                            System.out.println("Error, du bist nicht einen Kunden!");
                        }

                    case 6:
                        System.out.println("Enter your Account id:");
                        String newUserWerbe = scanner.next();
                        Konto loggedInAGST = kontoController.getByID(newUserWerbe);
//                    if (loggedInAGST.getTyp() == "Angestellte") {
//                        Werbeveranstaltung werbeveranstaltung = new Werbeveranstaltung();
//                        werbeveranstaltung.createEvent(LocalDateTime.of(2023, 11, 02, 12, 0, 0), "Reduceri de sezon!");
//
//                    }

                    case 0:
                        System.out.println("Programm wird beendet.");
                        break;
                    default:
                        System.out.println("Ungültige Auswahl. Versuche es erneut.");
                }
            } while (choice != 0);


//        public static List<Buch> chooseRandomBooks (List < Buch > buchList) {
//            List<Buch> chosenBooks = new ArrayList<>();
//            Random random = new Random();
//
//            // Generate a random number of books to choose between 1 and buchList.size()
//            int numberOfBooksToChoose = random.nextInt(buchList.size()) + 1;
//
//            for (int i = 0; i < numberOfBooksToChoose; i++) {
//                int randomIndex = random.nextInt(buchList.size());
//                chosenBooks.add(buchList.get(randomIndex));
//                buchList.remove(randomIndex);
//            }
//
//            return chosenBooks;
//        }
            // Continue with your database operations
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomString ( int length){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    private static final String INTEGERS = "0123456789";

    public static String generateRandomID(int length){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(INTEGERS.length());
            char randomChar = INTEGERS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

}