package com.wip.view;

import java.util.Scanner;
import java.util.function.BiPredicate;
import com.wip.Controller.ProductController;
import com.wip.Controller.ProductInterface;

public class MainClass {

	public static void main(String[] args) {

		System.out.println("Welcome to Ecom - App !!");
		ProductInterface pc = new ProductController();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username:");
		String user = sc.next();
		System.out.println("Enter password:");
		String pass = sc.next();
		if(!((BiPredicate<String, String>)
				(un, pwd) -> un.equals("Naveen") && pwd.equals("123")).test(user, pass)) {
			System.out.println("Invalid credentials");
			return;
		}
		System.out.println("Login Successfull");
		String continueChoice=null;
		
		do {
			System.out.println("Enter your choice:");
			System.out.println("1. Add Product");
			System.out.println("2. View Product");
			System.out.println("3. Add Elec. Product");
			System.out.println("4. View Elec. Product");
			System.out.println("5. Update Product");
			System.out.println("6. Delete Product");
			System.out.println("7. Add Product using Stored Procedure");
			System.out.println("8. Find Product Name by ID");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				pc.addProduct();
				break;
			}
			case 2: {

				pc.viewProduct();
				break;
			}
			case 3: {

				pc.viewProduct();
				break;
			}
			case 4: {

				pc.viewProduct();
				break;
			}
			case 5: {

				pc.updateProduct();
				break;
			}
			case 6: {

				pc.deleteProduct();
				break;
			}
			case 7:{
				pc.addProductUsingProcedure();
				break;
			}
			case 8:{
				pc.findProductNameById();
				break;
			}
			default: {
				System.out.println("Choose the right choice ....");
			}
			}
			System.out.println("Do u wanna to continue? Y or y");
			continueChoice = sc.next();
		} while (continueChoice.equals("Y") || continueChoice.equals("y"));
		
		System.out.println("Thanks for using the system...");
		System.exit(0);
	}
}
