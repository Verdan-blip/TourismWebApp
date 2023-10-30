package ru.kpfu.itis.bagaviev.model;

public class TouristPlace {

    private Integer id;
    private String name;
    private String city;
    private String description;
    private String location;
    private String imageUrl;

    public TouristPlace(Integer id, String name, String city, String description, String location, String imageUrl) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public TouristPlace(String name, String city, String description, String location, String imageUrl) {
        this.name = name;
        this.city = city;
        this.description = description;
        this.location = location;
        this.imageUrl = imageUrl;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
