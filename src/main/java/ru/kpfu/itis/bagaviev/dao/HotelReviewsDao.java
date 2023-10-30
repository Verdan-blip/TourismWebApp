package ru.kpfu.itis.bagaviev.dao;

import ru.kpfu.itis.bagaviev.model.HotelReview;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelReviewsDao implements Dao<HotelReview> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private HotelReview getHotelReviewsFromResultSet(ResultSet resultSet) throws SQLException {
        return new HotelReview(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getInt(3),
                resultSet.getString(4),
                resultSet.getTimestamp(5)
        );
    }

    @Override
    public HotelReview get(Integer id) {
        String query = "SELECT * FROM hotel_reviews WHERE hotel_reviews.id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? getHotelReviewsFromResultSet(resultSet) : null;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<HotelReview> getAll() {
        String query = "SELECT * FROM hotel_reviews;";
        List<HotelReview> hotelReviewList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                hotelReviewList.add(getHotelReviewsFromResultSet(resultSet));
            }
            return hotelReviewList;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void save(HotelReview hotelReview) {
        String query = "INSERT INTO hotel_reviews (hotel_id, user_id, text, date) " +
                "VALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, hotelReview.getHotelId());
            preparedStatement.setInt(2, hotelReview.getUserId());
            preparedStatement.setString(3, hotelReview.getText());
            preparedStatement.setTimestamp(4, hotelReview.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(HotelReview hotelReview) {
        String query = "UPDATE hotel_reviews " +
                "SET hotel_id = ?, user_id = ?, text = ?, date = ?" +
                "WHERE hotel_reviews.id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, hotelReview.getHotelId());
            preparedStatement.setInt(2, hotelReview.getUserId());
            preparedStatement.setString(3, hotelReview.getText());
            preparedStatement.setTimestamp(4, hotelReview.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
