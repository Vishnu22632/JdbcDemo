package com.view;

import java.util.Scanner;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

public class TestJdbc {

	public static void main(String[] args) {
		System.out.println("******************JDBC CRUD****************** ");

		boolean flag = true;

		do {

			Scanner scn = new Scanner(System.in);
			System.out.println("PRESS 1 TO INSERT");
			System.out.println("PRESS 2 TO UPDATE");
			System.out.println("PRESS 3 TO DELETE");
			System.out.println("PRESS 4 TO DISPLAY USER");
			System.out.println("PRESS 5 TO DISPLAY ALL USERS");
			System.out.println("PRESS 6 TO EXIT");

			int choice = scn.nextInt();
			System.out.println();

			switch (choice) {

			case 1:
				addUser();
				break;

			case 2:
				updateUser();
				break;

			case 3:
				delete();
				break;

			case 4:
				displayUser();
				break;

			case 5:
				displayAllUser();
				break;

			case 6:
				flag = false;
				System.out.println("Thank you for using App ");
				System.out.println("Good Bye...");
				break;

			default:
				System.out.println("Please enter valid choice...");

			}

		} while (flag);

	}

	static void addUser() {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Name : ");
		String name = scn.next();

		System.out.println("Enter Email : ");
		String email = scn.next();

		System.out.println("Enter Address : ");
		String address = scn.next();

		System.out.println("Enter Phone : ");
		String phone = scn.next();

		User user = new User();

		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		user.setPhone(phone);

		UserServiceImpl us = new UserServiceImpl();

		us.addUser(user);

		System.out.println("User added...");
		System.out.println("*************************************************************");

	}

	static void delete() {
		User user = new User();
		UserService us = new UserServiceImpl();
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter id of user to be deleted : ");
		int id = scn.nextInt();

		us.deleteUser(id);

		System.out.println("User deleted successfully...");
		System.out.println("*************************************************************");

	}

	static void updateUser() {
		User user=new User();
		Scanner scn=new Scanner(System.in);
		
		UserService us=new UserServiceImpl();
		
		System.out.println("Enter User Id : ");
		user.setId(scn.nextInt());
		
		System.out.println("Enter User Name : ");
		user.setName(scn.next());
		
		System.out.println("Enter User Email : ");
		user.setEmail(scn.next());
		
		System.out.println("Enter User Address : ");
		user.setAddress(scn.next());
		
		System.out.println("Enter User Phone : ");
		user.setPhone(scn.next());
		
		
		us.updateUser(user);
		
		System.out.println("Updated succussfully....");
		
		
		
		
		
		

	}

	static void displayUser() {
		Scanner scn = new Scanner(System.in);

		User u = new User();
		UserService us = new UserServiceImpl();

		System.out.println("Enter id of user to be displayed : ");
		int id = scn.nextInt();
		System.out.println("*************************************************************");

		us.getUser(id);

	}

	static void displayAllUser() {
		UserService us = new UserServiceImpl();

		us.getAllUser();

	}

}
