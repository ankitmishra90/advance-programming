package com.bridgelabz.invenntorymanagement.service;

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

import com.bridgelabz.jsonModel.JsonModel;

public class JsonServiceImplimentation {

	public static void getResult() throws Exception {
		JsonModel ob = new JsonModel();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Name:");
		String name = sc.nextLine();
		ob.setName(name);
		System.out.println("Enter The price:");
		double price = sc.nextDouble();

		ob.setPrice(price);
		System.out.println("Enter The weight:");
		int weight = sc.nextInt();
		ob.setWeight(weight);

		write(ob);
	}

	public static void write(JsonModel ob) throws Exception {
		Object obj = new JSONParser().parse(new BufferedReader(new FileReader("AnkitFileName.json")));
		JSONArray list = (JSONArray)obj;
		//JSONArray list =  new JSONArray();
		JSONObject jo=new JSONObject();
		jo.put("propertiesName", ob.getName());
		jo.put("price", ob.getPrice());
		jo.put("weight", ob.getWeight());

		list.add(jo);
		try (FileWriter file = new FileWriter("AnkitFileName.json")) {
			
			file.write(list.toJSONString());
			file.flush();
			file.close();
			System.out.println("element is added");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<JsonModel> read() {
		List<JsonModel> list=new LinkedList<JsonModel>();
		try {
			Object ob = new JSONParser().parse(new BufferedReader(new FileReader("AnkitFileName.json")));

			JSONArray array = (JSONArray) ob;// type casting
			
			JsonModel ob1;

			for (int i = 0; i < array.size(); i++) {
				ob1=new JsonModel();
				JSONObject obj = (JSONObject) array.get(i);
				System.out.println(obj.get("propertiesName") + "\n" + obj.get("price") + "\n" + obj.get("weight"));
				ob1.setName((String) obj.get("propertiesName"));;
				ob1.setPrice((double) obj.get("price"));
				ob1.setWeight((long) obj.get("weight"));
				list.add(ob1);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public static void delete(String name) throws FileNotFoundException, IOException, ParseException 
	{
	List<JsonModel> list=read();
	for(int i=0;i<list.size();i++) {
		if(name.equalsIgnoreCase(list.get(i).getName())) {
			list.remove(list.get(i));
			//System.out.println(list.get(i).getName());
		}
		
		JSONArray list1 =  new JSONArray();
		JSONObject jo=new JSONObject();
		jo.put("propertiesName", ((JsonModel) list.get(i)).getName());
		jo.put("price", ((JsonModel) list.get(i)).getPrice());
		jo.put("weight", ((JsonModel) list.get(i)).getWeight());

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

	public static void update() {

	}
}
