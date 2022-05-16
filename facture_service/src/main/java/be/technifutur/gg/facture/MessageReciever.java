package be.technifutur.gg.facture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReciever {

    private final FactureService service;

    public MessageReciever(FactureService service) {
        this.service = service;
    }

    @RabbitListener(queues = "reservation_queue")
    public void recieve (String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Reservation r = mapper.readValue(message, Reservation.class);
        service.createFacture(r.getNbNuit(), r.getRef());


    }

}
