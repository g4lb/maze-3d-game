package view;

import java.util.ArrayList;

import presenter.Presenter;

/**
 * <h1> Class View </h1>
 * display all the solutions/messages from Presenter
 * 
 * 
 * 
 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 *
 */
public interface View {

	void start();
	
	/**
	 * getting a list of files in any dir and display it for the user (getting from Presenter)
	 * @param ArrayList<String> all the files in exist dir
	 */
	void displayDir(ArrayList<String> results);
	/**
	 * getting a message the the maze is ready and display it for user (getting from Presenter)
	 * @param results
	 */
	void displayMazeReady(String str);
	/**
	 * getting a list of maze's that the user create and display it for user (getting from Presenter)
	 * @param arrayList<String> maze's names
	 */
	void displayListOfNamesOfMaze(ArrayList<String> names);
	/**
	 * getting an error message and display it for the user (getting from Presenter)
	 * @param string
	 */
	void displayError(String string);
	/**
	 * getting a maze3d and display it for the user (getting from Presenter)
	 * @param array
	 */
	void display3dmaze(String name,int[][][] arr);
	/**
	 * getting a 2dMatrtix by any cross Section (x,y,z) and display it for the user (getting from Presenter)
	 * @param array
	 */
	void displayCrossSection(int[][] mat);
	/**
	 * getting a message that the maze is been saved and display it for the user (getting from Presenter)
	 * @param string
	 */
	void displayMazeSaved(String string);
	/**
	 * getting a message that the maze is been load and display it for the user (getting from Presenter)
	 * @param string
	 */
	void displayMazeLoaded(String string);
	/**
	 * getting a message that the maze is been saved and display it for the user (getting from Presenter)
	 * @param string
	 */
	void displaySolveMaze(String string);
	/**
	 * getting a string with all the solution moves to ending the maze and display it for the user (getting from Presenter)
	 * @param string
	 */
	void displaySolution(String string);
	/**
	 * getting a string with the file size and display it for the user (getting from Presenter)
	 * @param string
	 */
	void displayFileSize(String string);
	/**
	 * getting a string with all the solution moves to ending the maze and display it for the user (getting from Presenter)
	 * @param string
	 */
	void displayMazeSize(String string);

	void addObserver(Presenter p);

	String getUserCommand();
		
		

	
}
