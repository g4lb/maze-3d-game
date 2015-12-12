package view;

import java.util.ArrayList;

/**
 * <h1> Class View </h1>
 * @author Gal Ben Evgi
 *
 */
public interface View {

	void start();
	
	void displayDir(ArrayList<String> results);
	void displayMazeReady(String str);
	void displayListOfNamesOfMaze(ArrayList<String> names);
	void displayError(String string);
	void display3dmaze(String name,int[][][] arr);
	void displayCrossSection(int[][] mat);
	void displayMazeSaved(String string);
	void displayMazeLoaded(String string);
		
		

	
}
