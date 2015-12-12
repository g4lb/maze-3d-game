package algorithms.mazeGenerators;

import java.util.ArrayList;
/**
 * <h1> Maze3dGenerator </h1>
 * the interface of the generators.
 * @author GalMalca
 * @since 2015-11-07
 * @version 1.0
 */
public interface Maze3dGenerator {
	
	/**
	 * this method generate a 3D maze.
	 * @param x,y,z
	 * @return maze
	 */
	Maze3d generate(int x,int y, int z);
	
	/**
	 * this method return us the time of the generate action and get x,y,z because 
	 * the method call to generate.
	 * @param x,y,z
	 * @return string of the generate time
	 */
	String measureAlgorithmTime(int x, int y, int z);
	/**
	 * this method call to maze.print to print the maze.
	 */
	void printMaze();
	/**
	 * this method return the start position of the maze.
	 * @return start position
	 */
	Position getStartPosition();
	/**
	 * return ArryList of possible moves.
	 * @param position
	 * @return ArryList<Position>
	 */
	ArrayList<Position> getPossibleMoves(Position p);
	/**
	 * @return goal position.
	 */
	Position getGoalPosition();
	/**
	 * 
	 * @return correct position.
	 */
	Position getCurectPosition();
	/**
	 * print 2d matrix.
	 * @param 2d mat
	 */
	void print2dMatrix(int[][] mat);
	/**
	 * return 2d matrix by x section.
	 * @param x
	 * @return 2d matrix.
	 */
	int[][] getCrossSectionByX(int x);
	/**
	 * return 2d matrix by y section.
	 * @param y
	 * @return 2d matrix.
	 */
	int[][] getCrossSectionByY(int y);
	/**
	 * return 2d matrix by z section.
	 * @param z
	 * @return 2d matrix.
	 */
	int[][] getCrossSectionByZ(int z);
	/**
	 * 
	 * @return this matrix.
	 */
	Maze3d getMaze();
	void setMaze(Maze3d maze);
}
