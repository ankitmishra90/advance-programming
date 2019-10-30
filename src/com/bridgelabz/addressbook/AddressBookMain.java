package com.bridgelabz.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.service.AddressBookServiceImplimentation;

public class AddressBookMain {
	
public static void menu() throws FileNotFoundException, IOException, ParseException
{
	Scanner sc =new Scanner(System.in);
	
	AddressBookServiceImplimentation abs=new AddressBookServiceImplimentation();
	System.out.println("Enter option:");
	System.out.println("1:Add\t2:Display\t3:Update\t4:Delete");
	int num=sc.nextInt();
	switch(num) {
	case 1:
		abs.Details();
		break;
	case 2:
		abs.read();
		break;
	case 3:
		abs.update();
		break;
	case 4:
		abs.delete(null);
		break;
	default:
		System.out.println("option is wrong:");
	}
}
public static void main(String[] ar) throws Exception {
	menu();
}
}
