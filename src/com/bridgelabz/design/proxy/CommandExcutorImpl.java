package com.bridgelabz.design.proxy;

public class CommandExcutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String cmd) throws Exception {
		// TODO Auto-generated method stub
		Runtime.getRuntime().exec(cmd);
		System.out.println("'"+cmd+"' command executed.");
	}
	

}
