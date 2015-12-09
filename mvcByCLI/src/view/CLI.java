package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import controller.Command;

/**
 * <h1> Class CLI - Command Line Interface </h1>
 * 
 * @author Gal Ben Evgi
 *
 */
public class CLI extends Thread{
	

	BufferedReader in;
	PrintWriter out;
	HashMap<String,Command> hash;
	
	
	

	public CLI(BufferedReader in, PrintWriter out, HashMap<String,Command> hash) {
		this.in = in;
		this.out = out;
		this.hash = hash;
		
	}
	public CLI(HashMap<String, Command> hash) {
		this.hash = new HashMap<String,Command>();
		this.hash=hash;
		this.in = new BufferedReader(new InputStreamReader(System.in)); 
		this.out = new PrintWriter(System.out); 
		
	}
	

	public void setIn(BufferedReader in) {
		this.in = in;
	}



	public void setOut(PrintWriter out) {
		this.out = out;
	}



	public void setHash(HashMap<String, Command> hash) {
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
		System.out.println("1)print\n2)learn\n3)printPath");
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
	
	private void runTaskInThread(Command cmd){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				cmd.doCommand();
			}
		}).start();
	}



	

}
	


				


	 
	 
	 
	 
	
	 
	 

