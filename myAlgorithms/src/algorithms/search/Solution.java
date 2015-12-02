package algorithms.search;

import java.util.ArrayList;
/**
 * <h1> Solution Class </h1>
 * this class holdes an ArryList<State> that hold the sulotion of the maze by position 
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 *
 */
public class Solution {
	
	@SuppressWarnings("rawtypes")
	private ArrayList<State> arr;
	
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

}
