package algorithms.search;

import java.util.ArrayList;
/**
 * <h1> Searchable Interface </h1>
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 * @param <T>
 */
public interface Searchable<T> {

	State<T> getInitialState();
	State<T> getGoulState();
	ArrayList<State<T>> getAllPossibleStates(State<T> s);

}
