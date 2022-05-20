package be.technifutur.gg.reservation;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class MessageSender implements InitializingBean {

//    private final RabbitTemplate rabbitTemplate;
    private final StreamBridge streamBridge;
//    private final ReservationService service;

    public MessageSender(RabbitTemplate rabbitTemplate, StreamBridge streamBridge) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.service = service;
        this.streamBridge = streamBridge;
    }

//    public void sendReservationToFacture(String json){
//        rabbitTemplate.convertAndSend("demo.direct", "reservation", json);
//    }

    public void send(Reservation reservation){
        streamBridge.send("output-out-0", reservation);
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
