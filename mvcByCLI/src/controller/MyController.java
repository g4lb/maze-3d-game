package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1> Class MyController </h1>
 * 
 * @author Gal Ben Evgi
 *
 */
public class MyController extends CommonController {

	/**
	 * all the commands for using MVC application design are here.
	 */
	@Override
	public void initCommands() {
		this.hash = new HashMap<String,Command>();
	
		
		this.hash.put("printPath", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) {
				m.dir(new File("C:\\Users\\Gal Ben Evgi\\Documents"));
				
			}
		});
		this.hash.put("generateMaze", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) {
				m.generateMaze(string);
			}
		});
		this.hash.put("displayMaze", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) {
				m.displayMaze(string);
			}
		});
		this.hash.put("showListOfMaze", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) {
				m.showListOfMaze(string);
			}
		});
		this.hash.put("getCrossSection", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) {
				m.getCrossSection(string);
			}
		});
		this.hash.put("saveMaze", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) throws IOException {
				m.saveMaze(string);
			}
		});
		this.hash.put("loadMaze", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) throws IOException {
				m.loadMaze(string);
			}
		});
}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void setSolutionForDir(ArrayList<String> results) {
		v.displayDir(results);
		
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override()
	public void setGenerateMaze(String str) {
		v.displayMazeReady(str);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void setNamesOfMazes(ArrayList<String> names) {
		v.displayListOfNamesOfMaze(names);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void setErrorToUser(String string) {
		v.displayError(string);
		
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void setPrint3dMaze(String name,int[][][] arr){
		v.display3dmaze(name,arr);
		
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void crossSectionReady(int[][] mat) {
		v.displayCrossSection(mat);
		
	}
	@Override
	public void mazeSaved(String string) {
		v.displayMazeSaved(string);
		
	}
	@Override
	public void mazeLoaded(String string) {
		v.displayMazeLoaded(string);
		
	}




	





}
