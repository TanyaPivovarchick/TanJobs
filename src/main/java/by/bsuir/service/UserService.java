package by.bsuir.service;

import by.bsuir.model.User;

/**
 * Service class for {@link User}
 */

public interface UserService {

    void save(User user);

    User findByEmail(String email);
}
