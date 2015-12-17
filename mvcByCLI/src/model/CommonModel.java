package model;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.search.Solution;
import controller.Controller;

/**
 * <h1> Common Model </h1>
 * This class in abstract class for class adapter design pattern
 * 
 * 
 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 */
public abstract class CommonModel implements Model {

	Controller ctr;
	Maze3dGenerator generator;
	HashMap<String,Maze3d> mazeHash;
	HashMap<String,Maze3d> savedHash;
	HashMap<String,Solution> soulHash;
	ExecutorService threadPool;
	

	public CommonModel(Controller ctr2) {
		this.ctr = ctr2;
		this.mazeHash = new HashMap<String,Maze3d>();
		this.savedHash = new HashMap<String,Maze3d>();
		this.soulHash = new HashMap<String,Solution>();
		threadPool = Executors.newFixedThreadPool(10);
	}


	
	
}
