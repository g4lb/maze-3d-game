package algorithms.search;

import java.util.PriorityQueue;
/**
 * <h1> CommonSearcher class </h1>
 * this class is the abstract class that simulate a general searcher
 * the class used a priority queue.
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 */
public abstract class CommonSearcher implements Searcher {
	
	@SuppressWarnings("rawtypes")
	protected PriorityQueue<State> openList;
	private int  evaluatedNudes;

	/**
	 * the constructor of the class. 
	 */
	@SuppressWarnings("rawtypes")
	public CommonSearcher()
	{
		openList = new PriorityQueue<State>();
		this.evaluatedNudes = 0;
	}
	/**
	 * pop a state and ++ the evaluated nodes. 
	 * @return the poped state.
	 */
	@SuppressWarnings("rawtypes")
	protected State popOpenList()
	{
		evaluatedNudes++;
		return openList.poll();
	}
	/**
	 * the method of the search that override in the BFS and A* classes
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public abstract Solution search(Searchable s);
	/**
	 * @return the evaluated nodes
	 */
	@Override
	public int getNumberOfNodesEvaluated()
	{
		return evaluatedNudes;
	}

}
