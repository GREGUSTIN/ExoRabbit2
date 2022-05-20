package be.technifutur.gg.facture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FactureService {

    private final MessageSender messageSender;
    private List<Facture> factures = new ArrayList<>();

    public FactureService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public  Facture createFacture(int nbNuit, UUID reservation)  {
        Facture f= new Facture();
        f.setPrix(50*nbNuit);
        f.setReservation_ref(reservation);
        factures.add(f);
        return f;
    }

    public Double getPrixByID(UUID id){
        return factures.stream().filter(facture -> facture.getReservation_ref().equals(id)).findAny().get().getPrix();
    }



    public   List<Facture> getFactures(){
      return factures;
    }

}
