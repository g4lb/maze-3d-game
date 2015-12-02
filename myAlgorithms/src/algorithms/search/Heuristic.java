package algorithms.search;
/**
 * <h1> Heuristic Interface </h1>
 * @author GalMalca
 * @since 2015-11-25
 * @version 1.0
 * @param <T>
 */
public interface Heuristic<T> {
	double calc(State<T> start, State<T> end);
}
