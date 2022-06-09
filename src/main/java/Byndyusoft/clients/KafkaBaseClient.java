package Byndyusoft.clients;

import org.apache.kafka.common.config.*;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;


public class KafkaBaseClient {
    private static final String bootstrapServer = new Properties().getProperty("bootstrapServer");

    public void kafkaProducer() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.SECURITY_PROVIDERS_CONFIG, "SASL_SSL");
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "1");
        properties.setProperty(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, "20000");
        properties.setProperty(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "500");

    }

}
