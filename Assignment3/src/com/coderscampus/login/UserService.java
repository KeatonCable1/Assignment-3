package com.coderscampus.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
	public List<User> readUserDataFromFile(String FileName) {
		List<User> users = new ArrayList<>();
		
		try {
			File file = new File(FileName);
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] userData = line.split(",");
				
				if (userData.length == 3) {
					String username = userData[0];
					String password = userData[1];
					String name = userData[2];
					
					User user = new User(username, password, name);
					users.add(user);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.print("File not found: " + FileName);
		}
		
		return users;
	}
}
