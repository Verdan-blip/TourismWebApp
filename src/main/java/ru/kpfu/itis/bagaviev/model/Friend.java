package ru.kpfu.itis.bagaviev.model;

public class Friend {

    private Integer id;
    private Integer user1_id;
    private Integer user2_id;

    private Short status;

    public Friend(Integer id, Integer user1_id, Integer user2_id, Short status) {
        this.id = id;
        this.user1_id = user1_id;
        this.user2_id = user2_id;
        this.status = status;
    }

    public Friend(Integer user1_id, Integer user2_id, Short status) {
        this.user1_id = user1_id;
        this.user2_id = user2_id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser1_id() {
        return user1_id;
    }

    public void setUser1_id(Integer user1_id) {
        this.user1_id = user1_id;
    }

    public Integer getUser2_id() {
        return user2_id;
    }

    public void setUser2_id(Integer user2_id) {
        this.user2_id = user2_id;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
