package com.appgate.databaseexercise.utils;

public class Variables {
	public static final String DBUSER="postgres";
	public static final String DBPASS="123456";
	public static final String DBURL="localhost";
	public static final String DBNAME="test";
	public static final String CREATE_TABLE="CREATE TABLE empleado( idEmpleado SERIAL PRIMARY KEY, nombre VARCHAR NOT NULL, meses SMALLINT NOT NULL, salario DECIMAL(15,0) NOT NULL);";
}
