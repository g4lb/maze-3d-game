package algorithms.search;
/**
 * <h1> Searcher Interface </h1>
 * this is the main interface of the searches,
 * all the searches override his search method.
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 *
 */
public interface Searcher {
	
	/**
	 * this is the search method
	 * @param searchable s
	 * @return solution
	 */
	@SuppressWarnings("rawtypes")
	public Solution search(Searchable s);
	/**
	 * get how many nodes were evaluated by the algorithm
	 * @return int
	 */
	public int getNumberOfNodesEvaluated();

}
