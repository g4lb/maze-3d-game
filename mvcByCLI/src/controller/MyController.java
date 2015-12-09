package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1> Class MyController </h1>
 * 
 * @author Gal Ben Evgi
 *
 */
public class MyController extends CommonController {



	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initCommands() {
		this.hash = new HashMap<String,Command>();
		
		this.hash.put("print", new Command() {
			
			@Override
			public void doCommand() {
				System.out.println("print");
				m.print();
			}
		});
	this.hash.put("learn", new Command() {
			
			@Override
			public void doCommand() {
				System.out.println("learn");
				v.printLearn();
			}
		});
	this.hash.put("printPath", new Command() {
		
		@Override
		public void doCommand() {
			
			m.dir(new File("C:\\Users\\Gal Ben Evgi\\Documents"));
		}
	});

		
		
		
	}

	@Override
	public void setSolutionForDir(ArrayList<String> results) {
		v.displayDir(results);
		
	}

}
