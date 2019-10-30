package com.bridgelabz.adapterdesignpattern;

public class SocketObjectAdapter  implements SocketAdapter {
	
private Socket sock=new Socket();

private Volts convertVolts(Volts v , int i) {
	return new Volts(v.getVolts()/i);	
}
@Override
public Volts get120Volt() {
	// TODO Auto-generated method stub
	return sock.getVolt();
}
@Override
public Volts get12Volt() {
	Volts v=sock.getVolt();
	return convertVolts(v,10);
}
@Override
public Volts get3Volt() {
	Volts v=sock.getVolt();
	return convertVolts(v,40);
}

}
