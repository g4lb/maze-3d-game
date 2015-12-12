package view;

import java.io.File;
import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;

/**
 * <h1> Class View </h1>
 * @author Gal Ben Evgi
 *
 */
public interface View {

	void start();
	

	void displayDir(ArrayList<String> results);
	void displayListOfNamesOfMaze(ArrayList<String> names);
	void displayError(String string);
	void display3dmaze(String name,int[][][] arr);
	void displayMaze(String string, Maze3d maze);
	void displayCrossSection(int[][] mat);
	
		
		

	
}
