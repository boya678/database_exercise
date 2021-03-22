package com.appgate.databaseexercise.applications;

public class App {

	public static void main(String[] args) {
		try {
			DatabaseApp.runDatabase();
		} catch (Exception e) {
			System.out.println("Error on database exercise: " + e.getMessage());
		}
		try {
			KafkaApp.runKafka();
		} catch (Exception e) {
			System.out.println("Error on Kafka exercise: " + e.getMessage());
		}
		try {
			DynamoApp.runDynamoApp();
		} catch (Exception e) {
			System.out.println("Error on Dynamo exercise: " + e.getMessage());
		}
		
	}

}
