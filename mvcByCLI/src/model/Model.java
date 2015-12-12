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
	/**
	 * this method need to solve a maze2d by cross section
	 * @param string
	 */
	void getCrossSection(ArrayList<String> string);
	void saveMaze(ArrayList<String> string) throws IOException;
	void loadMaze(ArrayList<String> string) throws IOException;
}
