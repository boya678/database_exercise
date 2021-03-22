package com.appgate.databaseexercise.applications;

import static com.appgate.databaseexercise.dynamodb.ConnectionManager.createTable;
import static com.appgate.databaseexercise.dynamodb.ConnectionManager.initConnection;
import static com.appgate.databaseexercise.dynamodb.ConnectionManager.insertUser;
import static com.appgate.databaseexercise.dynamodb.ConnectionManager.printUser;

import com.appgate.databaseexercise.utils.AsciiGenerator;

public class DynamoApp {

	    public static void runDynamoApp() {
	    	AsciiGenerator.printAscci("DYNAMODB EXERCISE");
	    	initConnection();
	    	createTable("users");
	    	insertUser(new String[]{"users","Pedro","Language=espa�ol","Born=1989"});
	    	printUser(new String[]{"users","Pedro"});
	    }

	    
}
