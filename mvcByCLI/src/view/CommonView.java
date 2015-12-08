package view;

import controller.Command;
import controller.MyCommand;

/**
 * <h1> Class CommonView </h1>
 * @author Gal Ben Evgi
 *
 */
public abstract class CommonView extends Thread{

	
	Command c; 

	public abstract void run();

	public Command getC() {
		return c;
	}

	public void setC(Command c) {
		this.c = c;
	}
	
		

	

}
