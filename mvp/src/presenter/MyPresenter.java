package presenter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

/**
 * <h1> Class MyPresenter </h1>
 * This class getting a problem from View Class and send the problem to Model class
 *  
 * 
 * 
 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 * 
 */
public class MyPresenter  implements Observer{

	protected Model m;
	protected View v;
	HashMap<String,Command> hash;
	
	public MyPresenter(Model m, View v) {
		this.m = m;
		this.v = v;
		hash = new HashMap<String,Command>();
		//initCommands();
	}
	/**
	 * set method
	 * A model
	 */
	public void setModel(Model m) {
		this.m = m;
	}
	/**
	 * set method
	 * A view
	 */
	public void setView(View v) {
		this.v = v;
	}
	/**
	 * get method
	 * hashMap
	 */
	public HashMap<String, Command> getHash() {
		return hash;
	}
	
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void setSolutionForDir(ArrayList<String> results) {
		v.displayDir(results);
		
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void setGenerateMaze(String str) {
		v.displayMazeReady(str);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void setNamesOfMazes(ArrayList<String> names) {
		v.displayListOfNamesOfMaze(names);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void setErrorToUser(String string) {
		v.displayError(string);
		
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void setPrint3dMaze(int[][][] arr){
		v.display3dmaze(arr);
		
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void crossSectionReady(int[][] mat) {
		v.displayCrossSection(mat);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void mazeSaved(String string) {
		v.displayMazeSaved(string);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void mazeLoaded(String string) {
		v.displayMazeLoaded(string);	
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void solveMaze(String string) {
		v.displaySolveMaze(string);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void setSolution(String string) {
		v.displaySolution(string);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void setFileSize(String string) {
		v.displayFileSize(string);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	
	public void setMazeSize(String string) {
		v.displayMazeSize(string);
	}
	@Override
	public void update(Observable o, Object arg) {
		
		if(o == v){
			ArrayList<String> arr = v.getUserCommand();
			switch (arr.get(0)) {
			case "Dir":
				m.dir(new File(arr.get(1)));
				break;
			case "generateMaze":
				try {
					m.generateMaze(arr);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "displayMaze":
				arr.remove(0);
				m.displayMaze(arr);
				break;
			case "exit":
				m.stop();
				break;
			case "showListOfMaze":
				m.showListOfMaze(arr);
				break;
			case "getCrossSection":
				m.getCrossSection(arr);
				break;
			case "saveMaze":
				try {
					m.saveMaze(arr);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "loadMaze":
				try {
					m.loadMaze(arr);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "solveMaze":
				m.solveMaze(arr);;
				break;
			case "displaySolution":
				m.displaySolution(arr);
				break;
			case "mazeSize":
				m.displayMazeSize(arr);
				break;
			case "fileSize":
				m.displayFileSize(arr);;
				break;
			default:
				break;
			}
			}
			if(o == m){
				ArrayList<String> arr1 = m.getSolution();
				switch (arr1.get(0)) {
				case "Error":
					v.displayError(arr1.get(1));
					break;
				case "Dir":
					arr1.remove(0);
					v.displayDir(arr1);
					break;
				case "generateMaze":
					arr1.remove(0);
					v.displayMazeReady(arr1.get(0));
					break;
				case "displayMaze":
					v.display3dmaze(m.getData3());
					break;
				case "showListOfMaze":
					arr1.remove(0);
					v.displayListOfNamesOfMaze(arr1);;
					break;
				case "getCrossSection":
					v.displayCrossSection(m.getData2());
					break;
				case "saveMaze":
					arr1.remove(0);
					v.displayMazeSaved(arr1.get(0));
					break;
				case "loadMaze":
					arr1.remove(0);
					v.displayMazeLoaded(arr1.get(0));
					break;
				case "solveMaze":
					arr1.remove(0);
					v.displaySolveMaze(arr1.get(0));
					break;
				case "displaySolution":
					arr1.remove(0);
					v.displaySolution(arr1.get(0));
					break;
				case "mazeSize":
					arr1.remove(0);
					v.displayMazeSize(arr1.get(0));
					break;
				case "fileSize":
					arr1.remove(0);
					v.displayFileSize(arr1.get(0));
					break;
				default:
					break;
				}
		}
		
	}
	
	

	
}
