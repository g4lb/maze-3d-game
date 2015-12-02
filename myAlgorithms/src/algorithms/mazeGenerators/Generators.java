package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * <h1> Generators class </h1>
 * this class extended by the generators of the maze
 * this class also realize the shared methods of the maze generators
 * @author GalMalca
 * @version 1.0
 * @since 2015-11-07
 */
public abstract class Generators implements Maze3dGenerator {
	
	protected Maze3d maze;
	
	/**
	 * print a 3d maze
	 */
	@Override
	public void printMaze() {
		maze.printMatrix();
	}
	/**
	 * calculate the time to generate the maze and and generate the maze.
	 * @param dimension,height,width to create the maze.
	 * @return total time of the generate.
	 */
	@Override
	public String measureAlgorithmTime(int x, int y, int z) {
		long start = System.currentTimeMillis();
		generate(x,y,z);
		long end = System.currentTimeMillis();
		String totalTime = new String();
		long total = end-start;
		totalTime = String.valueOf(total);

		return totalTime;
	}
	/**
	 * @return the start position
	 */
	@Override
	public Position getStartPosition() {
		return maze.getStart();
	}
	/**
	 * @return the correct position
	 */
	@Override
	public Position getCurectPosition(){
		return maze.getCorrect();
	}
	/**
	 * check the possible moves from your position.
	 * @param position
	 * @return ArryList<Position>.
	 */
	@Override
	public ArrayList<Position> getPossibleMoves(Position p) {
		ArrayList<Position> posibleMoves = new ArrayList<Position>();
		posibleMoves = maze.posiboleMoves(maze.getCorrect());
		return posibleMoves;
	}
	/**
	 * @return the goal position.
	 */
	@Override
	public Position getGoalPosition() {
		return maze.getGoal();
	}
	/**
	 * print 2d matrix.
	 * @param 2d matrix.
	 */
	public void print2dMatrix(int[][] mat)
	{
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[j][i]+" ");
			}
			System.out.println();
		}
	}
	/**
	 * return a 2d matrix by cross section of the x axis.
	 *  @param the x of the axis
	 *  @return 2d matrix.
	 */
	@Override
	public int[][] getCrossSectionByX(int x) {
		if(x>=maze.getWidth()) {
			throw new IndexOutOfBoundsException("Index out of bounds exception");
		}
		int [][][] mat = maze.getMatrix();
		int[][] mat2 = new int[maze.getDimension()][maze.getHeight()]; 
		for(int i = 0; i<maze.getHeight();i++)
		{
			for (int j = 0; j < maze.getDimension(); j++) {
				mat2[j][i] = mat[j][i][x];
			}
		}
		return mat2;
	}
	/**
	 * return a 2d matrix by cross section of the y axis.
	 *  @param the y of the axis
	 *  @return 2d matrix.
	 */
	@Override
	public int[][] getCrossSectionByY(int y) {
		if(y>=maze.getHeight()) {
			throw new IndexOutOfBoundsException("Index out of bounds exception");
		}
		int [][][] mat = maze.getMatrix();
		int[][] mat2 = new int[maze.getDimension()][maze.getWidth()]; 
		for(int i = 0; i<maze.getWidth();i++)
		{
			for (int j = 0; j < maze.getDimension(); j++) {
				mat2[j][i] = mat[j][y][i];
			}
		}
		return mat2;
	}
	/**
	 * return a 2d matrix by cross section of the z axis.
	 *  @param the z of the axis
	 *  @return 2d matrix.
	 */
	@Override
	public int[][] getCrossSectionByZ(int z) {
		if(z>=maze.getDimension()) {
			throw new IndexOutOfBoundsException("Index out of bounds exception");
		}
		int [][][] mat = maze.getMatrix();
		int[][] mat2 = new int[maze.getWidth()][maze.getHeight()]; 
		for(int i = 0; i<maze.getHeight();i++)
		{
			for (int j = 0; j < maze.getWidth(); j++) {
				mat2[j][i] = mat[z][i][j];
			}
		}
		return mat2;
	}
	/**
	 * @return this maze.
	 */
	public Maze3d getMaze(){
		return this.maze;
	}
}
