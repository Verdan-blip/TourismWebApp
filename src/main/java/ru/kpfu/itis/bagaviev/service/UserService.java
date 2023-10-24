package ru.kpfu.itis.bagaviev.service;

import ru.kpfu.itis.bagaviev.dao.UserDao;
import ru.kpfu.itis.bagaviev.dto.UserDto;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.utils.PasswordEncryptUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private final UserDao userDao = new UserDao();

    private UserDto userToUserDto(User user) {
        if (user == null) return null;
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getGender(),
                user.getPhone(),
                user.getEmail(),
                user.getAvatar());
    }

    public List<UserDto> getAll() {
        return userDao
                .getAll()
                .stream()
                .map(this::userToUserDto)
                .collect(Collectors.toList());
    }
    public UserDto get(Integer id) {
        return userToUserDto(userDao.get(id));
    }

    public UserDto get(String email, String password) {
        return userToUserDto(
                userDao.get(email, PasswordEncryptUtil.encrypt(password))
        );
    }

    public void save(User user) {
        user.setPassword(PasswordEncryptUtil.encrypt(user.getPassword()));
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public boolean existsPhone(String phone) {
        return userDao.existsPhone(phone);
    }

    public boolean existsEmail(String email) {
        return userDao.existsEmail(email);
    }

}