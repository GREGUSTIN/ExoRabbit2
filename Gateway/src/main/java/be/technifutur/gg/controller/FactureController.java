package be.technifutur.gg.controller;

import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/facture")
public class FactureController {

    private final RestTemplate template;


    public FactureController(RestTemplate template) {
        this.template = template;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<?> getFacture(){
        ResponseEntity<?> response = template.getForEntity("http://localhost:8081/facture", Object.class);
        return response;
    }


}
