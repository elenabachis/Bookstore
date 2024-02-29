package main.repository;

import main.model.Autor;

import java.sql.*;
import java.util.List;

public class AutorRepo implements InMemoryRepo<Autor> {
    private static AutorRepo instance;
    private List<Autor> autorList;
    private Connection connection; // Add a connection field

//    private AutorRepo(List<Autor> autorList) {
//        this.autorList = autorList;
//        this.connection = establishDatabaseConnection();
//    }

//    private Connection establishDatabaseConnection() {
//        try {
//            Class.forName("jdbc:mysql://localhost:3306/bookstore");
//            String jdbcUrl = "jdbc:mysql://localhost:3306/bookstore";
//            String username = "root";
//            String password = "Cata22";
//            return DriverManager.getConnection(jdbcUrl, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to establish a database connection");
//        }
//    }

    public void add(Autor autor) {
        String sql = "INSERT INTO autor (id_autor, name, other_columns) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, autor.getIdAutor());
            statement.setString(2, autor.getName());
            // set other parameters
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Autor update(String id, Autor new_entity) {
        return null;
    }

    @Override
    public List<Autor> getAll() {
        return null;
    }

    public boolean getById(String id) {
        String sql = "SELECT * FROM autor_table WHERE id_autor = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // If there is a matching record, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ... other methods

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // ... rest of the class
}