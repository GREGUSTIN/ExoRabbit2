package be.technifutur.gg.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class TestSecurityController {

    @PreAuthorize("isAuthenticated()")  //doit être authentifié pour accéder à cette méthode
    @GetMapping("/authenticated")
    public String getConnected(){
        return "connecté";
    }

}
