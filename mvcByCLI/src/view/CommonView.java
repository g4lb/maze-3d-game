package view;

import controller.Controller;

/**
 * <h1> Class CommonView </h1>
 * @author Gal Ben Evgi
 *
 */
public abstract class CommonView implements View{

	Controller ctr;
	
	
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
