//package be.technifutur.gg.facture;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class RabbitConfig {
//
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
//        return new RabbitAdmin(connectionFactory);
//    }
//
//
//    @Bean("reservation_queue")
//    public Queue reservation_queue(){
//        return new Queue("reservation_queue", false);
//    }
//
//    @Bean("facture_queue")
//    public Queue facture_queue(){
//        return new Queue("facture_queue", false);
//    }
//
//    @Bean
//    public DirectExchange directExchange(){
//        return new DirectExchange("demo.direct");
//    }
//
//    @Bean
//    public Binding fBinding(DirectExchange exchange,@Qualifier("facture_queue") Queue queue){
//        return BindingBuilder.bind(queue).to(exchange).with("facture");
//    }
//
//
//}
