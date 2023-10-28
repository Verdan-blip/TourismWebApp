package ru.kpfu.itis.bagaviev.dto;

import java.sql.Date;

public class SiteReviewDto {
    private Date date;
    private String text;
    private Short starRate;
    private String userName;
    private String userAvatar;

    public SiteReviewDto(Date date, String text, Short starRate, String userName, String userAvatar) {
        this.date = date;
        this.text = text;
        this.starRate = starRate;
        this.userName = userName;
        this.userAvatar = userAvatar;
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
