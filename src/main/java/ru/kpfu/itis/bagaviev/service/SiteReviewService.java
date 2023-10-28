package ru.kpfu.itis.bagaviev.service;

import ru.kpfu.itis.bagaviev.dao.SiteReviewDao;
import ru.kpfu.itis.bagaviev.dto.SiteReviewDto;
import ru.kpfu.itis.bagaviev.model.SiteReview;
import ru.kpfu.itis.bagaviev.utils.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiteReviewService {
    private Connection connection = DatabaseConnectionUtil.getConnection();
    private SiteReviewDao siteReviewDao = new SiteReviewDao();

    private List<SiteReviewDto> resultSetToSiteReviewDtoList(ResultSet resultSet) throws SQLException {
        List<SiteReviewDto> siteReviewDtoList = new ArrayList<>();
        while (resultSet.next()) {
            siteReviewDtoList.add(
                    new SiteReviewDto(
                            resultSet.getDate("date"),
                            resultSet.getString("text"),
                            resultSet.getShort("star_rate"),
                            resultSet.getString("name"),
                            resultSet.getString("avatar")
                    )
            );
        }
        return siteReviewDtoList;
    }

    public List<SiteReviewDto> getAll() {
        String query = "SELECT s.text, s.date, s.star_rate, u.name, u.avatar\n" +
                        "FROM site_reviews AS s \n" +
                        "INNER JOIN users AS u \n" +
                        "ON s.user_id = u.id;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSetToSiteReviewDtoList(resultSet);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void save(SiteReview siteReview) {
        siteReviewDao.save(siteReview);
    }

}
