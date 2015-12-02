package algorithms.mazeGenerators;

import java.util.ArrayList;
/**
 * <h1> 3D Maze </h1>
 * Represent a 3D maze.
 * @author GalMalca
 * @since 2015-11-07
 * @version 1.0
 *
 */
public class Maze3d {
	
	
	private int dimension,height,width;
	private Position correct, goal, start;
	protected int [][][] matrix;
	
	/**
	 * the Constructor of the maze.
	 * @param dim
	 * @param height
	 * @param width
	 */
	public Maze3d(int dim, int height, int width) {
		this.dimension = dim;
		this.height = height;
		this.width = width;
		matrix = new int[dim][height][width];
		this.start = new Position(0,0,0);
		this.goal = new Position(0,0,0);
		this.correct = new Position(0,0,0);

	}
	/**
	 * this method make the action of the = operator.
	 * @param x ,y ,z ,value.
	 */
	public void setMatrix(int x, int y, int z, int val)
	{
		matrix[z][y][x] = val;
	}
	/**
	 * this method set a value in a matrix point.
	 * @param position, value
	 */
	public void setMatrix(Position p, int val)
	{
		int x = p.getX();
		int y = p.getY();
		int z = p.getZ();
		matrix[z][y][x] = val;
	}
	/**
	 * 
	 * @return a value from a matrix point.
	 */
	public int[][][] getMatrix()
	{
		return matrix;
	}
	/**
	 * print a 3d matrix by a 3 loops.
	 */
	public void printMatrix()
	{
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < height; j++) {
				for (int j2 = 0; j2 < width; j2++) {
						System.out.print(matrix[i][j][j2]+" ");
				}
				System.out.println();
			}
			System.out.println("\n\n");
		}
	}
	/**
	 * return a list of possible move that we can chose.
	 * @param p source position
	 * @return array list of possible moves (1 to 6 elements)
	 */
	public ArrayList<Position> posiboleMoves(Position p)
	{
		ArrayList<Position> arry = new ArrayList<Position>();
		//StringBuilder moves = new StringBuilder();
		//moves.append("posibole moves:");
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0:
				if((p.getZ() > 0)&&(getDown(p) != 1))
					arry.add((new Position(p.getX(),p.getY(),p.getZ()-1)));
				break;
			case 1:
				if((p.getZ() < (dimension-1)&&(getUp(p) != 1)))
					arry.add((new Position(p.getX(),p.getY(),p.getZ()+1)));
				break;
			case 2:
				if((p.getY() > 0)&&(getForward(p) != 1))
					arry.add((new Position(p.getX(),p.getY()-1,p.getZ())));
				break;
			case 3:
				if((p.getY() < (height-1)&&(getBackward(p) != 1)))
					arry.add((new Position(p.getX(),p.getY()+1,p.getZ())));
				break;
			case 4:
				if((p.getX() > 0)&&(getLeft(p) != 1))
					arry.add((new Position(p.getX()-1,p.getY(),p.getZ())));
				break;
			case 5:
				if((p.getX() < (width-1)&&(getRight(p) != 1)))
					arry.add((new Position(p.getX()+1,p.getY(),p.getZ())));
				break;
			default:
				break;
			}
		}
		return arry;
	}
	/**
	 * give us the value if the cell, 0/1.
	 * @param position
	 * @return value.
	 */
	public int cellValue(Position p)
	{
		int value = matrix[p.getZ()][p.getY()][p.getX()];
			return value;
	}
	/**
	 * check that we are don't exceed from the matrix.
	 * @param position
	 * @return true/false.
	 */
	public boolean cellValueReal(Position p)
	{
		int x = p.getX();
		int y = p.getY();
		int z = p.getZ();
		if((x>=0)&&(y>=0)&&(z>=0)&&(z<dimension)&&(x<width)&&(y<height)){
			int value = matrix[z][y][x];
			if (value == 0||value == 1) {
				return true;
			}
			
		}
		return false;
				
				
	}
	/**
	 * tell us how much 0 neighbors we have.
	 * @param position
	 * @return number of neighbors.
	 */
	public int numberOfNeighbours(Position p) {
		int neighbours = 0;
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0:
				if(p.getZ()== 0)
					break;
				if(getDown(p) == 0)
					neighbours++;
				break;
			case 1:
				if(p.getZ()==(dimension-1))
					break;
				if(getUp(p) == 0)
					neighbours++;
				break;
			case 2:
				if(p.getY()== 0)
					break;
				if(getForward(p) == 0)
					neighbours++;
				break;
			case 3:
				if(p.getY()== (height-1))
					break;
				if(getBackward(p) == 0)
					neighbours++;
				break;
			case 4:
				if(p.getX()== 0)
					break;
				if(getLeft(p) == 0)
					neighbours++;
				break;
			case 5:
				if(p.getX()== (width-1))
					break;
				if(getRight(p) == 0)
					neighbours++;
				break;
			default:
				break;
			}
		}
		return neighbours;
	}
	/**
	 * Returns the position right the @param position
	 * @param position
	 * @return value
	 */
	public int getRight(Position p) {
		int value = matrix[p.getZ()][p.getY()][p.getX()+1];
			return value;
	}
	/**
	 * Returns the position left of the @param position
	 * @param position
	 * @return value
	 */
	public int getLeft(Position p) {
		int value = matrix[p.getZ()][p.getY()][p.getX()-1];
			return value;
	}
	/**
	 * Returns the position right of the @param position
	 * @param position
	 * @return value
	 */
	public int getBackward(Position p) {
		int value = matrix[p.getZ()][p.getY()+1][p.getX()];
			return value;
	}
	/**
	 * get the value of the position in backward of the @param position.
	 * @param position
	 * @return value
	 */
	public int getForward(Position p) {
		int value = matrix[p.getZ()][p.getY()-1][p.getX()];
			return value;
	}
	/**
	 * Returns the position forward the @param position
	 * @param position
	 * @return value
	 */
	public int getUp(Position p) {
		int value = matrix[p.getZ()+1][p.getY()][p.getX()];
			return value;
	}
	/**
	 * Returns the position down of the @param position
	 * @param position
	 * @return value
	 */
	public int getDown(Position p) {
		int value = matrix[p.getZ()-1][p.getY()][p.getX()];
			return value;
	}
	/**
	 * move forward by position
	 */
	public void forward() {
			correct.setY((correct.getY())-1);
			setMatrix(correct, 0);
	}
	/**
	 * move backward by position
	 */
	public void backword() {
			correct.setY(correct.getY()+1);
			setMatrix(correct, 0);
	}
	/**
	 * move right by position
	 */
	public void right() {
			correct.setX(correct.getX()+1);
			setMatrix(correct, 0);
	}
	/**
	 * move left by position
	 */
	public void left() {
			correct.setX(correct.getX()-1);
			setMatrix(correct, 0);
	}
	/**
	 * move up by position
	 */
	public void up() {
			correct.setZ(correct.getZ()+1);
			setMatrix(correct, 0);
	}
	/**
	 * move down by position
	 */
	public void down() {
			correct.setZ(correct.getZ()-1);
			setMatrix(correct, 0);
	}
