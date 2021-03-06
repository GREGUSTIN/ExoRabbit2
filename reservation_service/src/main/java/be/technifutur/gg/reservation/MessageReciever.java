package be.technifutur.gg.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.function.Consumer;

@Component
public class MessageReciever {

    private final ReservationService service;
    private Logger logger = LoggerFactory.getLogger(MessageReciever.class);

    public MessageReciever(ReservationService service) {
        this.service = service;
    }

//    @RabbitListener(queues = "facture_queue")
//    public void recieve(String message) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        UUID ref = mapper.readValue(message, UUID.class);
//        service.setToFacture(ref);
//    }

    @Bean
    public Consumer<UUID> input(){
        return (uuid) -> {
            service.setToFacture(uuid);
        };
    }




}
