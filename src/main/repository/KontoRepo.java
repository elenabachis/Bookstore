package main.repository;

import main.model.Konto;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class KontoRepo implements InMemoryRepo<Konto> {

    private List<Konto> kontoList;
    private Connection connection;
    public KontoRepo(List<Konto> kontoList, Connection connection) {
        this.kontoList = kontoList;
        this.connection = establishDatabaseConnection();
    }

    private Connection establishDatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/bookstore";
            String username = "root";
            String password = "Cata22";
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to establish a database connection");
        }
    }
    public KontoRepo(List<Konto> kontoList) {
    }

    public void add(Konto k) {
        String sql = "INSERT INTO konto (idKonto, username, password, joinDatum, typ) VALUES (? ,?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, k.getIdKonto());
            statement.setString(2, k.getUsername());
            statement.setString(3, k.getPassword());
            statement.setObject(4, k.getJoinDatum());
            statement.setString(5, k.getTyp());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                kontoList.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log it or throw a custom exception
        }
    }

    public boolean getById(String idKonto) {
        String sql = "SELECT * FROM konto WHERE idKonto = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idKonto);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log it or throw a custom exception
            return false;
        }
    }

    public void delete(String idKonto) {
        String sql = "DELETE FROM konto WHERE idKonto = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idKonto);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                kontoList.removeIf(k -> k.getIdKonto().equals(idKonto));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log it or throw a custom exception
        }
    }

    public Konto update(String idKonto, Konto newKonto) {
        String sql = "UPDATE konto SET username = ?, password = ?, joinDatum = ?, typ = ? WHERE idKonto = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newKonto.getUsername());
            statement.setString(2, newKonto.getPassword());
            statement.setObject(3, newKonto.getJoinDatum());
            statement.setString(4, newKonto.getTyp());
            statement.setString(5, idKonto);

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                for (int i = 0; i < kontoList.size(); i++) {
                    Konto k = kontoList.get(i);
                    if (k.getIdKonto().equals(idKonto)) {
                        kontoList.set(i, newKonto);
                        return newKonto;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log it or throw a custom exception
        }
        return null;
    }

    public List<Konto> getAll() {
        // Implement this method based on your specific use case
        // You might need to retrieve all records from the database and populate the lis
        String sql = "SELECT * FROM konto";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String idKonto=resultSet.getString("idKonto");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                LocalDateTime joinDatum = resultSet.getObject("joinDatum", LocalDateTime.class);
                String typ = resultSet.getString("typ");

                Konto konto = new Konto(idKonto,username, password, joinDatum, typ);
                konto.setIdKonto(resultSet.getString("idKonto"));
                kontoList.add(konto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log it or throw a custom exception
        }
        return kontoList;
    }
}
