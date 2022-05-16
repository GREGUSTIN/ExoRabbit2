package be.technifutur.gg.controller;


import be.technifutur.gg.form.LoginForm;
import be.technifutur.gg.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService loginService) {
        this.service = loginService;
    }

    @PostMapping
    public String login(@RequestBody LoginForm form){
        return service.login(form);
    }

}
