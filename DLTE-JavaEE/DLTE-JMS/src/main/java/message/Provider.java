package message;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class Provider {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection=factory.createConnection();
        connection.start();

        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Destination destination=session.createQueue("p2p");

        MessageProducer provider=session.createProducer(destination);

        Scanner scanner=new Scanner(System.in);
        String inputs="";

        do{
            System.out.println("Information to be sent: ");
            inputs= scanner.nextLine();
            TextMessage msg=session.createTextMessage(inputs);
            provider.send(msg);
        }while(!inputs.equalsIgnoreCase("quit"));

        scanner.close();
        connection.close();
    }
}