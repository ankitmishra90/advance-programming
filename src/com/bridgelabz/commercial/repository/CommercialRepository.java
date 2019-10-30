package com.bridgelabz.commercial.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 import org.json.simple.parser.JSONParser;
import com.bridgelabz.commercial.model.CommercialStockModel;
import com.bridgelabz.util.Util;

import java.util.LinkedList;

public class CommercialRepository {
	public  void getStockAc() throws Exception
	{
		CommercialStockModel cm=new CommercialStockModel();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Id:");
		long id=sc.nextLong();
		cm.setId(id);
		System.out.println("Enter The Name:");
		String name=sc.next();
		cm.setName(name);
		System.out.println("Enter The Symbol:");
		String symbol=sc.next();
		cm.setSymbol(symbol);
		System.out.println("Enter The Ammount:");
		long ammount=sc.nextLong();
		cm.setAmmount(ammount);
		System.out.println("Enter The NoOfShare:");
		long share=sc.nextLong();
		cm.setShare(share);
		
		write(cm);
		}
	public static void write(CommercialStockModel cm) throws Exception
	{
		Object ob=new JSONParser().parse(new BufferedReader(new FileReader("AnkitFileName.json")));
		JSONArray array=(JSONArray)ob;//type casting
		JSONObject jo=new JSONObject();
		jo.put("Id",     cm.getId());
		jo.put("Name",   cm.getName());
		jo.put("Symbol", cm.getSymbol());
		jo.put("Ammount",cm.getAmmount());
		jo.put("Share",  cm.getShare());
		array.add(jo);
		try(FileWriter file=new FileWriter("AnkitFileName.json"))
		{
			file.write(array.toJSONString());
			file.flush();
			file.close();
			System.out.println("Element Is Added:");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static List<CommercialStockModel> read()
	{
		List list=new LinkedList<CommercialStockModel>();
		CommercialStockModel cm1;
		try
		{
		Object ob=new JSONParser().parse(new BufferedReader(new FileReader("AnkitFileName.json")));
		JSONArray array=(JSONArray)ob;//type casting
		JSONObject jo1;
		
		for(int i=0;i<array.size();i++)
		{
			
			jo1=(JSONObject)array.get(i);
			cm1= new CommercialStockModel();
			
		    cm1.setId((long)jo1.get("Id"));
		    cm1.setName((String)jo1.get("Name"));
		    cm1.setSymbol((String)jo1.get("Symbol"));
		    cm1.setAmmount((long)jo1.get("Ammount"));
		    cm1.setShare((long)jo1.get("Share"));
		    list.add(cm1);
		   }
		
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return (List<CommercialStockModel>)list;
		
	}
	
	public static void display()
	{ 
		List<CommercialStockModel> list= read();
		CommercialStockModel stock = null;
		System.out.println("Display:");
		for(int i=0;i<list.size();i++) {
			stock=list.get(i);
		System.out.println(stock.getId()+"\t"+stock.getName()+"\t"+stock.getSymbol()+"\t"+stock.getAmmount()+"\t"+stock.getShare());
	     }
    }
	public static void update()
	{
		
		List<CommercialStockModel> list= read();
		System.out.println("Enter for update: ");
		System.out.println("1:Name\t2:Symbol\t3:Ammount\t4:Share");
		int option=Util.nextInt();
		switch(option) {
		case 1:System.out.println("Enter id:");
		       long id=Util.nextLong();
		       System.out.println("Name value:");
		       String value=Util.nextString();
		       for(int i=0;i<list.size();i++) {
		    	   if(list.get(i).getId()==id) {
		    		   list.get(i).setName(value);
		    	   }
		       }
		       break;
		case 2:System.out.println("Enter id:");
		       long id1=Util.nextLong();
		       System.out.println("Symbol");
		       String value1=Util.nextString();
		       for(int i=0;i<list.size();i++) {
		    	   if(list.get(i).getId()==id1) {
		    		   list.get(i).setSymbol(value1);
		    		  
		    	   }
		       }
		       break;
		case 3:System.out.println("Enter id:");
	       long id2=Util.nextLong();
	       System.out.println("Ammount:");
	       long value2=Util.nextLong();
	       for(int i=0;i<list.size();i++) {
	    	   if(list.get(i).getId()==id2) {
	    		   list.get(i).setAmmount(value2);
	    		 
	    	   }
	       }
	       break;
		case 4:System.out.println("Enter id:");
	       long id3=Util.nextLong();
	       System.out.println("share");
	       long value3=Util.nextLong();
	       for(int i=0;i<list.size();i++) {
	    	   if(list.get(i).getId()==id3) {
	    		   list.get(i).setShare(value3);
	    		  
	    	   }
	       }
              			
			break;
			default :System.out.println("Wrong option:");
		}
		System.out.println("Update");
		save(list);
	
		
		
		
	}
	public static void delete()
	{
		display();
		List<CommercialStockModel> list= read();
		System.out.println("Enter id for delete ");
		long id=Util.nextLong();
		//Predicate<CommercialStockModel> remove=p->(p.getId()!=id);
		list=(List<CommercialStockModel>)list.stream().filter(p->(p.getId()!=id)).collect(Collectors.toList());
		save(list);
		System.out.println("Deleted");
		}

public static void save(List<CommercialStockModel> list) {
	
	JSONArray array=new JSONArray();
	JSONObject jo;
	for(CommercialStockModel newList:list ) {
	jo=new JSONObject();
	jo.put("Id",      newList.getId());
	jo.put("Name",    newList.getName());
	jo.put("Symbol",  newList.getSymbol());
	jo.put("Ammount", newList.getAmmount());
	jo.put("Share",   newList.getShare());
	array.add(jo);
	}
	try {
		PrintWriter pw=new  PrintWriter("AnkitFileName.json");
		pw.write(array.toJSONString());
		pw.flush();
		pw.close();
		
		display();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
