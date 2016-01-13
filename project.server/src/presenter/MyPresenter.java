package presenter;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.text.AbstractDocument.LeafElement;

import model.ClientHandler;
import model.Model;
import view.View;

/**
 * <h1> Class MyPresenter </h1>
 * This class getting a problem from View Class and send the problem to Model class
 *  
 * 
 * 
 * @author Gal Ben Evgi & Gal Malca
 * @since 2015-12-17
 * @version 1.0
 * 
 */
public class MyPresenter  implements Observer{

	protected Model m;
	protected View v;
	ClientHandler ch;
	Object data;
	
	
	
	public MyPresenter(Model m, View v, ClientHandler ch) {
		this.m = m;
		this.v = v;
		this.ch = ch;
	}
	/**
	 * set method
	 * A model
	 */
	public void setModel(Model m) {
		this.m = m;
	}
	/**
	 * set method
	 * A view
	 */
	public void setView(View v) {
		this.v = v;
	}

	

	@Override
	public void update(Observable o, Object arg) {
		
		if(o == ch){
			ArrayList<String> arr = ch.getUserCommand();
			
			switch (arr.get(0)) {

			case "generateMaze":
				try {
					m.generateMaze(arr);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				break;
			case "displayMaze":
				arr.remove(0);
				m.displayMaze(arr);
				break;
			case "exit":
				m.stop();
				break;
			case "saveMaze":
				try {
					m.saveMaze(arr);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "loadMaze":
				try {
					m.loadMaze(arr);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "solveMaze":
				m.solveMaze(arr);;
				break;
			case "displaySolution":
				m.displaySolution(arr);
				break;
			case "setCorrect":
				m.setCorrect(arr);
				break;
			default:
				break;
			}
			}
			if(o == m){
				ArrayList<String> arr1 = m.getSolution();
				switch (arr1.get(0)) {
				case "Error":
						//out.writeObject("Error");
					break;
				case "generateMaze":
						arr1.remove(0);
						m.displayMaze(arr1);					
					break;
				case "displayMaze":
						data = m.getData3();
						ch.writeWithOut(data);
					break;
				case "saveMaze":
						//out.writeObject(arr1);
					break;
				case "loadMaze":
					//	out.writeObject(arr1);
					break;
				case "solveMaze":
						//out.writeObject(arr1);
					break;
				case "displaySolution":
						//out.writeObject(arr1);
					break;
				default:
					break;
					
				}
		}
		
	}
	public Object getData() {
		return data;
	}
	
	

	
}
