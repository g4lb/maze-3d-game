package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * <h1> Solution Class </h1>
 * this class holdes an ArryList<State> that hold the sulotion of the maze by position 
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 *
 */
public class Solution implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2053065824902166212L;
	
	@SuppressWarnings("rawtypes")
	private ArrayList<State> arr;
	
	
	public Solution(Solution sol) {
		this.arr = sol.arr;
	}
	/**
	 * the cunstractor
	 * @param ArryList<state> arr1
	 */
	@SuppressWarnings("rawtypes")
	public Solution(ArrayList<State> arr1)
	{
		arr = arr1;
	}
	/**
	 * return the arr
	 * @return ArryList<state> arr
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<State> getArr() {
		return arr;
	}
	/**
	 * add to the arr.
	 * @param state s
	 */
	@SuppressWarnings("rawtypes")
	public void addToArr(State s) {
		arr.add(s);
	} 
	/**
	 * override for to string.
	 * @return String
	 */
	@Override
	public String toString() {
		return this.arr.toString();
	}
	public Solution() {}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@SuppressWarnings("rawtypes")
	public void setArr(ArrayList<State> arr) {
		this.arr = arr;
	}

}
