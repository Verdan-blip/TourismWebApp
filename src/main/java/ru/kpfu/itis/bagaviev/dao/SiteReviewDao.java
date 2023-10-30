package ru.kpfu.itis.bagaviev.dao;

import ru.kpfu.itis.bagaviev.model.SiteReview;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiteReviewDao implements Dao<SiteReview> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private SiteReview getCireReviewFromResultSet(ResultSet resultSet) throws SQLException {
        return new SiteReview(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getDate(3),
                resultSet.getString(4),
                resultSet.getShort(5)
        );
    }

    @Override
    public SiteReview get(Integer id) {
        String query = "SELECT * FROM site_reviews WHERE site_reviews.id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? getCireReviewFromResultSet(resultSet) : null;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<SiteReview> getAll() {
        String query = "SELECT * FROM site_reviews;";
        List<SiteReview> siteReviews = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                siteReviews.add(getCireReviewFromResultSet(resultSet));
            }
            return siteReviews;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void save(SiteReview siteReview) {
        String query = "INSERT INTO site_reviews (user_id, date, text, star_rate) VALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, siteReview.getUserId());
            preparedStatement.setDate(2, siteReview.getDate());
            preparedStatement.setString(3, siteReview.getText());
            preparedStatement.setShort(4, siteReview.getStarRate());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(SiteReview siteReview) {
        String query = "UPDATE site_reviews " +
                "SET user_id = ?, date = ?, text = ?, star_rate = ? " +
                "WHERE site_reviews.id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, siteReview.getId());
            preparedStatement.setDate(2, siteReview.getDate());
            preparedStatement.setString(3, siteReview.getText());
            preparedStatement.setShort(4, siteReview.getStarRate());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
