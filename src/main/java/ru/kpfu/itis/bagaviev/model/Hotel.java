package ru.kpfu.itis.bagaviev.model;

public class Hotel {

    private Integer id;
    private String name;
    private String location;
    private String description;
    private String imageUrl;
    private Short rate;
    private Double pricePerNight;
    private Short starRating;
    private String city;

    public Hotel(Integer id, String name, String location, String description, String imageUrl, Short rate, Double pricePerNight, Short starRating, String city) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rate = rate;
        this.pricePerNight = pricePerNight;
        this.starRating = starRating;
        this.city = city;
    }

    public Hotel(String name, String location, String description, String imageUrl, Short rate, Double pricePerNight, Short starRating, String city) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rate = rate;
        this.pricePerNight = pricePerNight;
        this.starRating = starRating;
        this.city = city;
    }

    public Short getStarRating() {
        return starRating;
    }

    public void setStarRating(Short starRating) {
        this.starRating = starRating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Short getRate() {
        return rate;
    }

    public void setRate(Short rate) {
        this.rate = rate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