/**
 * @return start position.
 */
	public Position getStart() {
		return start;
	}
	/**
	 * set the start position of the maze.
	 * @param x, y ,z
	 */
	public void setStart(int x, int y, int z) {
		(this.start).setX(x);
		(this.start).setY(y);
		(this.start).setZ(z);
	}
	/**
	 * 
	 * @return goal position.
	 */
	public Position getGoal() {
		return goal;
	}
	/**
	 * set the goal position of the maze.
	 * @param x,y,z
	 */
	public void setGoal(int x, int y, int z) {
		(this.goal).setX(x);
		(this.goal).setY(y);
		(this.goal).setZ(z);
	}
	/**
	 * return your correct position.
	 * @return correct position
	 */
	public Position getCorrect() {
		return correct;
	}
	/**
	 * set the correct position in the maze by 3 integers.
	 * @param x,y,z.
	 */
	public void setCorrect(int x ,int y, int z) {
		(this.correct).setX(x);
		(this.correct).setY(y);
		(this.correct).setZ(z);
	}
	/**
	 * set the correct position in the maze by position.
	 * @param ppsition
	 */
	public void setCorrect(Position p) {
		correct.setX(p.getX());
		correct.setY(p.getY());
		correct.setZ(p.getZ());
	}
	/**
	 * return the dimension of the maze.
	 * @return dimension
	 */
	public int getDimension() {
		return dimension;
	}
	/**
	 * return the height of the maze.
	 * @return height.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * return the width of the maze.
	 * @return width.
	 */
	public int getWidth() {
		return width;
	}
	
}