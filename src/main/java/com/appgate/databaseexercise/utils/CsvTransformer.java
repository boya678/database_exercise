package com.appgate.databaseexercise.utils;

import java.io.FileReader;
import java.util.List;

import com.appgate.databaseexercise.models.User;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvTransformer {

	private List<User> userList;

	private static CsvTransformer csvTransformer;

	public static CsvTransformer init() {
		if (csvTransformer == null) {
			csvTransformer = new CsvTransformer();
			return csvTransformer;
		}

		return csvTransformer;

	}

	public List<User> Process(String path) {
		List<User> userList;
		try {
			userList = new CsvToBeanBuilder<User>(new FileReader(path)).withType(User.class).build().parse();
		} catch (Exception e) {
			return null;
		}

		return userList;
	}

}
