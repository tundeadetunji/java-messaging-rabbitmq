package com.inovationware.messaging.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

public class Sender {
    //public static final String EXCHANGE_NAME = "defaultExchange";
    //public static final String QUEUE_NAME = "defaultQueue";
    //public static final String ROUTING_KEY = "key.#".r;

    private String EXCHANGE_NAME;
    private String QUEUE_NAME;
    private String ROUTING_KEY;

    public Sender(String EXCHANGE_NAME, String QUEUE_NAME, String ROUTING_KEY) {
        this.EXCHANGE_NAME = EXCHANGE_NAME;
        this.QUEUE_NAME = QUEUE_NAME;
        this.ROUTING_KEY = ROUTING_KEY;
    }

    public void send(String message) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); //set username, password


        try (Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            channel.basicPublish(EXCHANGE_NAME, "key.messages",false,null, message.getBytes());

            System.out.println("message sent at " + LocalDateTime.now());
        }

    }
}
