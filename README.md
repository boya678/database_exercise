# Reqres Automation

This project is an implentation for a postgres exercise

## Features

- Easy to run
- using models

## Tech Stack
- [Java] - HTML enhanced for web apps!
- [Gradle] - awesome web-based text editor
- [JDBC] - Markdown parser done right. Fast and easy to extend.
- [OpenCSV] - Markdown parser done right. Fast and easy to extend.

## Data

- the data is under src/main/resources/data.csv file

## Run

- To run this project you need to have a postgres database on localhost with password 123456, otherwise you can run your own postgres with docker like this:

```sh
docker run --name some-postgres -e POSTGRES_PASSWORD=123456 -p 5432:5432 -d postgres
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
- the command line will show you the query result