package algorithms.search;

/**
 * <h1> A* class </h1>
 * this class extend the BFS class and work on <T> (in our case work on position)
 * in A* the calculate function use the heuristic function (air and Manhattan distance)  
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 * @param <T>
 */
public class Astar<T> extends BFS{

	
	public Astar(Heuristic<T> h) {
		super();
		this.h = h;
	}

	private Heuristic<T> h;
	
	/**
	 * over ride the function from BFS by the heuristic.
	 * @param searchable, state1,state2.
	 * @return double calculate by the heuristic function.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public double costFromStateToNeighbor(Searchable searchable, State s1, State s2) {
		double h1 =0;
		double d1 = s1.getCost();
		double d2 = s2.getCost();
		if(s1.equals(searchable.getGoulState()))
		h1 = h.calc(s1, searchable.getGoulState());
		double h2 = h.calc(s2, searchable.getGoulState());
		return Math.abs(d1+d2-h1+h2);

	}
	/**
	 * 
	 * @return this heuristic h.
	 */
	public Heuristic<T> getH() {
		return h;
	}
	/**
	 * set this heuristic h
	 * @param this heuristic h
	 */
	public void setH(Heuristic<T> h) {
		this.h = h;
	}	
	
	
	
	

}
