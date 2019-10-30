package com.bridgelabz.design.proxy;

public class CommandExecuterProxy implements CommandExecutor {
	
	private boolean isAdmin;
	private CommandExecutor executor ;
	
public void CommandExecutorProxy(String user, String pwd)
{
	
	if("Ankit".equals(user) && "Mishra".equals(pwd)) isAdmin=true;
	executor=new CommandExcutorImpl();
}

	@Override
	public void runCommand(String cmd) throws Exception {
		
		if(isAdmin) {
			executor.runCommand(cmd);
		}
		else
		{
			if(cmd.trim().startsWith("rm")) {
				throw new Exception("rm command is not allowed for non-admin users. ");
			}
			else {
				executor.runCommand(cmd);
			}
		}
		
	}

}
