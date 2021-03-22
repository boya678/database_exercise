package com.appgate.databaseexercise.kafka;

import static com.appgate.databaseexercise.kafka.ConnectionProperties.getProps;
import static com.appgate.databaseexercise.kafka.ConnectionProperties.getTopic;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MessageProducer {
	
	public static void produce() {
        Thread one = new Thread() {
            public void run() {
                try {
                    Producer<String, String> producer = new KafkaProducer<>(getProps());
                    int i = 0;
                    while(i<=100) {
                        String message = "Appgate oportunity " + Math.random();
                        producer.send(new ProducerRecord<>(getTopic(), Integer.toString(i), message));
                        Thread.sleep(500);
                        i++;
                    }
                } catch (InterruptedException v) {
                    System.out.println(v);
                }
            }
        };
        one.start();
    }

}
