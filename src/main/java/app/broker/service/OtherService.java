package app.broker.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OtherService {
    @RabbitListener(queues = "spring-thialander-routingKey")
    public void otherMessage(String o, Message message) {
        System.out.println("Hello World! " + o);
    }
}
