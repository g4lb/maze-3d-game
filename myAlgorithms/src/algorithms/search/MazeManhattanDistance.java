package algorithms.search;

import algorithms.mazeGenerators.Position;
/**
 * <h1> MazeManhattanDistance class <h1>
 * this class implements Heuristic interface and override the calculate function
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 */
public class MazeManhattanDistance implements Heuristic<Position> {

	/**
	 * this method calculate the distance by manhattan distance.
	 * @param State<Position> start, State<Position> end
	 * @return double 
	 */
	@Override
	public double calc(State<Position> start, State<Position> end) {
		
		double z = (double)Math.abs(start.getState().getZ())-(end.getState().getZ());
		double y = (double)Math.abs(start.getState().getY())-(end.getState().getY());
		double x = (double)Math.abs(start.getState().getX())-(end.getState().getX());
		
		return (x+y+z);
	}

}
