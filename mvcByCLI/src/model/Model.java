package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1> Class Model </h1>
 * 
 * 
 * @author Gal Ben Evgi
 *
 */
public interface Model {
	
	/**
	 * this method get a path and then she need to shows all files in any path in computer
	 * @param path
	 */
	void dir(File path);
	/**
	 * this method get a arrayList of string that include: nameOfMaze,width,length,dim
	 * and she need to generate a new maze3d with this parameters
	 * @param string
	 */
	void generateMaze(ArrayList<String> string);
	/**
	 * this method get a name of maze and she need to display the maze3d to user by name's maze
	 * @param string
	 */
	void displayMaze(ArrayList<String> string);
	/**
	 * this method need to shows the list of maze that create by user
	 * @param string
	 */
	void showListOfMaze(ArrayList<String> string);
	/**
	 * this method has to check if the parameter s is a positive integer
	 * @param s
	 * @return true/false
	 */
	boolean isInteger(String s);
	void getCrossSection(ArrayList<String> string);
	/**
	 * this method save the maze into a file to the project dir and use decompresor to zip the file.
	 * @param ArrayList<string> for the name of the maze and te new name for the file (by order).
	 * @throws IOException
	 */
	void saveMaze(ArrayList<String> string) throws IOException;
	/**
	 * this method load the file of the maze and decompres him.
	 * the method load the file from the project dir and becouse of this the player can save the maze
	 * and play him any time.
	 * @param ArrayList<string> for the name of the loaded maze and for the file name(by order)
	 * @throws IOException
	 */
	void loadMaze(ArrayList<String> string) throws IOException;
	/**
	 * this method solve the maze by 1 of the algorithms Astar/BFS by the client request
	 * @param ArrayList<string> for the name of the maze and for the algorithm.
	 */
	void solveMaze(ArrayList<String> string);
	/**
	 * this method shoe the solution of the solveMaze method.
	 * @param ArrayList<string> for the name of the maze 
	 */
	void displaySolution(ArrayList<String> string);
	/**
	 * this method display file size.
	 * @param ArrayList<string> for the file name 
	 */
	void displayFileSize(ArrayList<String> string);
	/**
	 * this method display size of maze.
	 * @param ArrayList<string> for the maze name
	 */
	void displayMazeSize(ArrayList<String> string);
	/**
	 * this method make a safty exit from the program
	 */
	void stop();
}
