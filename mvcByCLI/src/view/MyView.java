package view;

import java.io.File;
import java.util.ArrayList;

import controller.Controller;

/**
 * <h1> Class MyView </h1>
 * @author Gal Ben Evgi
 *
 */
public class MyView extends CommonView {

	CLI cli;
	
	public MyView(Controller ctr) {
		super(ctr);
		this.cli = new CLI(ctr.getHash());
	}
	
	@Override
	public void printLearn() {
		System.out.println("printLearn");
		
	}

	@Override
	public void start() {
	
		cli.run();
		
	}

	public void displayDir(ArrayList<String> str){
		for (String string : str) {
			System.out.println(str);
		}
	}
	



}
