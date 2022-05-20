package be.technifutur.gg.reservation;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping("/reservation/add")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReservation(@RequestBody Reservation reservation) throws JsonProcessingException {
        service.create(reservation);
    }

    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> getList (){
        return ResponseEntity.ok(service.getReservationFactures());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/reservation/one")
    public ResponseEntity<ReservationFactureDTO> getOne(@RequestParam UUID id, @RequestHeader("Authorization") String token){

        return ResponseEntity.ok(service.getOne(id, token));
    }






}
