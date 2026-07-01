import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class Producer {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        Siparis[] siparisler = {
            new Siparis(1, "Kahve", 35.0),
            new Siparis(2, "Çay", 15.0),
            new Siparis(3, "Sandviç", 75.0),
            new Siparis(4, "Su", 10.0),
            new Siparis(5, "Tost", 50.0)
        };

        for (Siparis siparis : siparisler) {
            ProducerRecord<String, String> record = 
                new ProducerRecord<>("i2i-topic", siparis.toJson());
            producer.send(record);
            System.out.println("Gönderildi: " + siparis);
        }

        producer.close();
        System.out.println("Tüm siparişler gönderildi!");
    }
}