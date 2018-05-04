package by.bsuir.controller;

import by.bsuir.entity.User;
import by.bsuir.service.UserService;
import by.bsuir.viewModel.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> login(@RequestBody LoginData loginData){
        User user = userService.findUserByEmailAndPassword(loginData.getEmail(), loginData.getPassword());
        return ResponseEntity.ok(user);
    }
}
