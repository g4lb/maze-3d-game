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
	
	public MyProperties(){
		generateAlgo = "DFS";
		solveAlgo = "BFS";
	}
	public MyProperties(String generateAlgo, String solveAlgo, String gameInterface) {
		this.generateAlgo = generateAlgo;
		this.solveAlgo = solveAlgo;
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



	

	
	
	

}
