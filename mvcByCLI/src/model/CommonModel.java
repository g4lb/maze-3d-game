package model;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.search.Solution;
import controller.Controller;

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
