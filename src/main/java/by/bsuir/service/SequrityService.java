package by.bsuir.service;

public interface SequrityService {

    String findLoggedInUsername();

    void autoLogin(String email, String password);
}
