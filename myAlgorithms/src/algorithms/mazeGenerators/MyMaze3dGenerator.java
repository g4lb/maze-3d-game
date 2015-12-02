package algorithms.mazeGenerators;

import java.util.Random;
import java.util.Stack;

/**
 * <h1> MyMaze3dGenerator </h1>
 * this class present a DFS algorithm
 * 1) take a randomly start and end positions(the z isn't a random Because I do not 
 * want the starting point and the end was near floor ).
 * 2) make a matrix of ons'es
 * 3) use DFS on the matrix to create a tree from the start position to the end.
 * 4) return a maze.
 * @author GalMalca
 * @since 2015-11-07
 * @version 1.0
 */
public class MyMaze3dGenerator extends Generators{
	
	
	
	@Override
	public Maze3d generate(int x, int y, int z) {
		
		this.maze = new Maze3d(z,y,x);
		
		Random rand = new Random();
		int  xRandom = rand.nextInt(x-1) + 0;
		int  yRandom = rand.nextInt(y-1) + 0;
		//int  zRandom = rand.nextInt(z-1) + 0;       
		
		maze.setGoal(xRandom, yRandom, z-1);
		
		xRandom = rand.nextInt(x) + 0;
		yRandom = rand.nextInt(y) + 0;
		//zRandom = rand.nextInt(z) + 0;  
		
		maze.setStart(xRandom, yRandom, 0);
		
		maze.setCorrect(maze.getStart());
		
		//make a matrix of 1
				for(int i=0; i < z ; i++)
				{
					for (int j = 0; j < y; j++) 
					{
						for (int j2 = 0; j2 < x; j2++)
						{
							maze.setMatrix(j2, j, i, 1);
							}
						}
					}
		//start
		maze.setMatrix((maze.getStart()).getX(), (maze.getStart()).getY(), (maze.getStart()).getZ(), 2);
		//end
		maze.setMatrix((maze.getGoal()).getX(), (maze.getGoal()).getY(), (maze.getGoal()).getZ(), 3);
		
		
		
		Stack<Position> stack = new Stack<Position>();
		stack.push(maze.getStart());
		maze.getCorrect().setPai(maze.getStart());
		int flag = 0 ;
		
		while(!(stack.isEmpty()) || (flag != 1))
		{
			int move = rand.nextInt(6) +1;
			switch (move) {
			case 1:    // by z
				Position up = new Position(maze.getCorrect());
				up.setZ(up.getZ()+1);
				if((up.equals(maze.getGoal()))){
					flag = 1;
					break;
				}
				if(maze.cellValueReal(up)){
					if((up.equals(maze.getCorrect().getPai()))){
						Position p = maze.getCorrect().getCopy();
						maze.up();
						maze.getCorrect().setPai(p);
						if(stack.isEmpty()&&(flag !=1 ))
							stack.push(maze.getStart());
						stack.pop();
						break;
					}
					if((maze.numberOfNeighbours(up) <= 1))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.up();
						break;
					}
					if((maze.numberOfNeighbours(up) > 1)&&(maze.cellValue(up) == 0))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.up();
						break;
					}
				}
				
				break;
			case 2:    // by z
				Position down = new Position(maze.getCorrect());
				down.setZ(down.getZ()-1);
				if((down.equals(maze.getGoal()))){
					flag = 1;
					break;
				}
				if(maze.cellValueReal(down)){
					if((down.equals(maze.getCorrect().getPai()))){
						Position p = maze.getCorrect().getCopy();
						maze.down();
						maze.getCorrect().setPai(p);
						if(stack.isEmpty()&&(flag !=1 ))
							stack.push(maze.getStart());
						stack.pop();
						break;
					}
					if((maze.numberOfNeighbours(down) <= 1))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.down();
						break;
					}
					if((maze.numberOfNeighbours(down) > 1)&&(maze.cellValue(down) == 0))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.down();
						break;
					}
				}
				
				break;
			case 3:    // by y
				Position forWord = new Position(maze.getCorrect());
				forWord.setY(forWord.getY()-1);
				if((forWord.equals(maze.getGoal()))){
					flag = 1;
					break;
				}
				if(maze.cellValueReal(forWord)){
					if((forWord.equals(maze.getCorrect().getPai()))){
						Position p = maze.getCorrect().getCopy();
						maze.forward();
						maze.getCorrect().setPai(p);
						if(stack.isEmpty()&&(flag !=1 ))
							stack.push(maze.getStart());
						stack.pop();
						break;
					}
					if((maze.numberOfNeighbours(forWord) <= 1))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.forward();
						break;
					}
					if((maze.numberOfNeighbours(forWord) > 1)&&(maze.cellValue(forWord) == 0))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.forward();
						break;
					}
				}
				
				break;
			case 4:    // by y
				Position backword = new Position(maze.getCorrect());
				backword.setY(backword.getY()+1);
				if((backword.equals(maze.getGoal()))){
					flag = 1;
					break;
				}
				if(maze.cellValueReal(backword)){
					if((backword.equals(maze.getCorrect().getPai()))){
						Position p = maze.getCorrect().getCopy();
						maze.backword();
						maze.getCorrect().setPai(p);
						if(stack.isEmpty()&&(flag !=1 ))
							stack.push(maze.getStart());
						stack.pop();
						break;
					}
					if((maze.numberOfNeighbours(backword) <= 1))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.backword();
						break;
					}
					if((maze.numberOfNeighbours(backword) > 1)&&(maze.cellValue(backword) == 0))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.backword();
						break;
					}
				}
				
				break;
			case 5:    // by x
				Position right = new Position(maze.getCorrect());
				right.setX(right.getX()+1);
				if((right.equals(maze.getGoal()))){
					flag = 1;
					break;
				}
				if(maze.cellValueReal(right)){
					if((right.equals(maze.getCorrect().getPai()))){
						Position p = maze.getCorrect().getCopy();
						maze.right();
						maze.getCorrect().setPai(p);
						if(stack.isEmpty()&&(flag !=1 ))
							stack.push(maze.getStart());
						stack.pop();
						break;
					}
					if(maze.numberOfNeighbours(right) <= 1)
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.right();
						break;
					}
					if((maze.numberOfNeighbours(right) > 1)&&(maze.cellValue(right) == 0))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.right();
						break;
					}
				}
				
				break;
			case 6:    // by x
				Position left = new Position(maze.getCorrect());
				left.setX(left.getX()-1);
				if((left.equals(maze.getGoal()))){
					flag = 1;
					break;
				}
				if(maze.cellValueReal(left)){
					if((left.equals(maze.getCorrect().getPai()))){
						Position p = maze.getCorrect().getCopy();
						maze.left();
						maze.getCorrect().setPai(p);
						if(stack.isEmpty()&&(flag !=1 ))
							stack.push(maze.getStart());
						stack.pop();
						break;
					}
					if((maze.numberOfNeighbours(left) <= 1))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.left();
						break;
					}
					if((maze.numberOfNeighbours(left) > 1)&&(maze.cellValue(left) == 0))
					{
						stack.push(new Position(maze.getCorrect()));
						maze.getCorrect().setPai(maze.getCorrect());
						maze.left();
						break;
					}
				}
				break;

			default:
				break;
			}
		}
		maze.setCorrect(maze.getStart());
		
		return maze;
	}

	
	


}
