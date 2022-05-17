package be.technifutur.userService.controller;


import be.technifutur.userService.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping(params = "username")
    public Object getByUsername(@RequestParam String username){
        log.info("TESTIN IN");
        return new UserDTO(
                "user",
                encoder.encode("pass"),
                List.of( "USER" )
        );
    }

}
