package ru.kpfu.itis.bagaviev.dao;

import ru.kpfu.itis.bagaviev.model.Hotel;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDao implements Dao<Hotel> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private Hotel getHotelFromResultSet(ResultSet resultSet) throws SQLException {
        return new Hotel(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getShort(6),
                resultSet.getDouble(7),
                resultSet.getShort(8),
                resultSet.getString(9)
        );
    }
    @Override
    public Hotel get(Integer id) {
        String query = "SELECT * FROM hotels WHERE hotels.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return getHotelFromResultSet(resultSet);
            else
                return null;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<Hotel> get(String city) {
        String query = "SELECT * FROM hotels WHERE hotels.city = ?";
        List<Hotel> hotels = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, city);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                hotels.add(getHotelFromResultSet(resultSet));
            return hotels;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Hotel> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hotels");
            List<Hotel> hotels = new ArrayList<>();
            while (resultSet.next()) {
                hotels.add(getHotelFromResultSet(resultSet));
            }
            return hotels;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void save(Hotel hotel) {
        String query = "INSERT INTO users (name, location, description, image, rate, price_per_night) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, hotel.getName());
            preparedStatement.setString(2, hotel.getLocation());
            preparedStatement.setString(3, hotel.getDescription());
            preparedStatement.setString(4, hotel.getImageUrl());
            preparedStatement.setShort(5, hotel.getRate());
            preparedStatement.setDouble(6, hotel.getPricePerNight());
            preparedStatement.setShort(7, hotel.getStarRating());
            preparedStatement.setString(8, hotel.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(Hotel hotel) {
        String query = "UPDATE hotels " +
                "SET name = ?, location = ?, description = ?, image = ?, rate = ?, rice_per_night = ? " +
                "WHERE hotels.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, hotel.getName());
            preparedStatement.setString(2, hotel.getLocation());
            preparedStatement.setString(3, hotel.getDescription());
            preparedStatement.setString(4, hotel.getImageUrl());
            preparedStatement.setShort(5, hotel.getRate());
            preparedStatement.setDouble(6, hotel.getPricePerNight());
            preparedStatement.setShort(7, hotel.getStarRating());
            preparedStatement.setString(8, hotel.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
