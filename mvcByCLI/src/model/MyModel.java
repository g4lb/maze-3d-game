package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dSearchable;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.Astar;
import algorithms.search.BFS;
import algorithms.search.Heuristic;
import algorithms.search.MazeAirDistance;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

/**
 * <h1> Class MyModel </h1>
 * this class is a model class for a 3d maze.
 * all the overRides are for maze3d game.
 * 
 * 
 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 */
public class MyModel extends CommonModel {

	
	
	/**
	 * the C'tor of the class.
	 * @param Controller 
	 */
	public MyModel(Controller ctr) {
		super(ctr);
	}

	/**
	 * this method get a path and then shows all the files in path by the client request.
	 * @param path
	 */
	@Override
	public void dir(File path) {
		ArrayList<String> results = new ArrayList<String>();
		
		//"/path/to/the/directory"
		File[] files = path.listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		if (files!=null){
		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}
		ctr.setSolutionForDir(results);
		}
		else 
			ctr.setErrorToUser("wrong path!");
	}
	/**
	 * this method get a name of maze and display the 3d maze to user by name's maze
	 * the method use a new Thread to generate the maze and insert the maze to an hashMap of mazes.
	 * @param ArrayList<String> for the name of the maze
	 */
	@Override
	public void generateMaze(final ArrayList<String> s){
		if(this.mazeHash.containsKey(s.get(0)))
			ctr.setErrorToUser("This Name of maze is already taken please choose another one");
		else if(!this.isInteger(s.get(1)))
			ctr.setErrorToUser("generate matrix works with integers positive numbers only!");
		else if(!this.isInteger(s.get(2)))
			ctr.setErrorToUser("generate matrix works with integers positive numbers only!");
		else if(!this.isInteger(s.get(3)))
			ctr.setErrorToUser("generate matrix works with integers positive numbers only!");
		else{
			this.threadPool.execute(new Runnable() {
			@Override
			public void run() {
				
				
				int x = Integer.parseInt(s.get(1));
				int y = Integer.parseInt(s.get(2));
				int z = Integer.parseInt(s.get(3));
				
				generator = new MyMaze3dGenerator();
				Maze3d maze = generator.generate(x,y,z);
				mazeHash.put(s.get(0), maze);
				ctr.setGenerateMaze("The maze "+s.get(0)+" is ready");
			}
		});
		}
	}

	/**
	 * this method get a name of maze and display the 3d maze to user by name's maze
	 * @param ArrayList<String> for the name of the maze
	 */
	@Override
	public void displayMaze(ArrayList<String> string) {
		if(this.mazeHash.containsKey(string.get(0))){
			ctr.setPrint3dMaze(string.get(0),mazeHash.get(string.get(0)).getMatrix());
		}
		
		else
			ctr.setErrorToUser("the maze " + string.get(0) + " is not exist!");
		
	}
	/**
	 * this method send the list of mazes that create by user
	 * @param ArrayList<string>
	 */
	@Override
	public void showListOfMaze(ArrayList<String> string) {
		if(this.mazeHash.isEmpty())
			ctr.setErrorToUser("The List is empty");
		else{
			ArrayList<String> list = new ArrayList<String>(this.mazeHash.keySet());
			ctr.setNamesOfMazes(list);
		}
	}
	/**
	 * this method show the cross section of the maze axis.
	 * the method use maze.getCrossSection...
	 * @param ArrayList<string> for the name of the maze and for the axis (by order).
	 * @throws IOException
	 */
	@Override
	public void getCrossSection(ArrayList<String> string) {
		int flag=0;
		if(!mazeHash.containsKey(string.get(0)))
			System.out.println("Error: there is no maze who call "+string.get(0));
		else{
		generator.setMaze(mazeHash.get(string.get(0)));
		if(string.get(1).equals("x")){
			int x = Integer.parseInt(string.get(2));
			int[][] mat = generator.getCrossSectionByX(x);
			ctr.crossSectionReady(mat);
			flag=1;
		}
		if(string.get(1).equals("y")){
			int y = Integer.parseInt(string.get(2));
			int[][] mat =generator.getCrossSectionByY(y);
			ctr.crossSectionReady(mat);
			flag=1;
		}
		if(string.get(1).equals("z")){
			int z = Integer.parseInt(string.get(2));
			int[][] mat =generator.getCrossSectionByZ(z);
			ctr.crossSectionReady(mat);
			flag=1;
		}
		else if(flag==0)
		System.out.println("Error");
		}
		
	}
	
	/**
	 * this method has to check if the parameter s is a positive integer
	 * @param Srting s
	 * @return true/false
	 */
	@Override
	public boolean isInteger(String s) {
		   try { 
		        Integer.parseInt(s); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    } catch(NullPointerException e) {
		        return false;
		    }
		   int x = Integer.parseInt(s);
	        if(x <= 0){
	        	return false;
	        }
		    // only got here if we didn't return false
		    return true;
	}

	/**
	 * this method save the maze into a file to the project dir and use decompresor to zip the file.
	 * @param ArrayList<string> for the name of the maze and te new name for the file (by order).
	 * @throws IOException
	 */
	@Override
	public void saveMaze(ArrayList<String> string) throws IOException {
		if(!mazeHash.containsKey(string.get(0)))
			ctr.setErrorToUser("maze not exist");
		else {
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(string.get(1)+".maz"));
			out.write(mazeHash.get(string.get(0)).toByteArray());
			Maze3d maze = mazeHash.get(string.get(0));
			savedHash.put(string.get(1), maze);
			out.flush();
			out.close();
			ctr.mazeSaved("the maze "+string.get(0)+" saved");
			
		}
	}

	/**
	 * this method load the file of the maze and decompres him.
	 * the method load the file from the project dir and becouse of this the player can save the maze
	 * and play him any time.
	 * @param ArrayList<string> for the name of the loaded maze and for the file name(by order)
	 * @throws IOException
	 */
	@Override
	public void loadMaze(ArrayList<String> string) throws IOException  {

			ArrayList<String> results = new ArrayList<String>();
			String current = new java.io.File( "." ).getCanonicalPath();
			File path = new File(current);
			File[] files = path.listFiles();
			

			for (File file : files) {
			    if (file.isFile()) {
			        results.add(file.getName());
			    }
			}
			if(!results.contains(string.get(0)+".maz"))
				ctr.setErrorToUser("the file is not exist");
			else{
			InputStream in = new MyDecompressorInputStream(new FileInputStream(string.get(0)+".maz"));

			byte[] b = new byte[2000];
			in.read(b);
			in.close();
			Maze3d loaded = new Maze3d(b);
			loaded.printMatrix();
			mazeHash.put(string.get(1), loaded);
			ctr.mazeLoaded("the maze "+string.get(1)+" is loaded");
		}
		
	}

	/**
	 * this method solve the maze by 1 of the algorithms Astar/BFS by the client request
	 * @param ArrayList<string> for the name of the maze and for the algorithm.
	 */
	@Override
	public void solveMaze(final ArrayList<String> string) {
		if(!mazeHash.containsKey(string.get(0)))
			ctr.setErrorToUser("maze not exist");
		else if(!string.get(1).equals("BFS")&&!string.get(1).equals("Astar"))
			ctr.setErrorToUser("algorithm not exist!");
		
		else{
			this.threadPool.execute(new Runnable() {
			
				@Override
				public void run() {
			generator.setMaze(mazeHash.get(string.get(0)));
			if(string.get(1).equals("BFS")){
				Searcher s2 = new BFS();
				Solution sol = s2.search(new Maze3dSearchable(generator.getMaze()));
				soulHash.put(string.get(0),sol);
				ctr.solveMaze("the maze "+string.get(0)+" is solved");
			}
			else {
				Heuristic<Position> h = new MazeAirDistance();
				Searcher s2 = new Astar<>(h);
				Solution sol = s2.search(new Maze3dSearchable(generator.getMaze()));
				soulHash.put(string.get(0),sol);
				ctr.solveMaze("the maze "+string.get(0)+" is solved");
			}
			
			
				}
			});
		}
		
	}

	/**
	 * this method shoe the solution of the solveMaze method.
	 * @param ArrayList<string> for the name of the maze 
	 */
	@Override
	public void displaySolution(ArrayList<String> string) {
		if(!soulHash.containsKey(string.get(0)))
			ctr.setErrorToUser("maze not exist");
		else{
			ctr.setSolution(soulHash.get(string.get(0)).toString());
		}
	}

	/**
	 * this method display file size.
	 * @param ArrayList<string> for the file name 
	 */
	@Override
	public void displayFileSize(ArrayList<String> string) {
		if(!mazeHash.containsKey(string.get(0)))
			ctr.setErrorToUser("maze not exsist");
		else{
			Integer size = mazeHash.get(string.get(0)).toByteArray().length;
			ctr.setFileSize(size.toString()+" bytes");
		}
		
	}

	/**
	 * this method display size of maze.
	 * @param ArrayList<string> for the maze name
	 */
	@Override
	public void displayMazeSize(ArrayList<String> string) {
		if(!mazeHash.containsKey(string.get(0)))
			ctr.setErrorToUser("maze not exsist");
		else{
			int x = mazeHash.get(string.get(0)).getWidth();
			int y = mazeHash.get(string.get(0)).getHeight();
			int z = mazeHash.get(string.get(0)).getDimension();
			int size = x*y*z;
			ctr.setMazeSize("the maze size is: "+ size);
		}
	}
	
	/**
	 * this method make a safty exit from the program
	 */
	@Override
	public void stop() {
		threadPool.shutdown();
		boolean terminated = false;
		while(!terminated)
			try {
				System.out.println("Giving processes attempt to end...");
				terminated = threadPool.awaitTermination(5, TimeUnit.SECONDS);
				System.out.println("Bye Bye");
				System.exit(1);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
				
		
	}

	
	
	
		
}



	
	
	
	

