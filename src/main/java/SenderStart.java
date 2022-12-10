import com.inovationware.messaging.rabbitmq.Sender;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


class SenderStart {
    public static final String EXCHANGE_NAME = "defaultExchange";
    public static final String QUEUE_NAME = "defaultQueue";
    public static final String ROUTING_KEY = "key.#";

    private static void main(String[] args) throws IOException, TimeoutException {

        new Sender(EXCHANGE_NAME, QUEUE_NAME, ROUTING_KEY).send("this is the message sent");


        /*CustomList<Object> list = new CustomList<Object>();

        String e = "3+5*2-5";
        e = "4*2-2+3";
        e = "7+5*3*2-1";
        List<Object> o = Arrays.asList(e.split(""));

        print(o);
        list.pop(o);
        print(o);*/

    }

}
