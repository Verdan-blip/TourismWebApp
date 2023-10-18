package ru.kpfu.itis.bagaviev.dto;

public class UserDto {

    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String gender;
    private String avatar;

    public UserDto(String name, String lastname, String phone, String email, String gender, String avatar) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
