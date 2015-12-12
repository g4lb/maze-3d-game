package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Model;
import view.View;

/**
 * <h1> Class Controller </h1>
 * The Controller Responsible for transferring commands between the View and the Model
 * @author Gal Ben Evgi
 *
 */
public interface Controller {

	void setModel(Model m);
	void setView(View v);
	void initCommands();
	public HashMap<String, Command> getHash();
	void setSolutionForDir(ArrayList<String> results);
	void setGenerateMaze(String str);
	void setNamesOfMazes(ArrayList<String> names);
	void setErrorToUser(String string);
	void setPrint3dMaze(String name,int[][][] arr);
	void crossSectionReady(int[][] mat);


	

}
