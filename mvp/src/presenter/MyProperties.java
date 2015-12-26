package presenter;

import java.io.Serializable;

/**
 * 	
 * @author Gal Ben Evgi
 *
 */
public class MyProperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	
	int numOfThread;
	String generateAlgo;
	String solveAlgo;
	String gameInterface;
	
	public MyProperties(){
		numOfThread = 10;
		generateAlgo = "DFS";
		solveAlgo = "BFS";
		gameInterface = "CLI";
	}
	public MyProperties(int numOfThread, String generateAlgo, String solveAlgo, String gameInterface) {
		this.numOfThread = numOfThread;
		this.generateAlgo = generateAlgo;
		this.solveAlgo = solveAlgo;
		this.gameInterface = gameInterface;
	}
	
	public int getNumOfThread() {
		return numOfThread;
	}

	public void setNumOfThread(int numOfThread) {
		this.numOfThread = numOfThread;
	}

	public String getGenerateAlgo() {
		return generateAlgo;
	}

	public void setGenerateAlgo(String generateAlgo) {
		this.generateAlgo = generateAlgo;
	}

	public String getSolveAlgo() {
		return solveAlgo;
	}

	public void setSolveAlgo(String solveAlgo) {
		this.solveAlgo = solveAlgo;
	}

	public String getGameInterface() {
		return gameInterface;
	}

	public void setGameInterface(String gameInterface) {
		this.gameInterface = gameInterface;
	}

	

	
	
	

}
