package sender;

import com.google.gson.Gson;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MessageSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageSenderApplication.class, args);
    }

}

@RestController
class MessageController {

    private final MessageSender messageSender;

    MessageController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping("/send")
    public void sendMessageToQueue(@RequestBody Message message) {
        messageSender.sendMessage(message);
    }
}

@Configuration
class RabbitMQConfig {
    @Bean
    public Queue queue() {
        return new Queue("howdy");
    }
}
@Component
class MessageSender {

    private final RabbitTemplate rabbitTemplate;
    private final Gson gson = new Gson();

    MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Message message) {
        String messageJson = gson.toJson(message);
        rabbitTemplate.convertAndSend("howdy", messageJson);
        System.out.printf("Sent %s to RabbitMQ\n", messageJson);
    }
}

record Message(String content) {
}