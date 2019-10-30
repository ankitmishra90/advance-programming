package com.bridgelabz.clinique.main;

import java.util.Scanner;

import com.bridgelabz.cliniquerepository.CliniqueService;

public class CliniqueMain {

public static void Docters()
{
	Scanner sc=new Scanner(System.in);
	CliniqueService cls=new CliniqueService();
	
	System.out.println("Enter Dr. Option:");
	
	System.out.print("1:Add\t2:DisplayOfDrDetails\t3:Delete\n");
	int num=sc.nextInt();
	switch(num) {
	case 1: cls.DrDetails();
	break;
	case 2: cls.display();
	break;
	case 3: cls.read();
	break;
	default:
    System.out.println("wrong option:");
	break;
	
	}
}
	public static void Patients() {
		CliniqueService cls=new CliniqueService();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Patients Option:");
		
		System.out.print("1:Add\t2:DisplayOfDrDetails\t3:Delete\n");
		int num=sc.nextInt();
		switch(num) {
		case 1: cls.patientsDetails();
		break;
		case 2: cls.display1();
		break;
		case 3: cls.read1();
		
		break;
		default:
		
		}
		
	}

public static void main(String[] ar)
{
	CliniqueService cls=new CliniqueService();
	Scanner sc=new Scanner(System.in);
	int num=0;
	do {
	System.out.print("1:Docters\t2:Patients\t3:takeApoointment\n");
     num=sc.nextInt();
	switch(num) {
	case 1:Docters();
		break;
		
	case 2:Patients();
		break;
		
	case 3:cls.takeApoointment();
		break;
	default:  System.out.println("wrong option:"); 
	System.out.println("please enter the correct key:");
	break;
	}
	
}    while(num<4);
}
}
