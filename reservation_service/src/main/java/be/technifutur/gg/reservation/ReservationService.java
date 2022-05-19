package be.technifutur.gg.reservation;

import be.technifutur.gg.reservation.client.FactureClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static be.technifutur.gg.reservation.Reservation.Status.FACTURE;

@Service
public class ReservationService {

    private final List<Reservation> list = new ArrayList<>();
    private final MessageSender messageSender;
    private final RestTemplate template;
    private final FactureClient factureClient;

    public ReservationService(MessageSender messageSender, RestTemplate template, FactureClient client) {
        this.messageSender = messageSender;
        this.template = template;
        this.factureClient = client;
    }


    public  void create(Reservation reservation) throws JsonProcessingException {
        list.add(reservation);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(reservation);
        messageSender.sendReservationToFacture(json);
    }

    public void setToFacture(UUID ref){
       Reservation r = list.stream().filter(reservation -> reservation.getRef().equals(ref)).findAny().orElse(null);
       r.setStatus(FACTURE);
        System.out.println(getReservationFactures());
    }

    public List<Reservation> getReservationFactures(){
        return list.stream().filter(reservation -> reservation.getStatus() == FACTURE).collect(Collectors.toList());
    }

    public ReservationFactureDTO getOne(UUID id, String token){
        Reservation r =list.stream().filter(reservation -> reservation.getRef().equals(id)).findAny().orElse(null);
//        Double prix = template.getForObject("http://facture-service/facture/one?id="+id,  Double.class);
          Double prix = (factureClient.getPrixByID(id, token )).getBody();

        ReservationFactureDTO rDTO = new ReservationFactureDTO(
                id,
                r.getNbNuit(),
                prix
        );

        return rDTO;
    }

}
