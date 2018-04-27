package by.bsuir.repository;

import by.bsuir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);
    User findOneByEmailAndPassword(String email, String password);
}
