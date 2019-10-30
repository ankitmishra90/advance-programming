package com.bridgelabz.commercial.model;

public class CommercialStockModel {
	
public long id;
public String name;
public String symbol;
public long ammount;
public long share;

public void setShare(long share) {
	this.share = share;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSymbol() {
	return symbol;
}
public void setSymbol(String symbol) {
	this.symbol = symbol;
}
public long getAmmount() {
	return ammount;
}
public void setAmmount(long ammount) {
	this.ammount = ammount;
}
public long getShare() {
	return share;
}

}
