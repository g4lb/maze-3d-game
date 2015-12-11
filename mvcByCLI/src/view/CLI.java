package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
		 ArrayList<String> s= new ArrayList<>();
		 String str;
		

		
		 while(true){
			 out.flush();
			 System.out.println("please insert the name of command (key)");
			 System.out.println("1)printPath\n2)generateMaze");
			 str = in.nextLine();
			 s.add(0,str);
		 
			 if(!hash.containsKey(s.get(0)) && !s.get(0).equals("exit")){
				 System.out.println("this command not exsist please try again - for exit write 'exit'");
				 continue;
			 	}
			 else if(s.get(0).equals("exit")){
				 System.out.println("Bye Bye!");
				 break;
			 	}
			 else if(s.get(0).equals("generateMaze")){
				 ArrayList<String> arr = new ArrayList<String>();
				 String str2;
				 System.out.println("please select the name of the maze, width, length and dim");
				 for (int i = 0; i < 4; i++){
				 str2 = in.nextLine();
				 arr.add(i,str2);
			 	 }
				 hash.get(s.get(0)).doCommand(arr);
				 continue;
			 	}
		
			 	hash.get(s.get(0)).doCommand(s);
		 		}
}	
}
	


				


	 
	 
	 
	 
	
	 
	 

