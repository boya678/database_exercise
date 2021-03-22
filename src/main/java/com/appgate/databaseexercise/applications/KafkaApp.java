package com.appgate.databaseexercise.applications;

import static com.appgate.databaseexercise.kafka.ConnectionProperties.initKafkaProperties;

import com.appgate.databaseexercise.kafka.MessageConsumer;
import com.appgate.databaseexercise.kafka.MessageProducer;
import com.appgate.databaseexercise.utils.AsciiGenerator;

public class KafkaApp {

	    public static void runKafka() {
	    	AsciiGenerator.printAscci("KAFKA EXECERSICE");
	    	initKafkaProperties();
	    	MessageProducer.produce();
	    	MessageConsumer.consume();
	    }

}
