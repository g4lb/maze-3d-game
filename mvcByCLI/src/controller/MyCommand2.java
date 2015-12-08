package controller;


/**
 * <h1> Class MyCommand2 </h1>
 * a Command - print
 * 
 * @author Gal Ben Evgi
 *
 */
public class MyCommand2 implements Command {

	int x=0;
	@Override
	public void doCommand() {
		System.out.println("Command Calculate!");
		x+=1;

	}

}
