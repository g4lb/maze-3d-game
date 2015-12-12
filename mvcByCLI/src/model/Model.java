package model;

import java.io.File;
import java.util.ArrayList;

/**
 * <h1> Class Model </h1>
 * 
 * 
 * @author Gal Ben Evgi
 *
 */
public interface Model {
	
	void dir(File path);
	void generateMaze(ArrayList<String> string);
	void getCrossSection(ArrayList<String> string);

}
