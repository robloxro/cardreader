package com.roblox.cardreader;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;

import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Properties;
import java.time.Instant;

@RestController
@RequestMapping(path = "/cardCheck")
public class CheckinController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path={"/v1.0","/"})
    //long id, Date data, long cardId, String username, String action
    public CardCheck cardCheck(@RequestParam(value = "cardId", defaultValue = "0") long cardId) {
        return new CardCheck(counter.incrementAndGet(), cardId, new Date().getTime(), "User", "IN");
    }

    @PostMapping(path={"/v1.0","/"}, consumes = "application/xml;charset=UTF-8")
    //this is the activeMq option- will not evolve this code
    public String create(@RequestBody CardCheck cardCheck) {

        String text = "Posted card action is " + cardCheck.getUsername() + " checked card " + cardCheck.getId() +
                " at " + cardCheck.getData() + " as " + cardCheck.getAction() + " action";
        // should act as the producer of messages
        //we will have two consumers - email generator and dataCollector
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        Producer<String, String> producer = new KafkaProducer<>(properties);

        //prepare the record
        String recordValue = "Posted card action is " + cardCheck.getUsername() + " checked card " + cardCheck.getId() +
                " at " + cardCheck.getData() + " as " + cardCheck.getAction() + " action";
        System.out.println("Sending message: " + recordValue);
        ProducerRecord<String, String> record = new ProducerRecord<>("cardTopic", null, recordValue);

        //produce the record
        producer.send(record);
        producer.flush();

        //close the producer at the end
        producer.close();
        return text;
    }
        @PostMapping(path={"/v2.0"}, consumes = "application/xml;charset=UTF-8")
    //this is the activeMq option- will not evolve this code
    public String createForActiveMQ(@RequestBody CardCheck cardCheck) {

        String text = "Posted card action is " + cardCheck.getUsername() + " checked card " + cardCheck.getId() +
                " at " + cardCheck.getData() + " as " + cardCheck.getAction() + " action";
        // should put an event on a topic to be consumed by the emailReader to send greetings
        // for first day and by the dataCollector to store in the db

        try {
            // Create a ConnectionFactory

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("TEST.FOO");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages
            TextMessage message = session.createTextMessage(text);

            // Tell the producer to send the message
            System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);

            // Clean up
            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
        return text;
    }
}