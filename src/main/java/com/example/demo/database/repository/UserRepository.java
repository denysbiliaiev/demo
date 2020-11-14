package com.example.demo.database.repository;

import com.example.demo.database.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.Optional;

@Repository
public class UserRepository {
    static  final String URL = "jdbc:postgresql://localhost:5432/postgres";

    static  final String USER = "postgres";
    static  final String PASSWORD = "postgres";

    public void save(User user) {
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);) {
            String INSERT_QUERY =
                    "INSERT INTO demo_user (id, first_name, last_name, age, email)" +
                            "VALUES (?, ?, ?, ?, ?);";

            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                connection.setAutoCommit(false);

                preparedStatement.setLong(1, user.getId());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setLong(4, user.getAge());
                preparedStatement.setString(5, user.getEmail());
                preparedStatement.executeQuery();
                connection.commit();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
               connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(User user) {
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);) {
            String INSERT_QUERY =
                    "UPDATE demo_user SET first_name=?, last_name=?, age=?, email=? WHERE id=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                connection.setAutoCommit(false);

                preparedStatement.setString(1, user.getFirstName());
                preparedStatement.setString(2, user.getLastName());
                preparedStatement.setLong(3, user.getAge());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setLong(5, user.getId());
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Optional<User> findByID(Long id) {
        String SELECT_QUERY =
                "SELECT * FROM demo_user WHERE id=?";
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(SELECT_QUERY)) {
            connection.setAutoCommit(false);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                System.out.println(user);
                return Optional.of(user);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

    public Optional<User> delete(Long id) {
        String SELECT_QUERY =
                "DELETE FROM demo_user WHERE id=?";
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_QUERY)) {
            connection.setAutoCommit(false);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

    public Optional<User> findByEmail(String email) {
        String SELECT_QUERY =
                "SELECT * FROM demo_user WHERE email=?";
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_QUERY)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                System.out.println(user);
                return Optional.of(user);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }
}
