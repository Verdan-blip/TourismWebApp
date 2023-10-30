package ru.kpfu.itis.bagaviev.dto;

import ru.kpfu.itis.bagaviev.dao.HotelReviewsDao;

import java.sql.Timestamp;

public class HotelReviewsDto {

    private final HotelReviewsDao hotelReviewsDao = new HotelReviewsDao();

    private Timestamp date;
    private String text;
    private String userName;
    private String userAvatar;

    public HotelReviewsDto(Timestamp date, String text, String userName, String userAvatar) {
        this.date = date;
        this.text = text;
        this.userName = userName;
        this.userAvatar = userAvatar;
    }

    public HotelReviewsDao getHotelReviewsDao() {
        return hotelReviewsDao;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

}
