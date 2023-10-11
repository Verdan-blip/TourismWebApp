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
    private static final int COLUMN_PASSWORD = 7;

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt(COLUMN_ID),
                resultSet.getString(COLUMN_NAME),
                resultSet.getString(COLUMN_LASTNAME),
                resultSet.getString(COLUMN_GENDER),
                resultSet.getString(COLUMN_PHONE),
                resultSet.getString(COLUMN_EMAIL),
                resultSet.getString(COLUMN_PASSWORD)
        );
    }
    @Override
    public User get(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM users WHERE users.id = '%d'", id));
            return getUserFromResultSet(resultSet);
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
            if (resultSet != null) {
                while (resultSet.next()) {
                    users.add(getUserFromResultSet(resultSet));
                }
            }
            return users;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into users (name, lastname, gender, phone, email, password) values (?, ?, ?, ?, ?, ?);");
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getGender());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public boolean isExists(String email, String password) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM users WHERE users.email = '%s'", email));
            if (resultSet.next()) return (resultSet.getString("password").equals(password));
            return false;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
