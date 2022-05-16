package be.technifutur.gg.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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


    public ReservationService(MessageSender messageSender, RestTemplate template) {
        this.messageSender = messageSender;
        this.template = template;
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

    public ReservationFactureDTO getOne(UUID id){
        Reservation r =list.stream().filter(reservation -> reservation.getRef().equals(id)).findAny().orElse(null);
        Double prix = template.getForObject("http://localhost:8081/facture/one?id="+id,  Double.class);
        ReservationFactureDTO rDTO = new ReservationFactureDTO(
                id,
                r.getNbNuit(),
                prix
        );

        return rDTO;
    }

}
