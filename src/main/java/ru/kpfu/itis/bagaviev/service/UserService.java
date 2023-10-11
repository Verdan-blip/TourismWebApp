package ru.kpfu.itis.bagaviev.service;

import ru.kpfu.itis.bagaviev.dao.UserDao;
import ru.kpfu.itis.bagaviev.dto.UserDto;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.utils.PasswordEncryptUtil;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private final UserDao userDao = new UserDao();
    public List<UserDto> getAll() {
        return userDao.getAll()
                .stream()
                .map(dao -> new UserDto(dao.getName(), dao.getLastname()))
                .collect(Collectors.toList());
    }
    public UserDto get(int id) {
        User user = userDao.get(id);
        return new UserDto(user.getName(), user.getLastname());
    }

    public void save(User user) {
        user.setPassword(PasswordEncryptUtil.encrypt(user.getPassword()));
        userDao.save(user);
    }

    public boolean isExist(String email, String password) {
        return userDao.isExists(email, PasswordEncryptUtil.encrypt(password));
    }

}