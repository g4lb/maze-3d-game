package algorithms.mazeGenerators;

import java.util.ArrayList;

import algorithms.search.Searchable;
import algorithms.search.State;
/**
 * <h1> Maze3dSearchable class </h1>
 * this class use object adapter by including of Maze3d object in the class
 * the class implements searchable and make his T to be Position  
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 *
 */
public class Maze3dSearchable implements Searchable<Position>{
	
    private Maze3d maze;
    
    /**
     * the cunstractor of the class
     * @param maze
     */
	public Maze3dSearchable(Maze3d maze) {
		super();
		this.maze = maze;
	}
	/**
	 * return the initial state of the maze.
	 * @return State<Position> initial
	 */
	@Override
	public State<Position> getInitialState() {
		State<Position> initial = new State<Position>(maze.getCorrect());
		initial.setCost(0);
		return initial;
	}
	/**
	 * return the goal state of the maze.
	 * @return State<Position> goalstate
	 */
	@Override
	public State<Position> getGoulState() {
		State<Position> goulstate = new State<Position>(maze.getGoal());
		goulstate.setCost(1);
		return goulstate;
	}
	/**
	 * the method return the posibolle moves by the parameter state.
	 * @param State<Position> s
	 * @return ArryList<States<Position>> arr
	 */
	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
		ArrayList<Position> arr = maze.posiboleMoves(s.getState());
		ArrayList<State<Position>> arrStates = new ArrayList<State<Position>>();
		for (int i = 0; i < arr.size(); i++) {
			arrStates.add(i, new State<Position>(arr.get(i)));
			arrStates.get(i).setCost(1);
		}
		return arrStates;
	}


	
	
	
	

}
