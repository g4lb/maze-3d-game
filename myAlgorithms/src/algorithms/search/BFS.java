package algorithms.search;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * <h1> BFS class </h1>
 * this class use BFS algorithm to solve the maze by the cheapest way.
 * the BFS use hashSet<State> and PriorityQueue<State> 
 * when the algorithm end and we are on the goal state we return the solution 
 * by back trace from the goal position.
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 *
 */
public class BFS extends CommonSearcher {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Solution search( Searchable s) {
		openList.add(s.getInitialState());
		HashSet<State> closedSet = new HashSet<State>();
		
		while(openList.size()>0){
			State n = popOpenList();
			closedSet.add(n);
			
			if(n.equals(s.getGoulState()))
			{
				System.out.println(this.getNumberOfNodesEvaluated());
				return backTrace(n,s.getInitialState());
			}
			
			ArrayList<State> successors = s.getAllPossibleStates(n);
			for(State state : successors){
				if(!closedSet.contains(state)&&!openList.contains(state))
				{
					state.setComeFrom(n);
					state.setCost(costFromStateToNeighbor(s,n,state));
					openList.add(state);
				}
			//	else {
				else if((costFromStateToNeighbor(s,n,state)<state.getCost())){
							if(!openList.contains(state)){
								openList.add(state);
							}
							else{
								state.setCost(costFromStateToNeighbor(s,n,state));
								state.setComeFrom(n);
							}
						}
					//}
				}
			}
		return  new Solution(null);
	}
	/**
	 * return the back trace from the goal state by the come from method
	 * @param goulState,initialState
	 * @return solution (ArryList<State>)
	 */
	@SuppressWarnings("rawtypes")
	private Solution backTrace(State goulState, State initialState) {
		ArrayList<State> arr = new ArrayList<State>();
		State s = (State) goulState;
		while(s.getComeFrom() != null)
		{
			arr.add(s);
			s=(State) s.getComeFrom();
		}
		Solution sol = new Solution(arr);
		return sol;
	}
	/**
	 * this method calculate the cheapest by 2 nodes who stay in the open list.
	 * @param searchable, s1, s2
	 * @return double cost.
	 */
	@SuppressWarnings("rawtypes")
	public double costFromStateToNeighbor(Searchable searchable, State s1 ,State s2)
	{
		 return (s1.getCost()+s2.getCost());
		//return cost +1;
	}

}
