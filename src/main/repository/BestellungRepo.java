package main.repository;

import main.model.Bestellung;
import main.model.Buch;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BestellungRepo implements InMemoryRepo<Bestellung> {

    private List<Bestellung> bestellungList;

    private Connection connection; // Add a connection field

    public BestellungRepo(List<Bestellung> bestellungList, Connection connection) {
        this.bestellungList = bestellungList;
        this.connection = establishDatabaseConnection();
    }

    public BestellungRepo(List<Bestellung> bestellungList) {
    }

    private Connection establishDatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/bookstore";
            String username = "root";
            String password = "Cata22";
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to establish a database connection");
        }
    }

    public void add(Bestellung bestellung) {
        String sql = "INSERT INTO bestellung (idBestellung, datum, gesamtpreis, adresse) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bestellung.getIdBestellung());
            statement.setString(2, String.valueOf(bestellung.getDatum()));
            statement.setString(3, String.valueOf(bestellung.getGesamtpreis()));
            statement.setString(4, bestellung.getAdresse());
            statement.setString(5, String.valueOf(bestellung.getListeBucher()));
            // set other parameters
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getById(String id) {
        String sql = "SELECT COUNT(*) FROM bestellung WHERE id_bestellung = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void delete(String id) {
        String sql = "DELETE FROM bestellung WHERE idBestellung = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed (e.g., log, throw a custom exception, etc.).
        }
    }

    public Bestellung update(String id, Bestellung newBestellung) {
        String sql = "UPDATE bestellung SET gesamtpreis = ?, adresse = ?, listeBucher=? WHERE id_bestellung = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, String.valueOf(newBestellung.getGesamtpreis()));
            statement.setString(2, newBestellung.getAdresse());
            statement.setString(3, String.valueOf(newBestellung.getListeBucher()));
            // set other parameters

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                return newBestellung; // Update successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Update failed
    }

    public List<Bestellung> getAll() {
        String sql = "SELECT * FROM bestellung";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                        //LocalDateTime datum, String idBestellung, float gesamtpreis, String adresse, List<Buch> listeBucher
                        String idBestellung = resultSet.getString("idBestellung");
                        LocalDateTime datum = (java.time.LocalDateTime) resultSet.getObject("datum");
                        Float gesamtpreis = resultSet.getFloat("gesamtPreis");
                        String adresse = resultSet.getString("adresse");
                        List<Buch> listeBucher= (List<Buch>) resultSet.getArray("listeBucher");
                Bestellung bestellung = new Bestellung(idBestellung, datum, gesamtpreis, adresse, listeBucher);
                bestellungList.add(bestellung);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bestellungList;
    }
}