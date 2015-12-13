package view;

import java.util.ArrayList;

import controller.Controller;

/**
 * <h1> Class MyView </h1>
 * this class
 * 1)calculate(some problem) - send it for Controller
 * 2)display solution for user - get it from Controller
 * @author Gal Ben Evgi
 *
 */
public class MyView extends CommonView {


	CLI cli;
	
	public MyView(Controller ctr) {
		super(ctr);
		this.cli = new CLI(ctr.getHash());
	}
	
	/**
	 * this method stats the CLI
	 */
	@Override
	public void start() {
		cli.run();	
	}
	/**
	 * this method get a path and display it for user
	 * this method is a solution from Controller
	 */
	public void displayDir(ArrayList<String> str){
			System.out.println(str);
	}
	/**
	 * this method get a message that the maze is ready and display it for user
	 * this method is a solution from Controller
	 */
	public void displayMazeReady(String str){
		System.out.println(str);
	}
	/**
	 * this method get a list of mazes3d names and display it for user
	 * this method is a solution from Controller
	 */
	@Override
	public void displayListOfNamesOfMaze(ArrayList<String> names) {
		for (String name : names){
			System.out.println(name);
		}
		
	}
	/**
	 * this method get an error message and display it for user
	 * this method is a solution from Controller
	 */
	@Override
	public void displayError(String string) {
		System.out.println(string);
	}
	/**
	 * this method get a name of maze,and the maze himself in array of Integers and display it for user
	 * this method is a solution from Controller
	 */

	@Override
	public void display3dmaze(String name,int[][][] arr) {
		System.out.println("The maze: " + name);
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
	 * this method is a solution from Controller
	 */
	@Override
	public void displayCrossSection(int[][] mat) {
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[j][i]+" ");
			}
			System.out.println();
		}
		
	}

	@Override
	public void displayMazeSaved(String string) {
		System.out.println(string);
		
	}

	@Override
	public void displayMazeLoaded(String string) {
		System.out.println(string);
		
	}

	@Override
	public void displaySolveMaze(String string) {
		System.out.println(string);
		
	}
	

	
	


}


