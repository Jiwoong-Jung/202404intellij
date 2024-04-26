package messagereceiver;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MessageReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageReceiverApplication.class, args);
    }

}

@Component
class MessageReceiver{

    private final Gson gson = new Gson();
    @RabbitListener(queues = "howdy")
    public void receiveMessage(String message) {
        System.out.printf("Received %s from RabbitMQ\n", message);
    }
}

record Message(String content) {}