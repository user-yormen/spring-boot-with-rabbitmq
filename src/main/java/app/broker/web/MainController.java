package app.broker.web;

import app.broker.service.MainService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/{msg}")
    public String hello(@PathVariable String msg) {
//        rabbitTemplate.convertAndSend("spring-rabbitmq-exchange", "spring-rabbitmq-routingKey", msg);
        rabbitTemplate.convertAndSend("spring-rabbitmq-routingKey", msg);
        return "Tadaaa......";
    }

    @GetMapping("/bye/{byeMsq}")
    public String bye(@PathVariable Integer byeMsq) {
        rabbitTemplate.convertAndSend("spring-rabbitmq-routingKey", byeMsq);
        return "Bye bye here tatata......"+byeMsq;
    }

    @GetMapping("/other/{o}")
    public String other(@PathVariable Object o) {
        rabbitTemplate.convertAndSend("spring-thialander-routingKey", o.toString());
        return "Bye bye here tatata......"+o;
    }
}
