package ru.kpfu.itis.bagaviev.dto;

public class FriendDto {

    private Integer friendId;

    private String name;
    private String lastname;
    private Short status;
    private String avatar;

    public FriendDto(Integer friendId, String name, String lastname, Short status, String avatar) {
        this.friendId = friendId;
        this.name = name;
        this.lastname = lastname;
        this.status = status;
        this.avatar = avatar;
    }

    public FriendDto(String name, String lastname, Short status, String avatar) {
        this.name = name;
        this.lastname = lastname;
        this.status = status;
        this.avatar = avatar;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
