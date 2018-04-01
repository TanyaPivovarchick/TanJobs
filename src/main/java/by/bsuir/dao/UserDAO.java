package by.bsuir.dao;

import by.bsuir.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmail(String email);
}