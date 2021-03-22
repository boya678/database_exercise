package com.appgate.databaseexercise.kafka;

import static com.appgate.databaseexercise.kafka.ConnectionProperties.getProps;
import static com.appgate.databaseexercise.kafka.ConnectionProperties.getTopic;

import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class MessageConsumer {

	public static void consume() {
	        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getProps());
	        consumer.subscribe(Arrays.asList(getTopic()));
	        int count=0;
	        while (count<=100) {
	            ConsumerRecords<String, String> records = consumer.poll(500);
	            for (ConsumerRecord<String, String> record : records) {
	            	count++;
	                System.out.println(	"topic=" + record.topic() + 
	                					" partition=" + record.partition() +  
	                					" offset=" + record.offset() +
	                					" key=" + record.key() + 
	                					" value " +  record.value()
	                					);

				}
	        }
	    }

}
