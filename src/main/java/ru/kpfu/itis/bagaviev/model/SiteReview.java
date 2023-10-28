package ru.kpfu.itis.bagaviev.model;

import java.sql.Date;

public class SiteReview {

    private Integer id;
    private Integer userId;
    private Date date;
    private String text;
    private Short starRate;

    public SiteReview(Integer id, Integer userId, Date date, String text, Short starRate) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.text = text;
        this.starRate = starRate;
    }

    public SiteReview(Integer userId, Date date, String text, Short starRate) {
        this.userId = userId;
        this.date = date;
        this.text = text;
        this.starRate = starRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Short getStarRate() {
        return starRate;
    }

    public void setStarRate(Short starRate) {
        this.starRate = starRate;
    }
}
