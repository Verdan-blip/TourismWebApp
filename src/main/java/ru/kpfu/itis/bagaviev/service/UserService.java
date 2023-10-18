package ru.kpfu.itis.bagaviev.service;

import ru.kpfu.itis.bagaviev.dao.UserDao;
import ru.kpfu.itis.bagaviev.dto.OrderUserDto;
import ru.kpfu.itis.bagaviev.dto.UserDto;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.utils.PasswordEncryptUtil;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private final UserDao userDao = new UserDao();

    private UserDto userToUserDto(User user) {
        if (user == null) return null;
        return new UserDto(
                    user.getName(),
                    user.getLastname(),
                    user.getGender(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getAvatar());
    }

    private OrderUserDto userToOrderUserDto(User user) {
        if (user == null) return null;
        return new OrderUserDto(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getGender(),
                user.getPhone(),
                user.getAvatar(),
                user.getEmail());
    }

    public List<OrderUserDto> getAll() {
        return userDao
                .getAll()
                .stream()
                .map(this::userToOrderUserDto)
                .collect(Collectors.toList());
    }
    public User get(int id) {
        return userDao.get(id);
    }

    public User get(String email, String password) {
        return userDao.get(email, PasswordEncryptUtil.encrypt(password));
    }

    public void save(User user) {
        user.setPassword(PasswordEncryptUtil.encrypt(user.getPassword()));
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

}