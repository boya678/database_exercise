# Database Exercise

This project is an implentation for a postgres exercise, Kafka and DynamoDB

## Features

- Easy to run
- using models

## Tech Stack
- [Java] 
- [Gradle] 
- [JDBC] 
- [OpenCSV] 
- [AWS SDK]
- [KAFKA]

## Data

- the data is under src/main/resources/data.csv file
- kafka server is on cloud under free account on https://www.cloudkarafka.com/, so you can run anywhere
- for dynamo you need to configure a aws cli credentials

## Run

- To run this project you need to have a postgres and dynamodb database on localhost with password 123456, otherwise you can run your own postgres with docker like this:

```sh
docker run -d --name some-postgres -e POSTGRES_PASSWORD=123456 -p 5432:5432 -d postgres
docker run -d -p 8000:8000 amazon/dynamodb-local
```
- next, you need to execute the gradle task with your gradle cli or with gradle wrapper

- with cli
```sh
gradle run
```
- with wrapper

```sh
gradlew.bat run
```
```sh
./gradlew run
```

#Evidences:
- the command line will show you the results.