package app.broker.service;

import com.mchange.v2.lang.SystemUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
//@RabbitListener(queues = "hello")
@RabbitListener(queues = "spring-rabbitmq-routingKey")
public class MainService {

    @RabbitHandler
    public void hello(String msg) {
        System.out.println("Hello World! " + msg);
//        return "Hello World! " + msg;
    }
    @RabbitHandler
    public void bye(Integer byeMsq, Message message) {
//        SystemUtils.sysPropsEnvReplace();
        System.out.println("Hello World! " + byeMsq);
//        return "Hello World! " + byeMsq;
    }
}
