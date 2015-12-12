package model;

import java.io.OutputStream;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import controller.Controller;

public abstract class CommonModel implements Model {

	Controller ctr;
	Maze3dGenerator generator;
	HashMap<String,Maze3d> mazeHash;
	HashMap<String,OutputStream> savedHash;
	

	public CommonModel(Controller ctr2) {
		this.ctr = ctr2;
		this.mazeHash = new HashMap<String,Maze3d>();
		this.savedHash = new HashMap<String,OutputStream>();
	}
	
}
