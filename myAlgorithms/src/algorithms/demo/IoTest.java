package algorithms.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

/**
 * <h1> IoTest </h1>
 * This class checked and run the work with files, read & write to files.
 * 
 * @author malcaga
 *
 */
public class IoTest {

	public static void main(String[] args) throws IOException {
		Maze3dGenerator maze1 = new MyMaze3dGenerator();
		System.out.println(maze1.measureAlgorithmTime(5,2, 3)); 
		Maze3d maze = new Maze3d(maze1);
		maze.printMatrix();
	
		
		OutputStream out = new MyCompressorOutputStream(new FileOutputStream("1.maz"));
		out.write(maze.toByteArray());
		out.flush();
		out.close();
		
		InputStream in = new MyDecompressorInputStream(new FileInputStream("1.maz"));
		byte [] b = new byte[maze.toByteArray().length];
		in.read(b);
		in.close();
		
		Maze3d loaded = new Maze3d(b);
		System.out.println(loaded.equals(maze));
	}

}
