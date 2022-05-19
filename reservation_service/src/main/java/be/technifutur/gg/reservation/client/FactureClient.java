package be.technifutur.gg.reservation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "facture-service")
public interface FactureClient {

    @GetMapping("/facture/one")
    public ResponseEntity<Double> getPrixByID(@RequestParam UUID id, @RequestHeader(name = "Authorization") String token);



}
