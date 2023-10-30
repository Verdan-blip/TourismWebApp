package ru.kpfu.itis.bagaviev.model;

import java.sql.Timestamp;

public class News {

    private Integer id;
    private String author;
    private String title;
    private String text;
    private Timestamp postingTime;
    private String imageUrl;

    public News(Integer id, String author, String title, String text, Timestamp postingTime, String imageUrl) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
        this.postingTime = postingTime;
        this.imageUrl = imageUrl;
    }

    public News(String author, String title, String text, Timestamp postingTime, String imageUrl) {
        this.author = author;
        this.title = title;
        this.text = text;
        this.postingTime = postingTime;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(Timestamp postingTime) {
        this.postingTime = postingTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
