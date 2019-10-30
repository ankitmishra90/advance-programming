package com.bridgelabz.Clinique.Model;

public class Appointment {
	
private  ModelDoctor docter;
private  ModelPatients patients;
private String date;

public ModelDoctor getDocter() {
	return docter;
}
public void setDocter(ModelDoctor docter) {
	this.docter = docter;
}
public ModelPatients getPatients() {
	return patients;
}
public void setPatients(ModelPatients patients) {
	this.patients = patients;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}
