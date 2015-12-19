package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import presenter.Presenter;

/**
 * <h1> Class Model </h1>
 * the model is the main struct of the calculation and the activitis,
 * when the view need to to something he's call the controllers and the controllers 
 * call the medel to do it.
 * when the model end his activity he's tell to the view by the controller.
 * 
 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 *
 */
public interface Model {
	
	/**
	 * this method get a path and then shows all the files in path by the client request.
	 * @param path
	 */
	void dir(File path);
	/**
	 * this method get an arrayList of strings that include: nameOfMaze,width,length,dim
	 * and generate a new 3d maze with this parameters.
	 * @param ArrayList<String> for the name of the new maze and the size by x,y,z.
	 */
	void generateMaze(ArrayList<String> string);
	/**
	 * this method get a name of maze and display the 3d maze to user by name's maze
	 * @param ArrayList<String> for the name of the maze
	 */
	void displayMaze(ArrayList<String> string);
	/**
	 * this method shows the list of mazes that create by user
	 * @param string
	 */
	void showListOfMaze(ArrayList<String> string);
	/**
	 * this method has to check if the parameter s is a positive integer
	 * @param Srting s
	 * @return true/false
	 */
	boolean isInteger(String s);
	/**
	 * this method show the cross section of the maze axis.
	 * @param ArrayList<string> for the name of the maze and for the axis (by order).
	 * @throws IOException
	 */
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
	void addObserver(Presenter p);
}
