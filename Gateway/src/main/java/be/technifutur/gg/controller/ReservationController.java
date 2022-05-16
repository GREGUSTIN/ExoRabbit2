package be.technifutur.gg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final RestTemplate template;


    public ReservationController(RestTemplate template) {
        this.template = template;
    }

    @PostMapping
    public ResponseEntity<Object> addReservation(@RequestBody Map<String, String> request){
        ResponseEntity<Object> response = template.postForEntity("http://localhost:8082/reservation/add", request, Object.class);
        return response;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<Object> getReservation(){
        ResponseEntity<Object> response = template.getForEntity("http://localhost:8082/reservation",  Object.class);
        return response;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/one", params = "id")
    public ResponseEntity<?> getOneReservation (@RequestParam UUID id){
        ResponseEntity<?> response = template.getForEntity("http://localhost:8082/reservation/one?id="+id, Object.class);
        return response;
    }


}
