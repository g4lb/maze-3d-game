package presenter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

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
public class MyPresenter extends CommonPresenter {

	public MyPresenter(Model m, View v) {
		this.m = m;
		this.v = v;
	}
	/**
	 * all the commands for using MVC application design are here.
	 */
	@Override
	public void initCommands() {
		this.hash = new HashMap<String,Command>();
	
		
		this.hash.put("Dir", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) {
				m.dir(new File(string.get(0)));
				
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
		this.hash.put("solveMaze", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) throws IOException {
				m.solveMaze(string);
			}
		});
		this.hash.put("displaySolution", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) throws IOException {
				m.displaySolution(string);
			}
		});
		this.hash.put("fileSize", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) throws IOException {
				m.displayFileSize(string);
			}
		});
		this.hash.put("mazeSize", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) throws IOException {
				m.displayMazeSize(string);
			}
		});
		this.hash.put("exit", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) {
				m.stop();
				
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
	public void setPrint3dMaze(int[][][] arr){
		v.display3dmaze(arr);
		
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void crossSectionReady(int[][] mat) {
		v.displayCrossSection(mat);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void mazeSaved(String string) {
		v.displayMazeSaved(string);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void mazeLoaded(String string) {
		v.displayMazeLoaded(string);	
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void solveMaze(String string) {
		v.displaySolveMaze(string);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void setSolution(String string) {
		v.displaySolution(string);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
	public void setFileSize(String string) {
		v.displayFileSize(string);
	}
	/**
	 * a solution method for the View part in MVC
	 */
	@Override
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
				m.generateMaze(arr);
				break;
			case "displayMaze":
				m.displayMaze(arr);
				break;
			case "showListOfmaze":
				m.showListOfMaze(arr);;
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
		
	}


}