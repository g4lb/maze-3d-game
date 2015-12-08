package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;


import controller.Command;
import controller.MyCommand;

public class CLI extends CommonView{
	
	BufferedReader in;
	PrintWriter out;
	private HashMap<String,Command> hash;
	
	public CLI(Command c){
		this.c = c;
	}

	public CLI(BufferedReader in, PrintWriter out) {
		super();
		this.in = in;
		this.out = out;
		
	}

	@Override
	public void run() {
		
	}
	
	



				
	}


	 
	 
	 
	 
	
	 
	 

