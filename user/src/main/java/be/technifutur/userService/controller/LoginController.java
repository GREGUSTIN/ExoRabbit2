package be.technifutur.userService.controller;

import be.technifutur.userService.form.LoginForm;
import be.technifutur.userService.dto.UserDTO;
import be.technifutur.userService.service.LoginService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping
    public String login(@RequestBody LoginForm form){
        return service.login(form);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(name="",headers = "Authorization")
    public UserDTO validate(Authentication auth){
        return new UserDTO(
                (String)auth.getPrincipal(),
                null,
                auth.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList()
        );
    }

}
