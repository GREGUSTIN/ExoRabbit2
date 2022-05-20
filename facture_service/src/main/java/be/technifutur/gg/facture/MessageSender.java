package be.technifutur.gg.facture;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;


    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

//    public void sendFactureToReservation (String json){
//        rabbitTemplate.convertAndSend("demo.direct","facture", json);
//    }

}
