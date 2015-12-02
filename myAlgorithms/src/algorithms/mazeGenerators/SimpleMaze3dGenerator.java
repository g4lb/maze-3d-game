package algorithms.mazeGenerators;

import java.util.Random;

/**
 * <h1> SimpleMaze3dGenerator class </h1>
 * this class present a naive algorithm
 * 1) take a arbitrary start and end positions
 * 2) make a matrix of ons'es
 * 3) go to the end and make 0(way) in her track.
 * 4) return a maze.
 * @author GalMalca
 * @since 2015-11-07
 * @version 1.0
 */
public class SimpleMaze3dGenerator extends Generators {
	
	

	@Override
	public Maze3d generate(int x, int y, int z) {
		
		this.maze = new Maze3d(z,y,x);
		maze.setStart(0, 0, 0);
		
		//make matrix of 1s
		for(int i=0; i < z ; i++)
		{
			for (int j = 0; j < y; j++) 
			{
				for (int j2 = 0; j2 < x; j2++)
				{
					maze.setMatrix(j2, j, i, 1);
				}
			}
			maze.setMatrix(0, 0, i, 0);
			maze.setCorrect(0,0,i);
		}
		
		Random rand = new Random();
		int jx = 0,jy = 0;
		
		
		//make way
		while ( (jx+jy) < (x+y)-2 ) {
			int  n = rand.nextInt(2) + 1;
			switch (n) {
			case 1:
				if(jx == (x-1))
					break;
				maze.setMatrix(jx, jy, z-1, 0);
				jx++;
				break;
			case 2:
				if(jy == (y-1))
					break;
				maze.setMatrix(jx, jy, z-1, 0);
				jy++;
				break;

			default:
				break;
			}
			
			}
		maze.setMatrix(x-1, y-1, z-1, 0);
		maze.setGoal(jx, jy, z);
		return maze;
	}

}
