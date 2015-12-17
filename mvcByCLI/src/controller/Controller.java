package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Model;
import view.View;

/**
 * <h1> Class Controller </h1>
 * The Controller Responsible for transferring commands between the View and the Model
 * 
 * 
 * @author Gal Ben Evgi & Gal Malca
 *
 */
public interface Controller {

	/**
	 * set model method - model will connected to Controller
	 * @param m - any type of model
	 */
	void setModel(Model m);
	/**
	 * set view method - view will connected to Controller
	 * @param v - any type of view
	 */
	void setView(View v);
	/**
	 * method of all exist commands
	 */
	void initCommands();
	/**
	 * get method of all available commands
	 */
	public HashMap<String, Command> getHash();
	/**
	 * this method getting an AraayList with all the names of all the files that are exists and send them to View Class
	 * @param ArrayList<String> results - list of exists files
	 */
	void setSolutionForDir(ArrayList<String> results);
	/**
	 * this method getting a confirm message on success to generate a Maze3d and send it to View Class
	 * @param str - message
	 */
	void setGenerateMaze(String str);
	/**
	 * this method getting a list of exists maze3d and send it to View Class
	 * @param names - list of all names that create by user
	 */
	void setNamesOfMazes(ArrayList<String> names);
	/**
	 * this method getting an error message on and send it to View Class
	 * @param string - message
	 */
	void setErrorToUser(String string);
	/**
	 * this method getting an 3D array of maze,name of maze and send it to View Class
	 * @param name - maze3d's name, maze3d's 3D array
	 */
	void setPrint3dMaze(String name,int[][][] arr);
	/**
	 * this method getting an 2D array of maze by cross section (x,y or z) and send it to View Class
	 * @param mat - maze3d's crossSection
	 */
	void crossSectionReady(int[][] mat);
	/**
	 * this method getting a confirm message on success to save a Maze3d and send it to View Class
	 * @param string - message
	 */
	void mazeSaved(String string);
	/**
	 * this method getting a confirm message on success to load a Maze3d and send it to View Class
	 * @param string - message
	 */
	void mazeLoaded(String string);
	/**
	 * this method getting a confirm message on success to solve a Maze3d and send it to View Class
	 * @param string - message
	 */
	void solveMaze(String string);
	/**
	 * this method getting an algorithm's solution and send it to View Class
	 * @param string - a steps of solution
	 */
	void setSolution(String string);
	/**
	 * this method getting a file size and send it to View Class
	 * @param string - file size
	 */
	void setFileSize(String string);
	/**
	 * this method getting a maze size and send it to View Class
	 * @param string - maze size
	 */
	void setMazeSize(String string);


	

}
