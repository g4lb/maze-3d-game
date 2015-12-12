package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import algorithms.mazeGenerators.Maze3d;

/**
 * <h1> Class MyController </h1>
 * 
 * @author Gal Ben Evgi
 *
 */
public class MyController extends CommonController {

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
		this.hash.put("getCrossSection", new Command() {
			@Override
			public void doCommand(ArrayList<String> string) {
				m.getCrossSection(string);
			}
		});

		
		
		
	}
	@Override
	public void setSolutionForDir(ArrayList<String> results) {
		v.displayDir(results);
		
	}
	@Override
	public void setReadyMaze(String string, Maze3d maze) {
		v.displayMaze(string,maze);
		
	}
	@Override
	public void crossSectionReady(int[][] mat) {
		v.displayCrossSection(mat);
		
	}



	





}
