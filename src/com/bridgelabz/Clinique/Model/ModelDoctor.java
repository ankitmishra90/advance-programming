package com.bridgelabz.Clinique.Model;

public class ModelDoctor {
	
String DrName;
long DrId;
String Specialization;
long Availability;


public String getDrName() {
	return DrName;
}
public void setDrName(String drName) {
	DrName = drName;
}
public long getDrId() {
	return DrId;
}
public void setDrId(long drId) {
	DrId = drId;
}
public String getSpecialization() {
	return Specialization;
}
public void setSpecialization(String specialization) {
	Specialization = specialization;
}
public long getAvailability() {
	return Availability;
}
public void setAvailability(long availability) {
	Availability = availability;
}

}
