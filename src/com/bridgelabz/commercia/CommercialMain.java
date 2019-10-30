package com.bridgelabz.commercia;

import java.util.Scanner;

import com.bridgelabz.commercial.repository.CommercialRepository;

public class CommercialMain {
	
public static void menu() throws Exception
{
	Scanner sc=new Scanner(System.in);
	 CommercialRepository cm=new  CommercialRepository();
	
	//System.out.println("1:add\t2:display\t3:update\t4:Delete");
	 int num;
	do {
		System.out.println("Enter The Option");
		System.out.println("1:add\t2:display\t3:update\t4:Delete");
	    num=sc.nextInt();
	switch(num) {
	case 1:
		cm.getStockAc();
		break;
	case 2:
		cm.display();
		break;
	case 3:
		cm.update();
		break;
	case 4:
		cm.delete();
		break;
	default:
	System.out.println("Wrong Option:");
	}
	System.out.print("\n");
	}while(num<5);
}
public static void main(String[] ar) throws Exception
{
	menu();
}
}
