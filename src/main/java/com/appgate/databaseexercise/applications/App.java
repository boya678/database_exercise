package com.appgate.databaseexercise.applications;

import static com.appgate.databaseexercise.utils.Variables.CREATE_TABLE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.appgate.databaseexercise.connections.ConnectionManager;
import com.appgate.databaseexercise.models.User;
import com.appgate.databaseexercise.utils.CsvTransformer;

public class App {

	public static void main(String[] args) {
		ConnectionManager.init().connect(true);
		ConnectionManager.init().executeStatement("DROP DATABASE test");
		ConnectionManager.init().executeStatement("CREATE DATABASE test");
		ConnectionManager.init().connect(false);
		ConnectionManager.init().executeStatement(CREATE_TABLE);
		for (User user : CsvTransformer.init().Process("src/main/resources/data.csv")) {
			ConnectionManager.init().executeStatement(user.insertSQL());
		}
		printQueryResult("SELECT * FROM empleado WHERE meses<6 AND salario>5000000");
		ConnectionManager.init().close();
	}

	public static void printQueryResult(String query) {
		List<User> userList = new ArrayList<User>();
		ResultSet resultSet = ConnectionManager.init().executeStatement(query);
		try {
			while (resultSet.next()) {
				User user = new User();
				user.setIdEmpleado(resultSet.getString("idEmpleado"));
				user.setMeses(resultSet.getString("meses"));
				user.setNombre(resultSet.getString("nombre"));
				user.setSalario(resultSet.getString("salario"));
				userList.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		userList.forEach(System.out::println);

	}

}
