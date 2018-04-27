package by.bsuir.controller;

import by.bsuir.entity.User;
import by.bsuir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {
            return new ResponseEntity<>(new User(), HttpStatus.OK);
        }

        if (userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword()) == null){
            return new ResponseEntity<>(new User(), HttpStatus.OK);
        }

        return new ResponseEntity<>(userService.findUserByEmail(user.getEmail()), HttpStatus.OK);
    }
}
