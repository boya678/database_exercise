package com.appgate.databaseexercise.dynamodb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

public class ConnectionManager {
	
	private static AmazonDynamoDB client;
	
	public static void initConnection() {
		client=AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
				new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", ""))
				.build(); 
	}
	
	public static void createTable(String name) {
		 CreateTableRequest request = new CreateTableRequest()
		            .withAttributeDefinitions(new AttributeDefinition(
		                     "Name", ScalarAttributeType.S))
		            .withKeySchema(new KeySchemaElement("Name", KeyType.HASH))
		            .withProvisionedThroughput(new ProvisionedThroughput(
		                     new Long(10), new Long(10)))
		            .withTableName(name);
		 CreateTableResult result = client.createTable(request);
		 System.out.println("DynamoDB table created with name: " + result.getTableDescription().getTableName());
	}
	
	public static void insertUser(String[] args) {
		if (args.length < 2) {
            System.exit(1);
        }

        String table_name = args[0];
        String name = args[1];
        ArrayList<String[]> extra_fields = new ArrayList<String[]>();

        // any additional args (fields to add to database)?
        for (int x = 2; x < args.length; x++) {
            String[] fields = args[x].split("=", 2);
            if (fields.length == 2) {
                extra_fields.add(fields);
            } else {
                System.out.format("Invalid argument: %s\n", args[x]);
                System.exit(1);
            }
        }

        System.out.format("Adding \"%s\" to \"%s\"", name, table_name);
        if (extra_fields.size() > 0) {
            System.out.println(" Additional fields:");
            for (String[] field : extra_fields) {
                System.out.format("  %s: %s\n", field[0], field[1]);
            }
        }

        HashMap<String,AttributeValue> item_values =
            new HashMap<String,AttributeValue>();

        item_values.put("Name", new AttributeValue(name));

        for (String[] field : extra_fields) {
            item_values.put(field[0], new AttributeValue(field[1]));
        }

        client = AmazonDynamoDBClientBuilder.defaultClient();

        try {
        	client.putItem(table_name, item_values);
        } catch (ResourceNotFoundException e) {
            System.err.format("Error: The table \"%s\" can't be found.\n", table_name);
            System.err.println("Be sure that it exists and that you've typed its name correctly!");
            System.exit(1);
        } catch (AmazonServiceException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Done!");
	}
	
	public static void printUser(String[] args) {
		if (args.length < 2) {
            System.exit(1);
        }

        String table_name = args[0];
        String name = args[1];
        String projection_expression = null;

        // if a projection expression was included, set it.
        if (args.length == 3) {
            projection_expression = args[2];
        }

        System.out.format("Retrieving item \"%s\" from \"%s\"\n",
                name, table_name);

        HashMap<String,AttributeValue> key_to_get =
            new HashMap<String,AttributeValue>();

        key_to_get.put("DATABASE_NAME", new AttributeValue(name));

        GetItemRequest request = null;
        if (projection_expression != null) {
            request = new GetItemRequest()
                .withKey(key_to_get)
                .withTableName(table_name)
                .withProjectionExpression(projection_expression);
        } else {
            request = new GetItemRequest()
                .withKey(key_to_get)
                .withTableName(table_name);
        }

        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();

        try {
            Map<String,AttributeValue> returned_item =
               ddb.getItem(request).getItem();
            if (returned_item != null) {
                Set<String> keys = returned_item.keySet();
                for (String key : keys) {
                    System.out.format("%s: %s\n",
                            key, returned_item.get(key).toString());
                }
            } else {
                System.out.format("No item found with the key %s!\n", name);
            }
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
	}
	
	
	
	public static void main(String[] args) {
		
	}
	
}
