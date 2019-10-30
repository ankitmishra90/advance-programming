package com.bridgelabz.jdbc.pdfreport;
import java.sql.*;
import java.util.Scanner;
public class MainCrud {
public static void main(String[] ar) {
	
CrudOperation co=new CrudOperation();
Scanner sc=new Scanner(System.in);
int option=0;
do {
	System.out.println("Enter option: \n1.insert\n2.select\n3.update\n4.delete");
	option=sc.nextInt();

switch(option) {
case 1:{
	 co.insert();
	 break;
}
case 2:{
	co.select();
     break;
}
case 3:{
	co.update();
	break;
}
case 4:{
	co.delete();
	break;
}
case 5:{
	break;
}
default:
	System.out.println("wrong option:");
}
}
while(option!=5);
}


}

