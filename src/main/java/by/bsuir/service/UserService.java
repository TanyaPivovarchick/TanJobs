package by.bsuir.service;

import by.bsuir.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User findUserByEmail(String email);
    User findUserByEmailAndPassword(String email, String password);
}
