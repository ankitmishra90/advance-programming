package com.bridgelabz.Json;

import java.util.Scanner;

import com.bridgelabz.invenntorymanagement.service.JsonServiceImplimentation;

public class JsonMain {

	public static void menu() throws Exception {
		Scanner sc = new Scanner(System.in);

		JsonServiceImplimentation ob = new JsonServiceImplimentation();

		System.out.println("Enter option");
		System.out.println("1:Add\t2:Display\t3:Update\t4:Delete");
		int op = sc.nextInt();
		switch (op) {
		case 1:
			ob.getResult();
			break;
		case 2:
			ob.read();
			break;
		case 3:
			ob.update();
			break;
		case 4:System.out.println("Enter name for delete");
		String name=sc.next();
			ob.delete(name);
			break;
		default:
			System.out.println("Wrong option");
		}

	}

	public static void main(String[] ar) throws Exception {
		menu();
	}
}