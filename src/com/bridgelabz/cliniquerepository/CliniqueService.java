package com.bridgelabz.cliniquerepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.Clinique.Model.Appointment;
import com.bridgelabz.Clinique.Model.ModelDoctor;
import com.bridgelabz.Clinique.Model.ModelPatients;
import com.bridgelabz.util.Util;

import org.json.simple.parser.JSONParser;

public class CliniqueService {

	public void  DrDetails() {
		
		//Model dr.
		
		ModelDoctor md = new ModelDoctor();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The DrName :");
		String drname = sc.nextLine();
		md.setDrName(drname);
		System.out.println("Enter The DrId:");
		Long id = sc.nextLong();
		md.setDrId(id);
		System.out.println("Enter The Spcl:");
		String spcl = sc.next();
		md.setSpecialization(spcl);
		System.out.println("Enter The Availability:");
		Long avail = sc.nextLong();
		md.setAvailability(avail);
		
		

		write(md);


	}
	
	//Model Patients.

	public ModelPatients patientsDetails() {
		LinkedList<ModelPatients> list=new LinkedList();
		ModelPatients mp = new ModelPatients();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The PatientsName:");
		String patientsName = sc.next();
		mp.setPatientsName(patientsName);
		System.out.println("PatientsId:");
		long patientsId = sc.nextLong();
		mp.setPatientsId(patientsId);
		System.out.println("PatientsMobail");
		long mobail = sc.nextLong();
		mp.setPatientsMobail(mobail);
		System.out.println("Age");
		long age = sc.nextLong();
		mp.setAge(age);
		
		write(mp);
		return mp;

	}
	
	//write for dr.

	public void write(ModelDoctor md) {
		JSONArray array = new JSONArray();
		JSONObject ob;
		ob = new JSONObject();
		ob.put("DrName", md.getDrName());
		ob.put("DrId", md.getDrId());
		ob.put("Specialization", md.getSpecialization());
		ob.put("Availability", md.getAvailability());

		array.add(ob);
		try {
			PrintWriter pw = new PrintWriter("Doctors.json");
			pw.write(array.toJSONString());
			pw.flush();
			pw.close();

			System.out.println("Dr.Element is added:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//write for Patients.

	public void write(ModelPatients mp) {
		JSONArray array = new JSONArray();
		JSONObject ob;
		ob = new JSONObject();
		ob.put("PatientsName", mp.getPatientsName());
		ob.put("PatientsId", mp.getPatientsId());
		ob.put("PatientsMobail", mp.getPatientsMobail());
		ob.put("Age", mp.getAge());

		array.add(ob);
		try {
			PrintWriter pw = new PrintWriter("Patient.json");
			pw.write(array.toJSONString());
			pw.flush();
			pw.close();

			System.out.println("Patient Element is added:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//takeApoointment
	
	 public void takeApoointment() {
		ModelPatients mp=patientsDetails();
			display();
			System.out.println("select id:");
			int id=Util.nextInt();
			JSONObject jo=new JSONObject();
			jo.put("patientsName", mp.getPatientsName());
			jo.put("patientsId", mp.getPatientsId());
			jo.put("patientsMobail", mp.getPatientsMobail());
			jo.put("Age", mp.getAge());
			jo.put("did", id);
			
			JSONArray array=new JSONArray();
			array.add(jo);
			try {
				PrintWriter pw=new PrintWriter("take.json");
				pw.write(array.toJSONString());
				pw.flush();
				pw.close();
				System.out.println("Apoointment Fixed:");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			   
			
	 }
	//display for dr.
	 
	 public static void display()
	 {
		 List<ModelDoctor>list =read();
		 ModelDoctor md=null;
		
		
		 System.out.println("Display Of Dr.Details:");
		 for(int i=0;i<list.size();i++) {
			
			 md=list.get(i);
			System.out.println(md.getDrName()+"\t"+md.getDrId()+"\t"+md.getSpecialization()+"\t"+md.getAvailability());
		     }
	 }
	 //display for paitent
	 
	 public static void display1()
	 {
		List<ModelPatients>list =read1();
		 ModelPatients mp=null;
		 System.out.println("Display Of Patients Details:");
		 for(int i=0;i<list.size();i++) {
			 mp=list.get(i);
			System.out.println(mp.getPatientsName()+"\t"+mp.getPatientsId()+"\t"+mp.getPatientsMobail()+"\t"+mp.getAge());
		     }
	 }
	 //read for dr.
	 
	 
	public static LinkedList<ModelDoctor> read() {

		LinkedList<ModelDoctor> list = new LinkedList<ModelDoctor>();
		try {
			Object obj = new JSONParser().parse(new BufferedReader(new FileReader("Doctors.json")));
			JSONArray array = (JSONArray) obj;
			JSONObject ob;
			ModelDoctor md;
			for (int i = 0; i < array.size(); i++) {
				
				md = new ModelDoctor();
			    ob=(JSONObject)array.get(i);
				
				md.setDrName((String) ob.get("DrName"));
				md.setDrId((Long) ob.get("DrId"));
				md.setSpecialization((String)ob.get("Specialization"));
				md.setAvailability((long) ob.get("Availability"));
				list.add(md);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	 //read for paitent
	
	public static LinkedList<ModelPatients> read1() {

		LinkedList<ModelPatients> list = new LinkedList<ModelPatients>();
		try {
			Object obj = new JSONParser().parse(new BufferedReader(new FileReader("Patient.json")));
			JSONArray array = (JSONArray) obj;
			JSONObject ob;
			ModelPatients mp;
			for (int i = 0; i < array.size(); i++) {
				mp = new ModelPatients();

				mp.setPatientsName((String) ((JSONObject) (array.get(i))).get("PatientsName"));
				mp.setPatientsId((long) ((JSONObject) (array.get(i))).get("PatientsId"));
				
				mp.setPatientsMobail((long) ((JSONObject) (array.get(i))).get("PatientsMobail"));
				mp.setAge((long) ((JSONObject) (array.get(i))).get("Age"));
				list.add(mp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
