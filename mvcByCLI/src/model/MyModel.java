package model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import controller.Controller;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

/**
 * <h1> Class MyModel </h1>
 * @author Gal Ben Evgi
 * the methods in class:
 * 1)get a problem from Controller - any problem
 * 2)solve the problem
 * 3)send the solution for Controller
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
	//to generate the is maze data mumber so we need to change this method
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
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				
				int x = Integer.parseInt(s.get(1));
				int y = Integer.parseInt(s.get(2));
				int z = Integer.parseInt(s.get(3));
				
				generator = new MyMaze3dGenerator();
				Maze3d maze = generator.generate(x,y,z);
				mazeHash.put(s.get(0), maze);
				ctr.setGenerateMaze("The maze "+s.get(0)+" is ready");
				//ctr.setReadyMaze("The maze "+s.get(0)+" is ready", maze);
			}
		}).start();
		}
	}
	
	@Override
	public void displayMaze(ArrayList<String> string) {
		if(this.mazeHash.containsKey(string.get(0))){
			//ctr.setReadyMaze(string.get(0),mazeHash.get(string.get(0)));
			ctr.setPrint3dMaze(string.get(0),mazeHash.get(string.get(0)).getMatrix());
		}
		
		else
			ctr.setErrorToUser("the maze " + string.get(0) + " is not exist!");
		
	}
	
	@Override
	public void showListOfMaze(ArrayList<String> string) {
		if(this.mazeHash.isEmpty())
			ctr.setErrorToUser("The List is empty");
		else{
			ArrayList<String> list = new ArrayList<String>(this.mazeHash.keySet());
			ctr.setNamesOfMazes(list);
		}
	}



	//name,{x,y,z},index
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




	@Override
	public void saveMaze(ArrayList<String> string) throws IOException {
		if(!mazeHash.containsKey(string.get(0)))
			ctr.setErrorToUser("maze not exist");
		else {
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(string.get(1)+".maz"));
			out.write(mazeHash.get(string.get(0)).toByteArray());
			savedHash.put(string.get(0), out);
			out.flush();
			out.close();
			ctr.mazeSaved("the maze "+string.get(0)+" saved");
			
		}
	}




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
			
			File file =new File(current+ "/"+string.get(0)+".maz");
			System.out.println(file.length());
			
			byte [] b = new byte[(int) file.length()];
			in.read(b);
			in.close();
			Maze3d loaded = new Maze3d(b);
			loaded.printMatrix();
			mazeHash.put(string.get(1), loaded);
			ctr.mazeLoaded("the maze "+string.get(1)+" is loaded");
		}
		
	}	
	

		
}



	
	
	
	

