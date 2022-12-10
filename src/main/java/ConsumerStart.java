import com.inovationware.messaging.rabbitmq.Consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

class ConsumerStart {
    public static final String EXCHANGE_NAME = "defaultExchange";
    public static final String QUEUE_NAME = "defaultQueue";
    public static final String ROUTING_KEY = "key.#";

    private static void main(String[] args) throws IOException, TimeoutException {
        new Consumer(QUEUE_NAME).consume();

    }
}
