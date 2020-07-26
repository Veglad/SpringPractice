package com.veglad.messagingrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner  implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final Reciever reciever;

    public Runner(RabbitTemplate rabbitTemplate, Reciever reciever) {
        this.rabbitTemplate = rabbitTemplate;
        this.reciever = reciever;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(AppConfig.TOPIC_EXCHANGE_NAME, "foo.bar.baz", "Hello Rabbitmq!");
        reciever.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
