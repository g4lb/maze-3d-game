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
	
	
	String generateAlgo;
	String solveAlgo;
	String gameInterface;
	
	public MyProperties(){
		generateAlgo = "DFS";
		solveAlgo = "BFS";
		gameInterface = "CLI";
	}
	public MyProperties(String generateAlgo, String solveAlgo, String gameInterface) {
		this.generateAlgo = generateAlgo;
		this.solveAlgo = solveAlgo;
		this.gameInterface = gameInterface;
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
