package ru.kpfu.itis.bagaviev.dao;

import ru.kpfu.itis.bagaviev.model.Friend;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendDao implements Dao<Friend> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private Friend getFriendFromResultSet(ResultSet resultSet) throws SQLException {
        return new Friend(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getInt(3),
                resultSet.getShort(4)
        );
    }
    @Override
    public Friend get(Integer id) {
        String query = "SELECT * FROM friends WHERE friends.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return getFriendFromResultSet(resultSet);
            else
                return null;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Friend> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM friends");
            List<Friend> friends = new ArrayList<>();
            while (resultSet.next()) {
                friends.add(getFriendFromResultSet(resultSet));
            }
            return friends;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void save(Friend friend) {
        String query = "INSERT INTO friends (user1_id, user2_id, status) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, friend.getUser1_id());
            preparedStatement.setInt(2, friend.getUser2_id());
            preparedStatement.setShort(3, friend.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(Friend friend) {
        String query = "UPDATE friends " +
                "SET user1_id = ?, user2_id = ?, status = ?" +
                "WHERE friends.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, friend.getUser1_id());
            preparedStatement.setInt(2, friend.getUser2_id());
            preparedStatement.setShort(3, friend.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
