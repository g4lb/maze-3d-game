package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import controller.Command;

/**
 * <h1> Class CLI - Command Line Interface </h1>
 * data members:
 * BufferReader
 * PrintWriter
 * HashMap<String,Command> - every command has an uniqe key
 * 
 * run method - open a menu you can choose
 * 1)printPath
 * 2)generateMaze
 * 3)displayMaze
 * 4)showListOfMaze
 * 
 * @author Gal Ben Evgi
 *
 */
public class CLI extends Thread{
	

	BufferedReader in;
	PrintWriter out;
	HashMap<String,Command> hash;
	


	@Override
	public void run(){
		 Scanner in = new Scanner(System.in);
		 ArrayList<String> s= new ArrayList<>();
		 String str;
		
		 while(true){
			 out.flush();
			 System.out.println("please insert the name of command (key)");
			 System.out.println("1)Dir\n2)generateMaze\n3)displayMaze\n4)showListOfMaze\n5)getCrossSection\n"
			 		+ "6)saveMaze\n7)loadMaze\n8)solveMaze\n9)displaySolution\n10)mazeSize\n10)fileSize");
			 str = in.nextLine();
			 s.add(0,str);
			 try {
			 if(!hash.containsKey(s.get(0)) && !s.get(0).equals("exit")){
				 System.out.println("this command not exsist please try again - for exit write 'exit'");
				 continue;
			 	}
			 else if(s.get(0).equals("exit")){
				 hash.get(s.get(0)).doCommand(s);
				 System.out.println("Bye Bye");
				 System.exit(1);
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
			 else if(s.get(0).equals("displayMaze")){
				 	ArrayList<String> arr = new ArrayList<String>();
				 	String str2;
			 		System.out.println("Please select the name of wanted maze");
			 		str2 = in.nextLine();
			 		arr.add(0,str2);
					hash.get(s.get(0)).doCommand(arr);
			 		continue;
			 		}
			 else if(s.get(0).equals("getCrossSection")){
				 ArrayList<String> arr = new ArrayList<String>();
				 String str2;
				 System.out.println("please select the name of the maze ,Cross-sectional axis, index");
				 for (int i = 0; i < 3; i++){
				 str2 = in.nextLine();
				 arr.add(i,str2);
			 	 }
				 hash.get(s.get(0)).doCommand(arr);
				 continue;
			 	}
			 else if(s.get(0).equals("saveMaze")){
				 ArrayList<String> arr = new ArrayList<String>();
				 String str2;
				 System.out.println("please select the name of the maze, name of file");
				 for (int i = 0; i < 2; i++){
				 str2 = in.nextLine();
				 arr.add(i,str2);
			 	 }
				 hash.get(s.get(0)).doCommand(arr);
				 continue;
			 	}
			 else if(s.get(0).equals("loadMaze")){
				 ArrayList<String> arr = new ArrayList<String>();
				 String str2;
				 System.out.println("please select the name of file, name of maze");
				 for (int i = 0; i < 2; i++){
				 str2 = in.nextLine();
				 arr.add(i,str2);
			 	 }
				 hash.get(s.get(0)).doCommand(arr);
				 continue;
			 	}
			 else if(s.get(0).equals("solveMaze")){
				 ArrayList<String> arr = new ArrayList<String>();
				 String str2;
				 System.out.println("please select the name of maze and algorithm to solve");
				 for (int i = 0; i < 2; i++){
				 str2 = in.nextLine();
				 arr.add(i,str2);
			 	 }
				 hash.get(s.get(0)).doCommand(arr);
				 continue;
			 	}
			 else if(s.get(0).equals("displaySolution")){
				 ArrayList<String> arr = new ArrayList<String>();
				 String str2;
				 System.out.println("please select the name of maze");
				 str2 = in.nextLine();
				 arr.add(0,str2);
				 hash.get(s.get(0)).doCommand(arr);
				 continue;
			 	}
			 else if(s.get(0).equals("Dir")){
				 ArrayList<String> arr = new ArrayList<String>();
				 String str2;
				 System.out.println("please select path");
				 str2 = in.nextLine();
				 arr.add(0,str2);
				 hash.get(s.get(0)).doCommand(arr);
				 continue;
			 	}
			 else if(s.get(0).equals("mazeSize")){
				 ArrayList<String> arr = new ArrayList<String>();
				 String str2;
				 System.out.println("please enter the name of the maze");
				 str2 = in.nextLine();
				 arr.add(0,str2);
				 hash.get(s.get(0)).doCommand(arr);
				 continue;
			 	}
			 else if(s.get(0).equals("fileSize")){
				 ArrayList<String> arr = new ArrayList<String>();
				 String str2;
				 System.out.println("please enter the name of the file");
				 str2 = in.nextLine();
				 arr.add(0,str2);
				 hash.get(s.get(0)).doCommand(arr);
				 continue;
			 	}
			 hash.get(s.get(0)).doCommand(s);
			 		} catch (IOException e) {
			 			e.printStackTrace();
			 		}
	 }
			
	}	
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
}
	


				


	 
	 
	 
	 
	
	 
	 

