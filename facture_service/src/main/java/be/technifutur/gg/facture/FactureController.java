package be.technifutur.gg.facture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/facture")
public class FactureController {

    private final FactureService service;


    public FactureController(FactureService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Facture>> getList (){
        return ResponseEntity.ok(service.getFactures());
    }

    @GetMapping("/one")
    public ResponseEntity<Double> getPrixByID(@RequestParam UUID id){
        return ResponseEntity.ok(service.getPrixByID(id));
    }

}
