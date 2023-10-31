package ru.kpfu.itis.bagaviev.service;

import ru.kpfu.itis.bagaviev.dto.FriendDto;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendService {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private List<FriendDto> resultSetToFriendDtoList(ResultSet resultSet) throws SQLException {
        List<FriendDto> hotelReviewsDtoList = new ArrayList<>();
        while (resultSet.next()) {
            hotelReviewsDtoList.add(
                    new FriendDto(
                            resultSet.getInt("user2_id"),
                            resultSet.getString("name"),
                            resultSet.getString("lastname"),
                            resultSet.getShort("status"),
                            resultSet.getString("avatar")
                    )
            );
        }
        return hotelReviewsDtoList;
    }

    public List<FriendDto> getAllFriends(Integer userId) {
        String query = "SELECT f.user2_id, f.status, u.name, u.lastname, u.avatar \n" +
                "FROM friends AS f \n" +
                "INNER JOIN users AS u \n" +
                "ON f.user1_id = u.id AND f.user1_id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSetToFriendDtoList(resultSet);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
