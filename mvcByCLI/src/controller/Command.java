package controller;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1> Class Command</h1>
 * this class will be a 'father' Class of how many commands that we want to create
 * 
* @author Gal Ben Evgi & Gal Malca
 *
 */
public interface Command {


	void doCommand(ArrayList<String> string) throws IOException;
}
