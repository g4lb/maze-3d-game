package model;

import java.awt.geom.GeneralPath;
import java.io.File;
import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import controller.Controller;

/**
 * <h1> Class MyModel </h1>
 * @author Gal Ben Evgi
 *
 */
public class MyModel extends CommonModel {

	
	
	
	public MyModel(Controller ctr) {
		super(ctr);
	}



	
	@Override
	public void dir(File path) {
		ArrayList<String> results = new ArrayList<String>();

		//"/path/to/the/directory"
		File[] files = path.listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 

		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}
		
		ctr.setSolutionForDir(results);
		}
	
	@Override
	public void generateMaze(ArrayList<String> s) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int x = Integer.parseInt(s.get(1));
				int y = Integer.parseInt(s.get(2));
				int z = Integer.parseInt(s.get(3));
				generator = new MyMaze3dGenerator();
				Maze3d maze = generator.generate(x,y,z);
				mazeHash.put(s.get(0), maze);
				ctr.setReadyMaze("The maze "+s.get(0)+" is ready", maze);
			}
		}).start();
	}

		
}



	
	
	
	

