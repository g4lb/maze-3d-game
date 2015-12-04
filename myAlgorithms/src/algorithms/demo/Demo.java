package algorithms.demo;

import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.Astar;
import algorithms.search.BFS;
import algorithms.search.Heuristic;
import algorithms.search.Maze3dSearchable;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Searcher;
import algorithms.search.Solution;

public class Demo {

	public void Run() {
		
		/**
		 * the creation of the maze
		 */
		Maze3dGenerator mg = new MyMaze3dGenerator();
		System.out.println(mg.measureAlgorithmTime(4,4, 3)); 
		mg.printMaze();
		
		/**
		 * the BFS search
		 */
		Searcher s2 = new BFS();
		System.out.println("BFS");
		Solution sol2=s2.search(new Maze3dSearchable(mg.getMaze()));
		System.out.println(sol2);
		/**
		 * the heuristic functions
		 */
		Heuristic<Position> h = new MazeAirDistance();
		Heuristic<Position> h1 = new MazeManhattanDistance();
		
		/**
		 * A* by air distance
		 */
		Searcher s1 = new Astar<>(h);
		System.out.println("A* by Air");
		Solution sol1=s1.search(new Maze3dSearchable(mg.getMaze()));
		System.out.println(sol1);
		
		/**
		 * A* by manhattan distance
		 */
		Searcher s3 = new Astar<>(h1);
		System.out.println("A* by Manhattan");
		Solution sol3=s3.search(new Maze3dSearchable(mg.getMaze()));
		System.out.println(sol3);
		
	}

}
