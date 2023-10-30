package ru.kpfu.itis.bagaviev.model;

import java.sql.Timestamp;

public class HotelReview {

    private Integer id;
    private Integer hotelId;
    private Integer userId;
    private String text;
    private Timestamp date;

    public HotelReview(Integer id, Integer hotelId, Integer userId, String text, Timestamp date) {
        this.id = id;
        this.hotelId = hotelId;
        this.userId = userId;
        this.text = text;
        this.date = date;
    }

    public HotelReview(Integer hotelId, Integer userId, String text, Timestamp date) {
        this.hotelId = hotelId;
        this.userId = userId;
        this.text = text;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
