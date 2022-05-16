package be.technifutur.gg.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessageReciever {

    private final ReservationService service;
    private Logger logger = LoggerFactory.getLogger(MessageReciever.class);

    public MessageReciever(ReservationService service) {
        this.service = service;
    }

    @RabbitListener(queues = "facture_queue")
    public void recieve(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        UUID ref = mapper.readValue(message, UUID.class);
        service.setToFacture(ref);
    }




}
