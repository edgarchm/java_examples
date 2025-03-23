package com.testing;

import com.google.gson.Gson;
public class ReadWriteJson {
	public static User ReadJson(String jsonstring, Gson gson) {
		return gson.fromJson(jsonstring, User.class);
	}
	public static String WriteJson(User user, Gson gson) {	
		return gson.toJson(user);
	}
	
	class User {
		String name;
		int age;
		String email;
	}
	public static void main(String[] args) {
		String jsonString = "{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@example.com\"}";
		Gson gson = new Gson();
		
		//READ from JSON
		User user = ReadJson(jsonString, gson);
		System.out.println("Name: " + user.name);
		System.out.println("Age: " + user.age);
		System.out.println("Email: " + user.email);

		// WRITE into JSON
		user.name = "Jane Doe";
		user.age = 25;
		user.email = "jane.doe@example.com";
		String jsonstring = WriteJson(user, gson);
		System.out.println("JSON: " + jsonstring);
	}
}
