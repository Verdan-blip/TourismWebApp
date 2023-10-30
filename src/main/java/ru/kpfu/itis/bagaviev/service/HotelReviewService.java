package ru.kpfu.itis.bagaviev.service;

import ru.kpfu.itis.bagaviev.dto.HotelReviewsDto;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelReviewService {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private List<HotelReviewsDto> resultSetToHotelReviewDtoList(ResultSet resultSet) throws SQLException {
        List<HotelReviewsDto> hotelReviewsDtoList = new ArrayList<>();
        while (resultSet.next()) {
            hotelReviewsDtoList.add(
                    new HotelReviewsDto(
                            resultSet.getTimestamp("date"),
                            resultSet.getString("text"),
                            resultSet.getString("name"),
                            resultSet.getString("avatar")
                    )
            );
        }
        return hotelReviewsDtoList;
    }

    public List<HotelReviewsDto> getAll() {
        String query = "SELECT s.text, s.date, u.name, u.avatar\n" +
                "FROM hotel_reviews AS s \n" +
                "INNER JOIN users AS u \n" +
                "ON s.user_id = u.id;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSetToHotelReviewDtoList(resultSet);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
