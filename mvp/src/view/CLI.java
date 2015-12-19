package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import presenter.Command;

/**
 * <h1> Class CLI - Command Line Interface </h1>
 * data members:
 * BufferReader
 * PrintWriter
 * HashMap<String,Command> - every command has an uniqe key
 * 
 * run method - open a menu you can choose
 * 1)Path - show all files in path
 * 2)generateMaze - generate any type of Maze3d
 * 3)displayMaze - display a maze3d
 * 4)showListOfMaze - display all available maze
 * 5)getCrossSection - getting a 2dMatrix by x,y or z
 * 6)saveMaze - save maze3d to file
 * 7)loadMaze - load maze3d from file
 * 8)solveMaze - solve a maze3d by algorithm
 * 9)displaySolution - display a alogrithm's solution - you must solve a maze before display
 * 10)mazeSize - shows a maze size
 * 11)fileSize - shows a file size
 * 
 * 
 * 
 * all this commands go to Presenter->MyModel->Presenter->View by MVC design
 * 
 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 * 
 */
public class CLI extends Thread{
	

	BufferedReader in;
	PrintWriter out;
	String userCommand = "";
	
	
	public String getUserCommand() {
		return userCommand;
	}
	public void menu()
	{
		 System.out.println("please insert the name of command (key)");
		 System.out.println("1)Dir\n2)generateMaze\n3)displayMaze\n4)showListOfMaze\n5)getCrossSection\n"
		 		+ "6)saveMaze\n7)loadMaze\n8)solveMaze\n9)displaySolution\n10)mazeSize\n11)fileSize");
	}
	

	@Override
	public void run(){
		 @SuppressWarnings("resource")
		 Scanner in = new Scanner(System.in);
		 ArrayList<String> s= new ArrayList<>();
		 String str;
		
		 while(true){
			 out.flush();
			 menu();
			 str = in.nextLine();
			 s.add(0,str);
			 
			 try {
				 /**TODO check if command not exist**/
			 if(s.get(0).equals("exit")){
				 userCommand = s.get(0);
				 notify();
				 continue;
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
//	public CLI(BufferedReader in, PrintWriter out) {
//		this.in = in;
//		this.out = out;
//		
//		
//	}
	public CLI() {
		this.in = new BufferedReader(new InputStreamReader(System.in)); 
		this.out = new PrintWriter(System.out); 
		
	}
	

	public void setIn(BufferedReader in) {
		this.in = in;
	}	
	public void setOut(PrintWriter out) {
		this.out = out;
	}

}
	


				


	 
	 
	 
	 
	
	 
	 

