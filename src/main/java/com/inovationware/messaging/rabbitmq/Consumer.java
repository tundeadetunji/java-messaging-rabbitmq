package com.inovationware.messaging.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

public class Consumer {

    //private String EXCHANGE_NAME;
    private String QUEUE_NAME;
    //private String ROUTING_KEY;

    public Consumer(String QUEUE_NAME) {
        //this.EXCHANGE_NAME = EXCHANGE_NAME;
        this.QUEUE_NAME = QUEUE_NAME;
        //this.ROUTING_KEY = ROUTING_KEY;
    }

    public void consume() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); //set username, password

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.basicConsume(QUEUE_NAME, true, new DeliverCallback(){
            @Override
            public void handle(String consumerTag, Delivery delivery) throws IOException {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("at " + LocalDateTime.now() + ", received: " + message);
            }
        }, new CancelCallback(){
            @Override
            public void handle(String consumerTag) throws IOException {

            }
        });


    }
}
