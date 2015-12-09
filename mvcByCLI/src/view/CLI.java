package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import controller.Command;
import controller.Controller;

/**
 * <h1> Class CLI - Command Line Interface </h1>
 * 
 * @author Gal Ben Evgi
 *
 */
public class CLI extends CommonView{
	

	BufferedReader in;
	PrintWriter out;
	private HashMap<String,Command> hash;
	
	
	

	public CLI(BufferedReader in, PrintWriter out, HashMap<String,Command> hash, Controller ctr) {
		super(ctr);
		this.in = in;
		this.out = out;
		this.hash = hash;
		
	}

	

	@Override
	public void run(){
		 Scanner in = new Scanner(System.in);
		 String s="";
		 int a;

		
	while(true){
		out.flush();
		System.out.println("please insert the name of command (key)");
		System.out.println("1)print\n2)calculate\n3)writing\n4)learning");
		 s = in.nextLine();
		 
		if(!hash.containsKey(s) && !s.equals("exit")){
			System.out.println("this command not exsist please try again - for exit write 'exit'");
			continue;
		}
		 else if(s.equals("exit")){
			 break;
		 }
		runTaskInThread(hash.get(s));
	}
		
		
		
		
		
	}
	
	private void runTaskInThread(final Command cmd){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				cmd.doCommand();
			}
		}).start();
	}

}
	


				


	 
	 
	 
	 
	
	 
	 

