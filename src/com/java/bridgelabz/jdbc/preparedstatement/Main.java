package com.java.bridgelabz.jdbc.preparedstatement;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	  CRUDOperation impl=new CRUDOperation();
	  Scanner scan=new Scanner(System.in);
	  int choice=0;
	  do {
		  System.out.println("Enter your choice\n1.create\n2.insert\n3.select\n4.update\n5.delete\n6.exit");
		 choice=scan.nextInt();
		  switch(choice) {
		  case 1:{
			  impl.create();
		  }
		  case 2:{
			  impl.insert();
			  break;
		  }
		  case 3:{
			  impl.select();
			  break;
		  }
		  case 4:{
			  impl.update();
			  break;
		  }
		  case 5:{
			  impl.delete();
			  break;
		  }
		  case 6:{
			  break;
		  }
		  default:{
			  System.out.println("wrong choice");
		  }
		  }
	  }
	  while(choice!=5);
	
	}
	

}
