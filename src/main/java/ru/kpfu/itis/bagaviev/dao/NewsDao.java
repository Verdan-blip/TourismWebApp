package ru.kpfu.itis.bagaviev.dao;

import ru.kpfu.itis.bagaviev.model.News;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao implements Dao<News> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private News getNewsFromResultSet(ResultSet resultSet) throws SQLException {
        return new News(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getTimestamp(5),
                resultSet.getString(6)
        );
    }

    @Override
    public News get(Integer id) {
        String query = "SELECT * FROM news WHERE news.id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? getNewsFromResultSet(resultSet) : null;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<News> getAll() {
        String query = "SELECT * FROM news;";
        List<News> newsList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                newsList.add(getNewsFromResultSet(resultSet));
            }
            return newsList;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void save(News news) {
        String query = "INSERT INTO news (id, author, title, text, posting_time, image) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, news.getId());
            preparedStatement.setString(2, news.getAuthor());
            preparedStatement.setString(3, news.getTitle());
            preparedStatement.setString(4, news.getText());
            preparedStatement.setTimestamp(5, news.getPostingTime());
            preparedStatement.setString(6, news.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(News news) {
        String query = "UPDATE site_reviews " +
                "SET id = ?, author = ?, title = ?, text = ?, posting_time = ?, image = ? " +
                "WHERE news.id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, news.getId());
            preparedStatement.setString(2, news.getAuthor());
            preparedStatement.setString(3, news.getTitle());
            preparedStatement.setString(4, news.getText());
            preparedStatement.setTimestamp(5, news.getPostingTime());
            preparedStatement.setString(6, news.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }


}
