package algorithms.search;

import algorithms.mazeGenerators.Position;
/**
 * <h1> MazeAirDistance class <h1>
 * this class implements Heuristic interface and override the calculate function
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 */
public class MazeAirDistance implements Heuristic<Position> {
	/**
	 * this method calculate the distance by air distance.
	 * @param State<Position> start, State<Position> end
	 * @return double 
	 */
	@Override
	public double calc(State<Position> start, State<Position> end) {
		
		double z = (double)Math.pow((end.getState().getZ())-(start.getState().getZ()),2);
		double y = (double)Math.pow((end.getState().getY())-(start.getState().getY()),2);
		double x = (double)Math.pow((end.getState().getX())-(start.getState().getX()),2);
		
		return Math.sqrt(x+y+z);
	}

}
