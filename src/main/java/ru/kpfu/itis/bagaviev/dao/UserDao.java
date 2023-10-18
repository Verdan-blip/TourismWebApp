package ru.kpfu.itis.bagaviev.dao;

import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {

    private static final int COLUMN_ID = 1;
    private static final int COLUMN_NAME = 2;
    private static final int COLUMN_LASTNAME = 3;
    private static final int COLUMN_GENDER = 4;
    private static final int COLUMN_PHONE = 5;
    private static final int COLUMN_EMAIL = 6;
    private static final int COLUMN_AVATAR = 7;
    private static final int COLUMN_PASSWORD = 8;

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt(COLUMN_ID),
                resultSet.getString(COLUMN_NAME),
                resultSet.getString(COLUMN_LASTNAME),
                resultSet.getString(COLUMN_GENDER),
                resultSet.getString(COLUMN_PHONE),
                resultSet.getString(COLUMN_EMAIL),
                resultSet.getString(COLUMN_PASSWORD),
                resultSet.getString(COLUMN_AVATAR)
        );
    }
    @Override
    public User get(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM users WHERE users.id = '%d'", id));
            if (resultSet.next())
                return getUserFromResultSet(resultSet);
            else
                return null;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public User get(String email, String password) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM users WHERE users.email = '%s' AND users.password = '%s'", email, password));
            if (resultSet.next())
                return getUserFromResultSet(resultSet);
            else
                return null;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(getUserFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void save(User user) {
        String query = "INSERT INTO users (name, lastname, gender, phone, email, password, avatar) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getAvatar());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(User user) {
        String query = "UPDATE users " +
                "SET name = ?, lastname = ?, gender = ?, phone = ?, email = ?, avatar = ? " +
                "WHERE users.id = ?";
        try (PreparedStatement preparedStatement = DatabaseConnectionUtil.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getAvatar());
            preparedStatement.setInt(7, user.getId());
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
