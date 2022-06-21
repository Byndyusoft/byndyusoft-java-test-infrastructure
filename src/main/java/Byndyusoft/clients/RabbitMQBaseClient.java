package Byndyusoft.clients;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class RabbitMQBaseClient {

    protected static Channel createConnection(String hostName, Integer port, String userName, String userPassword,
                                       String queueName) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(hostName);
        factory.setPort(port);
        factory.setUsername(userName);
        factory.setPassword(userPassword);
        factory.setVirtualHost("/");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(queueName, true, false, false, null);

        return channel;
    }

    public static void publishMessage(String hostName, Integer port, String userName, String userPassword, String queueName,
                               String message) throws IOException, TimeoutException {
        RabbitMQBaseClient.createConnection(hostName, port, userName, userPassword, queueName)
                .basicPublish("", queueName, null, message.getBytes());
    }

}
