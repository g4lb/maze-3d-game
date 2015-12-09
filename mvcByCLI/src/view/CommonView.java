package view;

import controller.Command;
import controller.Controller;
import controller.MyCommand;

/**
 * <h1> Class CommonView </h1>
 * @author Gal Ben Evgi
 *
 */
public abstract class CommonView extends Thread implements View{

	Controller ctr;
	

	public abstract void run();
	
	public CommonView(Controller ctr)
	{
		this.ctr = ctr;
	}

//	public Command getC() {
//		return c;
//	}
//
//	public void setC(Command c) {
//		this.c = c;
//	}
	
		

	

}
