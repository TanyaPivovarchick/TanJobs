package by.bsuir.controller;

import by.bsuir.entity.AspirantAccount;
import by.bsuir.service.AspirantService;
import by.bsuir.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("TestController")
public class TestController {

    private AuthService authService;
    private AspirantService aspirantService;

    @Autowired
    public TestController(AuthService authService, AspirantService aspirantService) {
        this.authService = authService;
        this.aspirantService = aspirantService;
    }

    public void register(AspirantAccount aspirantAccount) throws Exception {
        this.authService.registerAspirant(aspirantAccount);
    }

    public AspirantAccount getAspirant(String email) throws Exception {
        return this.aspirantService.getAspirantAccountByEmail(email);
    }
}
