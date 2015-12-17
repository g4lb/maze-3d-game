package algorithms.demo;

import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;

/**
 * <h1> Test demo </h1>
 * this class create a maze3d and measure the algorithm time.
 * 
 * @author malcaga
 *
 */
public class TestDemo {
	void Run()
	{
		Maze3dGenerator mg = new MyMaze3dGenerator();
		System.out.println(mg.measureAlgorithmTime(4,4,2)); 
		mg.printMaze();
		mg.getMaze().toByteArray();
		mg.printMaze();
		
		
	}

}
