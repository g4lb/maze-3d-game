package model;

import java.io.File;
import java.util.ArrayList;

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
	public void print() {
		System.out.println("model printing");
		
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
		
	}


	
	
	
	

