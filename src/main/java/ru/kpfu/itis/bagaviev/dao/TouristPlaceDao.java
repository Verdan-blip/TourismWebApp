package ru.kpfu.itis.bagaviev.dao;

import ru.kpfu.itis.bagaviev.model.TouristPlace;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TouristPlaceDao implements Dao<TouristPlace>{
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private TouristPlace getTouristPlaceReviewFromResultSet(ResultSet resultSet) throws SQLException {
        return new TouristPlace(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6)
        );
    }

    @Override
    public TouristPlace get(Integer id) {
        String query = "SELECT * FROM tourist_places WHERE tourist_places.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? getTouristPlaceReviewFromResultSet(resultSet) : null;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<TouristPlace> get(String city) {
        String query = "SELECT * FROM tourist_places WHERE tourist_places.city = ?";
        List<TouristPlace> hotels = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, city);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                hotels.add(getTouristPlaceReviewFromResultSet(resultSet));
            return hotels;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<TouristPlace> getAll() {
        String query = "SELECT * FROM tourist_places";
        List<TouristPlace> touristPlaces = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                touristPlaces.add(getTouristPlaceReviewFromResultSet(resultSet));
            }
            return touristPlaces;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void save(TouristPlace touristPlace) {
        String query = "INSERT INTO tourist_places (name, city, desciption, location, image) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, touristPlace.getId());
            preparedStatement.setString(2, touristPlace.getName());
            preparedStatement.setString(3, touristPlace.getCity());
            preparedStatement.setString(4, touristPlace.getLocation());
            preparedStatement.setString(5, touristPlace.getImageUrl());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(TouristPlace touristPlace) {
        String query = "UPDATE tourist_places " +
                "SET name = ?, city = ?, desciption = ?, location = ?, image = ? " +
                "WHERE tourist_places.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, touristPlace.getId());
            preparedStatement.setString(2, touristPlace.getName());
            preparedStatement.setString(3, touristPlace.getCity());
            preparedStatement.setString(4, touristPlace.getLocation());
            preparedStatement.setString(5, touristPlace.getImageUrl());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
