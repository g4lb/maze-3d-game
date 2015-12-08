package controller;

/**
 * <h1> Class MyCommand </h1>
 * a Command - print
 * 
 * @author Gal Ben Evgi
 *
 */

public class MyCommand implements Command {
	
	int x=0;

	@Override
	public void doCommand() {
		System.out.println("Command Print!");
		while(true)
		x++;
		

	}

}
