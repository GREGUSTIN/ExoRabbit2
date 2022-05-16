package be.technifutur.gg.reservation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessageSender implements InitializingBean {

    private final RabbitTemplate rabbitTemplate;
//    private final ReservationService service;

    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
//        this.service = service;
    }

    public void sendReservationToFacture(String json){
        rabbitTemplate.convertAndSend("demo.direct", "reservation", json);
    }



    @Override
    public void afterPropertiesSet() throws Exception {
//        Reservation r = new Reservation(
//                UUID.randomUUID(),
//                3,
//                Reservation.Status.DEMANDE
//        );
//        service.create(r);
//        ObjectMapper mapper = new ObjectMapper();
//        String rJson = mapper.writeValueAsString(r);
//
//        sendReservationToFacture(rJson);

    }




}
