package com.coderscampus.login;

import java.util.List;
import java.util.Scanner;

public class UserLoginApplcation {
	public static void main(String[] args) {
		UserService userservice = new UserService();
		List<User> users = userservice.readUserDataFromFile("data.txt");
		
		Scanner scanner = new Scanner(System.in);
		int loginAttempts = 0;
		boolean loggIn = false;
		
		while (loginAttempts < 5 && !loggIn) {
			System.out.println("Enter your email: ");
			String email = scanner.nextLine().toLowerCase();
			
			System.out.print("Enter your password: ");
			String password = scanner.nextLine();
			
			for (User user : users) {
				if (user.getUsername().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
					System.out.println("Welcome: " + user.getName());
					loggIn = true;
					break;
				}
			} 
			if (!loggIn) {
				System.out.println("Invalid login, please try again");
				loginAttempts++;
			}
		}
		if (!loggIn) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
	} 
}
