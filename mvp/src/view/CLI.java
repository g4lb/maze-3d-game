package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import java.util.Scanner;

import algorithms.search.Solution;
import presenter.Command;

/**
 * 
 * <h1> Class MyView </h1>
 * this class
 * 1)calculate(some problem) - send it for Presenter
 * 2)display solution for user - get it from Presenter
 * 
 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 * ------------------------------------------------------------
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
public class CLI extends CommonView{
	

	BufferedReader in;
	PrintWriter out;
	ArrayList<String> userCommand ;
	
	
	public ArrayList<String> getUserCommand() {
		return userCommand;
	}
	
	

	@Override
	public void start(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
	
		 @SuppressWarnings("resource")
		 Scanner in = new Scanner(System.in);
		 String str;
		
		 while(true){
			 out.flush();
			 menu();
			 userCommand.clear();
			 str = in.nextLine();
			 userCommand.add(0,str);
			 
			 
				 /**TODO check if command not exist**/
			 if(userCommand.get(0).equals("exit")){
				 setChanged();
				 notifyObservers();
				 continue;
			 	}
			 else if(userCommand.get(0).equals("generateMaze")){
				 String str2;
				 System.out.println("please select the name of the maze, width, length and dim");
				 for (int i = 1; i < 5; i++){
				 str2 = in.nextLine();
				 userCommand.add(i,str2);
			 	 }
				 setChanged();
				 notifyObservers();
				 continue;
			 	}
			 else if(userCommand.get(0).equals("displayMaze")){
				 	String str2;
			 		System.out.println("Please select the name of wanted maze");
			 		str2 = in.nextLine();
			 		userCommand.add(1,str2);
			 		setChanged();
			 		notifyObservers();
			 		continue;
			 		}
			 else if(userCommand.get(0).equals("getCrossSection")){
				 String str2;
				 System.out.println("please select the name of the maze ,Cross-sectional axis, index");
				 for (int i = 1; i < 4; i++){
				 str2 = in.nextLine();
				 userCommand.add(i,str2);
			 	 }
				 setChanged();
				 notifyObservers();
				 continue;
			 	}
			 else if(userCommand.get(0).equals("saveMaze")){
				 String str2;
				 System.out.println("please select the name of the maze, name of file");
				 for (int i = 1; i < 3; i++){
				 str2 = in.nextLine();
				 userCommand.add(i,str2);
			 	 }
				 setChanged();
				 notifyObservers();
				 continue;
			 	}
			 else if(userCommand.get(0).equals("loadMaze")){
				 String str2;
				 System.out.println("please select the name of file, name of maze");
				 for (int i = 1; i < 3; i++){
				 str2 = in.nextLine();
				 userCommand.add(i,str2);
			 	 }
				 setChanged();
				 notifyObservers();
				 continue;
			 	}
			 else if(userCommand.get(0).equals("solveMaze")){
				 String str2;
				 System.out.println("please select the name of maze");
				 str2 = in.nextLine();
				 userCommand.add(1,str2);
				 setChanged();
				 notifyObservers();
				 continue;
			 	}
			 else if(userCommand.get(0).equals("displaySolution")){
				 String str2;
				 System.out.println("please select the name of maze");
				 str2 = in.nextLine();
				 userCommand.add(1,str2);
				 setChanged();
				 notifyObservers();
				 continue;
			 	}
			 else if(userCommand.get(0).equals("Dir")){
				 String str2;
				 System.out.println("please select path");
				 str2 = in.nextLine();
				 userCommand.add(1,str2);
				 setChanged();
				 notifyObservers();
				 continue;
			 	}
			 else if(userCommand.get(0).equals("mazeSize")){
				 String str2;
				 System.out.println("please enter the name of the maze");
				 str2 = in.nextLine();
				 userCommand.add(1,str2);
				 setChanged();
				 notifyObservers();
				 continue;
			 	}
			 else if(userCommand.get(0).equals("fileSize")){
				 String str2;
				 System.out.println("please enter the name of the file");
				 str2 = in.nextLine();
				 userCommand.add(1,str2);
				 setChanged();
				 notifyObservers();
				 continue;
			 	}	
			 else if(userCommand.get(0).equals("showListOfMaze")){
				// userCommand.add("showListOfMaze");
				 setChanged();
				 notifyObservers();
				 continue;
			 	}	
			 }
			
	}}).start();}

	public CLI() {
		userCommand = new ArrayList<String>();
		this.in = new BufferedReader(new InputStreamReader(System.in)); 
		this.out = new PrintWriter(System.out); 
		
	}
	

	public void setIn(BufferedReader in) {
		this.in = in;
	}	
	public void setOut(PrintWriter out) {
		this.out = out;
	}
	public void menu()
	{
		 System.out.println("please insert the name of command (key)");
		 System.out.println("1)Dir\n2)generateMaze\n3)displayMaze\n4)showListOfMaze\n5)getCrossSection\n"
		 		+ "6)saveMaze\n7)loadMaze\n8)solveMaze\n9)displaySolution\n10)mazeSize\n11)fileSize");
	}
	/**
	 * this method get a path and display it for user
	 * this method is a solution from Presenter
	 */
	public void displayDir(ArrayList<String> str){
			System.out.println(str);
	}
	/**
	 * this method get a message that the maze is ready and display it for user
	 * this method is a solution from Presenter
	 */
	public void displayMazeReady(String str){
		System.out.println(str);
	}
	/**
	 * this method get a list of mazes3d names and display it for user
	 * this method is a solution from Presenter
	 */
	@Override
	public void displayListOfNamesOfMaze(ArrayList<String> names) {
		for (String name : names){
			System.out.println(name);
		}
		
	}
	/**
	 * this method get an error message and display it for user
	 * this method is a solution from Presenter
	 */
	@Override
	public void displayError(String string) {
		System.out.println(string);
	}
	/**
	 * this method get a name of maze,and the maze himself in array of Integers and display it for user
	 * this method is a solution from Presenter
	 */

	@Override
	public void display3dmaze(int[][][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int j2 = 0; j2 < arr[i][j].length; j2++) {
						System.out.print(arr[i][j][j2]+" ");
				}
				System.out.println();
			}
			System.out.println("\n\n");
		}
		
	}
	/**
	 * this method get a maze2d and display it for user
	 * this method is a solution from Presenter
	 */
	@Override
	public void displayCrossSection(int[][] mat) {
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[j][i]+" ");
			}
			System.out.println();
		}
		notifyObservers();
	}
	/**
	 * this method get a message and display it for user
	 * this method is a solution from Presenter
	 */
	@Override
	public void displayMazeSaved(String string) {
		System.out.println(string);
		
	}
	/**
	 * this method get a message and display it for user
	 * this method is a solution from Presenter
	 */
	@Override
	public void displayMazeLoaded(String string) {
		System.out.println(string);
	}
	/**
	 * this method get a message and display it for user
	 * this method is a solution from Presenter
	 */
	@Override
	public void displaySolveMaze(String string) {
		System.out.println(string);
	}
	/**
	 * this method get a message and display it for user
	 * this method is a solution from Presenter
	 */
	@Override
	public void displaySolution(String string) {
		System.out.println(string);
	}
	/**
	 * this method get a message and display it for user
	 * this method is a solution from Presenter
	 */
	@Override
	public void displayFileSize(String string) {
		System.out.println(string);
	}
	/**
	 * this method get a message and display it for user
	 * this method is a solution from Presenter
	 */
	@Override
	public void displayMazeSize(String string) {
		System.out.println(string);
	}



	@Override
	public void MazeByByteArray(byte[] array) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void displaySolution(Solution sol) {
		// TODO Auto-generated method stub
		
	}
	
	

}
	


				


	 
	 
	 
	 
	
	 
	 

