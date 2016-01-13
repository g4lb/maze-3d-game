package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.security.auth.callback.LanguageCallback;

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
import algorithms.search.State;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;
import presenter.MyProperties;

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

	ArrayList<String> res;
	byte[] data3;
	int [][] data2;
	MyProperties prop;
	Socket myServer;
	OutputStream outToServer;
	InputStream inFromServer;
	
		
	
	

	
	public MyModel(MyProperties proper, String host, int port) {
		res = new ArrayList<String>();
		this.prop = proper;
		loadFromZip();
		try {
			myServer = new Socket(host, port);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public byte[] getData3() {
		return data3;
	}

	public int[][] getData2() {
		return data2;
	}

	@Override
	public ArrayList<String> getSolution() {
		ArrayList<String> copy = new ArrayList<String>(res);
		res.removeAll(res);
		return copy;
	}
	@Override
	public Solution getSol(String string) {
		return soulHash.get(string);
	}

	/**
	 * this method get a path and then shows all the files in path by the client request.
	 * @param path
	 */
	@Override
	public void dir(File path) {
		ArrayList<String> results = new ArrayList<String>();
		
		results.add("Dir");
		
		//"/path/to/the/directory"
		File[] files = path.listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		if (files!=null){
		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}
		res.addAll(results);
		setChanged();
		notifyObservers();
		}
		else {
			res.add("Error");
			res.add("wrong path!");
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * this method get a name of maze and display the 3d maze to user by name's maze
	 * the method use a new Thread to generate the maze and insert the maze to an hashMap of mazes.
	 * @param ArrayList<String> for the name of the maze
	 */
	@Override
	public void generateMaze(final ArrayList<String> s){
		if(this.mazeHash.containsKey(s.get(1))){
			res.add("Error");
			res.add("This Name of maze is already taken please choose another one");
			setChanged();
			notifyObservers();
			
		}
		else if(!this.isInteger(s.get(2))){
			res.add("Error");
			res.add("generate matrix works with integers positive numbers only!");
			setChanged();
			notifyObservers();
		}
		else if(!this.isInteger(s.get(3))){
			res.add("Error");
			res.add("generate matrix works with integers positive numbers only!");
			setChanged();
			notifyObservers();
		}
		else if(!this.isInteger(s.get(4))){
			res.add("Error");
			res.add("generate matrix works with integers positive numbers only!");
			setChanged();
			notifyObservers();
			}
		else{
			res.add("generateMaze");
			Future<Maze3d> myMaze = threadPool.submit(new Callable<Maze3d>() //TODO
			{ 

				@Override
				public Maze3d call() throws Exception  { 
					
					
					PrintWriter arrayToServer=new PrintWriter(myServer.getOutputStream());															
					arrayToServer.println(s);					
					arrayToServer.flush();		
					Maze3d maze;
					ObjectInputStream mazeFromServer=new ObjectInputStream(myServer.getInputStream());
	
						try{
							byte[] byteArr= (byte[]) mazeFromServer.readObject();
							maze = new Maze3d(byteArr);
							}catch(Exception e)
							{
								e.printStackTrace();
								maze = new Maze3d(0,0,0);
							}
				return maze;
				}
				});
			try{
			mazeHash.put(s.get(1), myMaze.get());
			}
			catch(InterruptedException | ExecutionException e)
			{
				e.printStackTrace();
			}
			res.add("The maze "+s.get(1)+" is ready");
			setChanged();
			notifyObservers();
			}
		}

	/**
	 * this method get a name of maze and display the 3d maze to user by name's maze
	 * @param ArrayList<String> for the name of the maze
	 */
	@Override
	public void displayMaze(ArrayList<String> string) {
		if(this.mazeHash.containsKey(string.get(0))){//TODO new
			res.add("displayMaze");
			data3 = (mazeHash.get(string.get(0)).toByteArray());
			setChanged();
			notifyObservers();
		}
		
		else{
			res.add("Error");
			res.add("the maze " + string.get(0) + " is not exist!");
			setChanged();
			notifyObservers();
		}
	}
	/**
	 * this method send the list of mazes that create by user
	 * @param ArrayList<string>
	 */
	@Override
	public void showListOfMaze(ArrayList<String> string) {
		if(this.mazeHash.isEmpty()){
			res.add("Error");
			res.add("The List is empty");
			setChanged();
			notifyObservers();
		}
		else{
			res.add("showListOfMaze");
			res.addAll(this.mazeHash.keySet());
			setChanged();
			notifyObservers();
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
		if(!mazeHash.containsKey(string.get(1))){
			res.add("Error");
			res.add("there is no maze who call "+string.get(1));
			setChanged();
			notifyObservers();
		}
		else{
		generator.setMaze(mazeHash.get(string.get(1)));
		if(string.get(2).equals("x")){
			res.add("getCrossSection");
			int x = Integer.parseInt(string.get(3));
			data2 = generator.getCrossSectionByX(x);
			setChanged();
			notifyObservers();
			flag=1;
		}
		if(string.get(2).equals("y")){
			res.add("getCrossSection");
			int y = Integer.parseInt(string.get(3));
			data2 =generator.getCrossSectionByY(y);
			setChanged();
			notifyObservers();
			flag=1;
		}
		if(string.get(2).equals("z")){
			res.add("getCrossSection");
			int z = Integer.parseInt(string.get(3));
			data2 =generator.getCrossSectionByZ(z);
			setChanged();
			notifyObservers();
			flag=1;
		}
		else if(flag==0)
		res.add("Error");
		res.add("Error with 2d cross section");
		setChanged();
		notifyObservers();
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
		if(!mazeHash.containsKey(string.get(1))){
			res.add("Error");
			res.add("maze not exist");
			setChanged();
			notifyObservers();
		}
		else {
			res.add("saveMaze");
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(string.get(2)+".maz"));
			out.write(mazeHash.get(string.get(1)).toByteArray());
			Maze3d maze = mazeHash.get(string.get(1));
			savedHash.put(string.get(2), maze);
			out.flush();
			out.close();
			res.add("the maze "+string.get(1)+" saved");
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * this method load the file of the maze and decompres him.
	 * the method load the file from the project dir and becouse of this the playerImg can save the maze
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
			if(!results.contains(string.get(1)+".maz")){
				res.add("Error");
				res.add("the file is not exist");
				setChanged();
				notifyObservers();
			}
			else{
			res.add("loadMaze");
			InputStream in = new MyDecompressorInputStream(new FileInputStream(string.get(1)+".maz"));
			byte[] b = new byte[2000];
			in.read(b);
			in.close();
			Maze3d loaded = new Maze3d(b);
			//loaded.printMatrix();
			mazeHash.put(string.get(2), loaded);
			res.add("the maze "+string.get(2)+" is loaded");
			setChanged();
			notifyObservers();
		}
		
	}

	/**
	 * this method solve the maze by 1 of the algorithms Astar/BFS by the client request
	 * @param ArrayList<string> for the name of the maze and for the algorithm.
	 */
	@Override
	public void solveMaze(final ArrayList<String> string) {
		if(!mazeHash.containsKey(string.get(1))){
			res.add("Error");
			res.add("maze not exist");
			setChanged();
			notifyObservers();
		}
		else{
			res.add("solveMaze");	
			Future<Solution> mySolve = threadPool.submit(new Callable<Solution>() 
			{ 
			
				@Override
				public Solution call() throws Exception { //TODO GAL
					

					PrintWriter arrayToServer=new PrintWriter(myServer.getOutputStream());															
					arrayToServer.println(string);					
					arrayToServer.flush();		
					Solution sol = new Solution();
					String line,line2;
						try{
							
						
							BufferedReader inFromServer=new BufferedReader(new InputStreamReader(myServer.getInputStream()));

							
							ArrayList<String> arr = new ArrayList<>();
							line = inFromServer.readLine();							
							line2 = new String(line.substring(4, line.length()-1));
							StringBuilder sb2 = new StringBuilder();
							StringBuilder sb = new StringBuilder(line2);

							
							
							
							String []parts = sb.toString().split(",");
							for (String string : parts) {
								arr.add(string);
							}
							
							for (int i = 0; i < arr.size(); i++) {
								if(arr.get(i).startsWith("["))
									arr.set(i,arr.get(i).substring(1));
								if(arr.get(i).startsWith(" ["))
									arr.set(i,arr.get(i).substring(2));
								if(arr.get(i).endsWith("]"))
									arr.set(i,arr.get(i).substring(0,arr.get(i).length()-1));
							}
							if(arr.get(0).contains("["))
							{
								arr.set(0, arr.get(0).substring(arr.get(0).length()-1));
							}
							
							
							ArrayList<State> sarr = new ArrayList<>();
							for (int i = 0; i < arr.size(); i+=3) {
								int x = Integer.parseInt(arr.get(i+2));
								int y = Integer.parseInt(arr.get(i+1));
								int z = Integer.parseInt(arr.get(i));
								State<Position> state = new State<Position>(new Position(x, y, z));
								sarr.add(state);
							}
							
							sol = new Solution(sarr);
							
							
							soulHash.put(string.get(1), sol);
							}catch(Exception e)
							{
								e.printStackTrace();
								sol = new Solution(new ArrayList<State>());
							}
						
						return sol;
				}
			});
			try{
				soulHash.put(string.get(1), mySolve.get());
				}
				catch(InterruptedException | ExecutionException e)
				{
					e.printStackTrace();
				}
				res.add("the maze "+string.get(1)+" is solved");
				setChanged();
				notifyObservers();
			}
		}
	


	/**
	 * this method shoe the solution of the solveMaze method.
	 * @param ArrayList<string> for the name of the maze 
	 */
	@Override
	public void displaySolution(ArrayList<String> string) {
		if(soulHash.containsKey(string.get(1))){
			res.add("displaySolution");
			res.add(string.get(1));
			setChanged();
			notifyObservers();
		}
		else if(!soulHash.containsKey(string.get(1))){
			res.add("Error");
			res.add("maze not exist");
			setChanged();
			notifyObservers();
		}
		else{
			res.add("displaySolution");
			res.add(soulHash.get(string.get(1)).toString());
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * this method display file size.
	 * @param ArrayList<string> for the file name 
	 */
	@Override
	public void displayFileSize(ArrayList<String> string) {
		if(!mazeHash.containsKey(string.get(1))){
			res.add("Error");
			res.add("maze not exsist");
			setChanged();
			notifyObservers();
		}
		else{
			res.add("fileSize");
			Integer size = mazeHash.get(string.get(1)).toByteArray().length;
			res.add(size.toString()+" bytes");
			setChanged();
			notifyObservers();
		}
		
	}

	/**
	 * this method display size of maze.
	 * @param ArrayList<string> for the maze name
	 */
	@Override
	public void displayMazeSize(ArrayList<String> string) {
		if(!mazeHash.containsKey(string.get(1))){
			res.add("Error");
			res.add("maze not exsist");
			setChanged();
			notifyObservers();
		}
		else{
			res.add("mazeSize");
			int x = mazeHash.get(string.get(1)).getWidth();
			int y = mazeHash.get(string.get(1)).getHeight();
			int z = mazeHash.get(string.get(1)).getDimension();
			int size = x*y*z;
			res.add("the size of the maze is: "+ size+ " cells");
			setChanged();
			notifyObservers();
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
				//OutputStream out = new MyCompressorOutputStream(new FileOutputStream(string.get(2)+".maz"));
				//FileOutputStream out = new FileOutputStream(new FileOutputStream(mazeAndSHash.)) 
//				GZIPOutputStream zipOut = new GZIPOutputStream(new FileOutputStream("mazeSolutions" + ".zip"));
//				ObjectOutputStream out = new ObjectOutputStream(zipOut);
//				out.writeObject(mazeHash);	
//				out.writeObject(mazeAndSHash);
//				out.flush();
//				out.close();
				
				saveToZip();
				PrintWriter arrayToServer;
				try {
					arrayToServer = new PrintWriter(myServer.getOutputStream());
					
					arrayToServer.println("exit");					
					arrayToServer.flush();	
				} catch (IOException e) {
					e.printStackTrace();
				}						
				
				System.out.println("Giving processes attempt to end...");
				terminated = threadPool.awaitTermination(4, TimeUnit.SECONDS);
				System.out.println("Bye Bye");
				System.exit(1);
				} catch (Exception e) {
			
				e.printStackTrace();
			}
				
		
	}
	private void saveToZip()
	{
		try
		{
			ObjectOutputStream zipMaze = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("mazeSolutionFile.zip")));
			zipMaze.writeObject(mazeAndSHash);
			zipMaze.flush();
			zipMaze.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	private void loadFromZip() {
		ArrayList<String> results = new ArrayList<String>();
		String current;
		try {
			current = new java.io.File( "." ).getCanonicalPath();
			File path = new File(current);
			File[] files = path.listFiles();
			

			for (File file : files) {
			    if (file.isFile()) {
			        results.add(file.getName());
			    }
			}
			if(results.contains("mazeSolutionFile.zip")){
				ObjectInputStream in = new ObjectInputStream(new GZIPInputStream(new FileInputStream("mazeSolutionFile.zip")));
				mazeAndSHash =  (HashMap<Maze3d, Solution>) in.readObject();
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setCorrect(ArrayList<String> arr) {
		String s =arr.get(2);
		String str2 = s.substring(1,s.length()-1);
		String [] items = str2.split(",");
		int z = Integer.parseInt(items[0]);
		int y = Integer.parseInt(items[1]);
		int x = Integer.parseInt(items[2]);
		Position p = new Position(x,y,z);
		mazeHash.get(arr.get(1)).setCorrect(p);
		PrintWriter arrayToServer;
		try {
			arrayToServer = new PrintWriter(myServer.getOutputStream());
			
			arrayToServer.println(arr);					
			arrayToServer.flush();	
		} catch (IOException e) {
			e.printStackTrace();
		}															
		
	}









		
}



	
	
	
	

