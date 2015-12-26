package model;

import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.search.Solution;

/**
 * <h1> Common Model </h1>
 * This class is abstract class for "class adapter" design pattern.
 *
 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 */
public abstract class CommonModel extends Observable implements Model {

	
	Maze3dGenerator generator;
	HashMap<String,Maze3d> mazeHash;
	HashMap<String,Maze3d> savedHash;
	HashMap<String,Solution> soulHash;
	HashMap<Maze3d,Solution> mazeAndSHash;
	
	ExecutorService threadPool;
	

	public CommonModel() {
		
		this.mazeHash = new HashMap<String,Maze3d>();
		this.savedHash = new HashMap<String,Maze3d>();
		this.soulHash = new HashMap<String,Solution>();
		this.mazeAndSHash = new HashMap<Maze3d,Solution>();
		threadPool = Executors.newFixedThreadPool(10);
	}


	
	
}
