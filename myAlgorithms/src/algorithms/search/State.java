package algorithms.search;

/**
 * <h1> State class </h1>
 * this is the main class to our searches, this class make our searches generic by taking an object 
 * and let the maze use him without to know what will be the object .
 * the class implements comparable<T>.
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 * @param <T>
 */
public class State<T> implements Comparable<State<T>>{
	private T state;
	private T comeFrom;
	private double cost;
	
	/**
	 * Cunstractor
	 * @param state
	 */
	public State(T state){
		this.state = state;
	}
	/**
	 * return comefrom(his pai)
	 * @return T
	 */
	public T getComeFrom() {
		return comeFrom;
	}
	/**
	 * set come from (pai)
	 * @param T comeFrom
	 */
	public void setComeFrom(T comeFrom) {
		this.comeFrom = comeFrom;
	}
	/**
	 * return the cost to node
	 * @return double cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * set the cost to node
	 * @param double cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * set state
	 * @param T state
	 */
	public void setState(T state) {
		this.state = state;
	}
	/**
	 * return state
	 * @return T state
	 */
	public T getState()
	{
		return this.state;
	}
	/**
	 * override for eaquals method 
	 * @param Object obj
	 * @return true/false
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj){
		return state.equals(((State)obj).state);
	}
	/**
	 * override to compareTo for the priority queue
	 * @param State<T> o
	 * return 0/1/-1
	 */
	@Override
	public int compareTo(State<T> o) {
		if(this.getCost() > o.getCost())
			return 1;
		else if(this.getCost() < o.getCost())
			return -1;
		else
			return 0;
	}
	/**
	 * override for tostring
	 */
	@Override
	public String toString()
	{
		
		return this.getState().toString();
		
	}
	/**
	 * override for hashCode to the hashset
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	

	

	
}
