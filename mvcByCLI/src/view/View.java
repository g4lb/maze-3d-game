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
	

	void displayMaze(String string, Maze3d maze);
	
}
