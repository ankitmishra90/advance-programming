package com.bridgelabz.addressbook.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.jsonModel.JsonModel;


public class AddressBookServiceImplimentation {
	public static void  Details() throws FileNotFoundException, IOException, ParseException
	{
		AddressBookModel ab=new AddressBookModel();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The FirstName:");
		String firstname=sc.nextLine();
		ab.setFirstName(firstname);
		System.out.println("Enter The LastName:");
		String LastName=sc.nextLine();
		ab.setLastName(LastName);
		System.out.println("Enter The Address:");
		String address=sc.nextLine();
		ab.setAddress(address);
		System.out.println("Enter The City:");
		String city=sc.nextLine();
		ab.setCity(city);
		System.out.println("Enter The State:");
		String state=sc.nextLine();
		ab.setState(state);
		System.out.println("Enter The Zip:");
		long zip=sc.nextInt();
		ab.setZip(zip);
		System.out.println("Enter The PhonNumber:");
		long phonumber=sc.nextInt();
		ab.setPhonNumber(phonumber);	
		
		write(ab);
	}
	public static List<AddressBookModel> write(AddressBookModel ab) throws FileNotFoundException, IOException, ParseException
	{
		Object obj = new JSONParser().parse(new BufferedReader(new FileReader("AnkitFileName.json")));
		JSONArray list=(JSONArray)obj;
		//JSONArray list= new JSONArray();
		JSONObject jo=new JSONObject();
		{
			jo.put("FirstName", ab.getFirstName());
			jo.put("LastName", ab.getLastName());
			jo.put("Address", ab.getAddress());
			jo.put("City", ab.getCity());
			jo.put("State", ab.getState());
			jo.put("Zip", ab.getState());
			jo.put("PhonNumber", ab.getPhonNumber());
			list.add(jo);
			try(FileWriter file=new FileWriter("AnkitFileName.json"))
			{
				file.write(list.toJSONString());
				file.flush();
				file.close();
				System.out.println("Element Is Added:");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return list;
		}
		public static List<AddressBookModel> read()
		{
			 List<AddressBookModel> list1=new LinkedList<AddressBookModel>();
			 try
			 {
				 Object objs=new JSONParser().parse(new BufferedReader(new FileReader("AnkitFileName.json")));
				 
				 JSONArray array=(JSONArray)objs;
				 
				 JSONObject obj1;
				 
				 AddressBookModel ab1;
				 
				 for(int i=0;i<array.size();i++)
				 {
					 ab1=new AddressBookModel();
					 obj1=(JSONObject)array.get(i);
					 System.out.println(obj1.get("FirstName") + "\t" + obj1.get("LastName") + "\t" + obj1.get("Address")+"\t"+obj1.get("City")+"\t"+obj1.get("State")+"\t"+obj1.get("Zip")+"\t"+obj1.get("PhonNumber"));
					 ab1.setFirstName((String) obj1.get("FirstName"));
					 ab1.setLastName((String) obj1.get("LastName"));
					 ab1.setAddress((String) obj1.get("Address"));
					 ab1.setCity((String) obj1.get("City"));
					 ab1.setState((String) obj1.get("State"));
					 ab1.setZip((long)obj1.get("Zip"));
					 ab1.setPhonNumber((long) obj1.get("PhonNumber"));
					 list1.add(ab1);
				 }
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 return list1 ;
		}
		public static void delete(String name) throws FileNotFoundException, IOException, ParseException 
		{
		List<AddressBookModel> list=read();
		for(int i=0;i<list.size();i++) {
			if(name.equalsIgnoreCase(list.get(i).getFirstName())) {
				list.remove(list.get(i));
				//System.out.println(list.get(i).getName());
			}
			
			JSONArray list1 =  new JSONArray();
			JSONObject jo=new JSONObject();
			jo.put("FirstName", ((AddressBookModel) list.get(i)).getFirstName());
			jo.put("LastName", ((AddressBookModel) list.get(i)).getLastName());
			jo.put("Address", ((AddressBookModel) list.get(i)).getAddress());
			jo.put("City", ((AddressBookModel) list.get(i)).getState());
			jo.put("State", ((AddressBookModel) list.get(i)).getAddress());
			jo.put("Zip", ((AddressBookModel) list.get(i)).getZip());
			jo.put("PhonNumber", ((AddressBookModel) list.get(i)).getPhonNumber());

			list1.add(jo);
			
			try (FileWriter file = new FileWriter("AnkitFileName.json")) {
				file.write(((JSONArray) list1).toJSONString());
				file.flush();
				file.close();
				System.out.println("element is deleted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		}
		public void update() {
			
		}

	}

