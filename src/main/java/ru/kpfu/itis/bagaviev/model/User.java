package ru.kpfu.itis.bagaviev.model;

public class User {

    private int id;
    private String name;
    private String lastname;
    private String gender;
    private String phone;
    private String email;
    private String password;

    public User(int id, String name, String lastname, String gender, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public User(String name, String lastname, String gender, String phone, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
