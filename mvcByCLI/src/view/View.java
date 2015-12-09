package view;

import java.io.File;
import java.util.ArrayList;

/**
 * <h1> Class View </h1>
 * @author Gal Ben Evgi
 *
 */
public interface View {

	void start();
	
	void printLearn();

	void displayDir(ArrayList<String> results);
	
}
