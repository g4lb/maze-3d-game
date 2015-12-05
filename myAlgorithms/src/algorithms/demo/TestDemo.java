package algorithms.demo;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class TestDemo {
	void Run()
	{
		Maze3dGenerator mg = new MyMaze3dGenerator();
		System.out.println(mg.measureAlgorithmTime(4,4,2)); 
		mg.printMaze();
		mg.getMaze().toByteArray();
		Maze3d mg2 = new Maze3d(mg.getMaze().toByteArray());
		mg.printMaze();
		
		
	}

}
